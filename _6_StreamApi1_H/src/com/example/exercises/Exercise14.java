package com.example.exercises;

import com.example.dao.InMemoryWorldDao;
import com.example.dao.WorldDao;
import com.example.domain.Country;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * 
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 *
 */
public class Exercise14 {
	private static final WorldDao worldDao = InMemoryWorldDao.getInstance();

	public static void main(String[] args) {
		// Find the countries of each continent with the minimum and the maximum population
		final Collection<String> continents = worldDao.getAllContinents();

		Map<String, List<Country>> minPopulatedCountries = worldDao.getAllContinents().stream()
						.collect(Collectors.toMap(Function.identity(),
								continent -> worldDao.findCountriesByContinent(continent)
										.stream().sorted(Comparator.comparing(Country::getPopulation))
										.takeWhile(country -> country.getPopulation() == (
												worldDao.findCountriesByContinent(continent)
														.stream().map(c -> c.getPopulation())
														.min(Integer::compare).get()))
										.collect(Collectors.toList())));

		System.out.println("MINIMUM");
		minPopulatedCountries.forEach((k,v) -> System.out.println(k + " : " + v));


		Map<String, List<Country>> maxPopulatedCountries = worldDao.getAllContinents().stream()
				.collect(Collectors.toMap(Function.identity(),
						continent -> worldDao.findCountriesByContinent(continent)
								.stream().sorted(Comparator.comparing(Country::getPopulation).reversed())
								.takeWhile(country -> country.getPopulation() == (
										worldDao.findCountriesByContinent(continent)
												.stream().map(c -> c.getPopulation())
												.max(Integer::compare).get()))
								.collect(Collectors.toList())));

		System.out.println("MAXIMUM");
		maxPopulatedCountries.forEach((k,v) -> System.out.println(k + " : " + v));
	}

}
