package com.example.exercises;

import com.example.dao.InMemoryWorldDao;
import com.example.dao.WorldDao;
import com.example.domain.Country;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * 
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 *
 */
public class Exercise9 {
	private static final WorldDao worldDao = InMemoryWorldDao.getInstance();

	public static void main(String[] args) {
		// Sort the countries by their population densities in descending order ignoring
		// zero population countries
		final Collection<Country> countries = worldDao.findAllCountries();
		List<Country> sortedCountries = countries.stream()
				.filter(country -> country.getPopulation() != 0)
				.map(country -> new CountryPopulationPair(country,country.getPopulation()))
				.sorted(Comparator.comparing(CountryPopulationPair::population).reversed())
				.map(ccp -> ccp.country())
				.collect(Collectors.toList());

		sortedCountries.forEach(System.out::println);

	}

}
