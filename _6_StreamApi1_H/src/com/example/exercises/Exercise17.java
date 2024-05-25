package com.example.exercises;

import com.example.dao.InMemoryWorldDao;
import com.example.dao.WorldDao;
import com.example.domain.Country;

import java.util.Comparator;
import java.util.Optional;
import java.util.OptionalDouble;

/**
 * 
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 *
 */
public class Exercise17 {
	private static final WorldDao worldDao = InMemoryWorldDao.getInstance();

	public static void main(String[] args) {
		// Find the minimum, the maximum, the average, and the standard deviation of GNP values.
		double minimum = worldDao.findAllCountries().stream()
				.min(Comparator.comparingDouble(Country::getGnp)).map(Country::getGnp).get();

		double maximum = worldDao.findAllCountries().stream()
				.max(Comparator.comparingDouble(Country::getGnp)).map(Country::getGnp).get();

		double average = worldDao.findAllCountries().stream().map(Country::getGnp)
				.mapToDouble(Double::doubleValue).average().getAsDouble();

		double standartDeviation = worldDao.findAllCountries().stream().map(Country::getGnp)
				.map(x -> (x-average)*(x-average)).mapToDouble(Double::doubleValue)
				.average().getAsDouble();

		System.out.println("MAX "  + maximum);
		System.out.println("MIN " + minimum);
		System.out.println("AVERAGE " + average);
		System.out.println("STANDART DEVIATION " + standartDeviation);
	}

}
