package com.example.exercises;

import com.example.service.InMemoryMovieService;
import com.example.service.MovieService;
import com.example.domain.Movie;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.Map;

/**
 * 
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 *
 */
public class Exercise8 {
	private static final MovieService movieService = InMemoryMovieService.getInstance();

	public static void main(String[] args) {
		// Group the movies by the year and list them
		final Collection<Movie> movies = movieService.findAllMovies();
		Map<Integer, List<Movie>> moviesByYear = movies.stream()
				.collect(Collectors.groupingBy(Movie::getYear));

		moviesByYear.forEach((k,v) -> System.out.println(k + " " + v));

	}

}
