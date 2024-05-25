package com.example.exercises;

import com.example.domain.Movie;
import com.example.service.InMemoryMovieService;
import com.example.service.MovieService;

import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.Map;

/**
 * 
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 *
 */
public class Exercise18 {
	private static final  MovieService movieService = InMemoryMovieService.getInstance();

	public static void main(String[] args) {
		// Find the year when the maximum number of movie is available
		Optional<Integer> year = movieService.findAllMovies().stream()
				.map(Movie::getYear).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
				.entrySet().stream()
				.max(Map.Entry.comparingByValue())
				.map(Map.Entry::getKey);

		System.out.println(year);

	}

}
