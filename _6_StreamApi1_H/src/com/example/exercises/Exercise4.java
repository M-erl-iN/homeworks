package com.example.exercises;

import com.example.dao.CityDao;
import com.example.dao.CountryDao;
import com.example.dao.InMemoryWorldDao;
import com.example.domain.City;
import com.example.domain.Country;

import java.util.Collection;
import java.util.Comparator;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * 
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 *
 */
public class Exercise4 {
	private static final CountryDao countryDao = InMemoryWorldDao.getInstance();
	private static final CityDao cityDao = InMemoryWorldDao.getInstance();

	public static void main(String[] args) {
		// Find the highest populated capital city
		final Collection<Country> countries = countryDao.findAllCountries();
		CityPopulationPair cpp = countries.stream()
				.map(country -> cityDao.findCityById(country.getCapital()))
				.filter(Objects::nonNull)
				.map(capital -> new CityPopulationPair(capital, capital.getPopulation()))
				.max(Comparator.comparing(CityPopulationPair::population)).get();
		System.out.println(cpp);

	}

}
