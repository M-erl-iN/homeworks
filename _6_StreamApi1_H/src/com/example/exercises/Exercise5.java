package com.example.exercises;

import com.example.dao.CityDao;
import com.example.dao.CountryDao;
import com.example.dao.InMemoryWorldDao;
import com.example.domain.City;

import java.util.Collection;
import java.util.Comparator;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * 
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 *
 */
public class Exercise5 {
	private static final CountryDao countryDao = InMemoryWorldDao.getInstance();
	private static final CityDao cityDao = InMemoryWorldDao.getInstance();

	public static void main(String[] args) {
		// Find the highest populated capital city of each continent
		final Collection<String> continents = countryDao.getAllContinents();
		Map<String, City> ccp = continents.stream()
				.flatMap(continent -> countryDao.findCountriesByContinent(continent).stream()
						.map(country -> cityDao.findCityById(country.getCapital()))
						.filter(Objects::nonNull)
						.map(capital -> new ContinentCityPair(continent, capital)))
				.collect(Collectors.toMap(ContinentCityPair::continent,
						value -> value.city(),
						(a, b) -> {if (a.getPopulation() > b.getPopulation()) return a; else return b;}));


		ccp.forEach((a, b) -> System.out.println(a + " " + b));


	}

}