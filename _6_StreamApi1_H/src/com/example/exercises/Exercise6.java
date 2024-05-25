package com.example.exercises;

import com.example.dao.CityDao;
import com.example.dao.CountryDao;
import com.example.dao.InMemoryWorldDao;
import com.example.domain.Country;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 *
 */
public class Exercise6 {
	private static final CountryDao countryDao = InMemoryWorldDao.getInstance();
	private static final CityDao cityDao = InMemoryWorldDao.getInstance();

	public static void main(String[] args) {
		// Sort the countries by number of their cities in descending order
		final Collection<Country> countries = countryDao.findAllCountries();
		List<Country> countriesSortedByNumberOfCity = countries.stream()
				.map(country -> new CountryCityCountPair(country,cityDao.findCitiesByCountryCode(country.getCode()).size()))
				.sorted(Comparator.comparing(CountryCityCountPair::count).reversed())
				.map(ccp -> ccp.country())
				.collect(Collectors.toList());

		countriesSortedByNumberOfCity.forEach(System.out::println);

	}
}
