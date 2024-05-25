package com.example.exercises;

import com.example.dao.InMemoryWorldDao;
import com.example.dao.WorldDao;
import com.example.domain.Country;
import com.example.domain.City;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * 
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 *
 */
public class Exercise16 {
	private static final WorldDao worldDao = InMemoryWorldDao.getInstance();

	public static void main(String[] args) {
		// Find the cities with the minimum and the maximum population in countries.
		Map<Country, Optional<City>> min = worldDao.findAllCountries().stream()
				.collect(Collectors.toMap(
						Function.identity(),
						country -> country.getCities().stream().min(Comparator.comparingInt(City::getPopulation))
				));

		Map<Country, Optional<City>> max = worldDao.findAllCountries().stream()
				.collect(Collectors.toMap(
						Function.identity(),
						country -> country.getCities().stream().max(Comparator.comparingInt(City::getPopulation))
				));

		System.out.println(min);
		System.out.println(max);
	}
}
