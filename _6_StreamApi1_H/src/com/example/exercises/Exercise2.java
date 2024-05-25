package com.example.exercises;

import com.example.dao.CityDao;
import com.example.dao.CountryDao;
import com.example.dao.InMemoryWorldDao;
import com.example.domain.City;
import com.example.domain.Country;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 *
 */
public class Exercise2 {
	private static final CountryDao countryDao = InMemoryWorldDao.getInstance();
	private static final CityDao cityDao = InMemoryWorldDao.getInstance();

	public static void main(String[] args) {
		// Find the most populated city of each continent
		final Collection<String> continents = countryDao.getAllContinents();
		Map<String, Integer> mostPopularCityOfCity = continents.stream()
				.flatMap(continent -> countryDao.findCountriesByContinent(continent).stream()
						.flatMap(country -> cityDao.findCitiesByCountryCode(country.getCode())
								.stream().map(city -> new ContinentCityPair(continent, city))))
				.collect(Collectors.toMap(ContinentCityPair::continent,
						value -> value.city().getPopulation(),
						(a, b) -> {if (a > b) return a; else return b;}));
		mostPopularCityOfCity.forEach((a, b) -> System.out.println(a + " " + b));
	}

}