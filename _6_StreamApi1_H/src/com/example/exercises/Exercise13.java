package com.example.exercises;

import com.example.dao.InMemoryWorldDao;
import com.example.dao.WorldDao;
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
public class Exercise13 {
	private static final WorldDao worldDao = InMemoryWorldDao.getInstance();

	public static void main(String[] args) {
		// Find the countries with the minimum and the maximum population
		final Collection<Country> countries = worldDao.findAllCountries();

		List<Country> maxPopulatedCountries = worldDao.findAllCountries().stream()
				.sorted(Comparator.comparing(Country::getPopulation).reversed())
				.takeWhile(country -> country.getPopulation() ==
						worldDao.findAllCountries().stream()
								.map(c -> c.getPopulation())
								.max(Integer::compare).get())
				.collect(Collectors.toList());


		maxPopulatedCountries.forEach(System.out::println);

		List<Country> minPopulatedCountries = worldDao.findAllCountries().stream()
				.sorted(Comparator.comparing(Country::getPopulation))
				.takeWhile(country -> country.getPopulation() ==
						countries.stream().map(c -> c.getPopulation())
								.min(Integer::compare).get())
				.collect(Collectors.toList());

		minPopulatedCountries.forEach(System.out::println);

	}

}
