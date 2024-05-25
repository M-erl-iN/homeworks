package com.example.exercises;

import com.example.dao.CountryDao;
import com.example.dao.InMemoryWorldDao;
import com.example.dao.WorldDao;
import com.example.domain.City;
import com.example.domain.Country;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * 
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 *
 */
public class Exercise12 {
	private static final WorldDao worldDao = InMemoryWorldDao.getInstance();
	private static final CountryDao countryDao = InMemoryWorldDao.getInstance();

	public static void main(String[] args) {
		// Find the minimum, the maximum and the average population of each continent.
		final Collection<String> continents = worldDao.getAllContinents();
		Map<String, Integer> minimum = continents.stream()
				.collect(Collectors.toMap(Function.identity(),
						continent -> countryDao.findCountriesByContinent(continent)
										.stream().map(country -> country.getPopulation())
										.min(Integer::compare).get()));

		System.out.println("MINIMUM");
		minimum.forEach((k,v) -> System.out.println(k + " : " + v));

		Map<String, Integer> maximum = continents.stream()
				.collect(Collectors.toMap(Function.identity(),
						continent -> countryDao.findCountriesByContinent(continent)
										.stream().map(country -> country.getPopulation())
										.max(Integer::compare).get()));

		System.out.println("MAXIMUM");
		maximum.forEach((k,v) -> System.out.println(k + " : " + v));

		Map<String, Double> average = continents.stream()
				.collect(Collectors.toMap(Function.identity(),
						continent -> countryDao.findCountriesByContinent(continent)
										.stream()
										.map(country -> country.getPopulation())
										.mapToInt(Integer::intValue)
										.filter(Objects::nonNull)
										.average().getAsDouble()));

		System.out.println("AVERAGE");
		average.forEach((k,v) -> System.out.println(k + " : " + v));

	}

}
