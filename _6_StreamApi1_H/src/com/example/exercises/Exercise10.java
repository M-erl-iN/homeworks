package com.example.exercises;

import com.example.dao.CountryDao;
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
public class Exercise10 {
	private static final WorldDao worldDao = InMemoryWorldDao.getInstance();
	private static final CountryDao countryDao = InMemoryWorldDao.getInstance();

	public static void main(String[] args) {
		// Find the richest country of each continent with respect to their GNP (Gross National Product) values.

		Map<String, List<Country>> richestCountries = worldDao.getAllContinents().stream()
				.collect(Collectors.toMap(Function.identity(),
						continent -> countryDao.findCountriesByContinent(continent).stream()
										.max(Comparator.comparing(Country::getGnp))
										.stream().collect(Collectors.toList())));

		richestCountries.forEach((k, v) -> System.out.println(k + " : " + v));

	}

}
