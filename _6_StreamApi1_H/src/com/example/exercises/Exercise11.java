package com.example.exercises;

import com.example.dao.InMemoryWorldDao;
import com.example.dao.WorldDao;
import com.example.domain.Country;

import java.util.Collection;
import java.util.Comparator;

/**
 * 
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 *
 */
public class Exercise11 {
	private static final WorldDao worldDao = InMemoryWorldDao.getInstance();

	public static void main(String[] args) {
		// Find the minimum, the maximum and the average population of world countries
		final Collection<Country> countries = worldDao.findAllCountries();
		int minimum = countries.stream().map(country -> country.getPopulation())
				.min(Integer::compare).get();
		int maximum = countries.stream().map(country -> country.getPopulation())
				.max(Integer::compare).get();
		double average = countries.stream().map(country -> country.getPopulation())
				.mapToInt(Integer::intValue).average().getAsDouble();

		System.out.println("min " +  minimum);
		System.out.println("max " + maximum);
		System.out.println("averadge " + average);

	}

}
