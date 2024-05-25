package com.example.exercises;

import com.example.dao.CountryDao;
import com.example.dao.InMemoryWorldDao;
import com.example.domain.Country;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 *
 */
public class Exercise15 {
	private static final CountryDao countryDao = InMemoryWorldDao.getInstance();

	public static void main(String[] args) {
		// Grocup the countries by continent, and then sort the countries in each continent by number of cities in each country.
		Map<String, List<Country>> countriesMap = countryDao.findAllCountries().stream()
				.sorted(Comparator.comparing(country -> country.getCities().size()))
				.collect(Collectors.groupingBy(Country::getContinent, Collectors.toList()));

		countriesMap.forEach((k,v) -> System.out.println(k + " : " + v));



	}

}
