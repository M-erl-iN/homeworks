package com.example.exercises;

import com.example.domain.Movie;
import com.example.service.InMemoryMovieService;
import com.example.service.MovieService;
import com.example.domain.Director;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 *
 */
public class Exercise1 {
	private static final MovieService movieService = InMemoryMovieService.getInstance();

	public static void main(String[] args) {
		// Find the number of movies of each director
        final Collection<Movie> movies = movieService.findAllMovies();
		Map<Director, Integer> directorMoviesNumber = movies.stream()
				.flatMap(movie -> movie.getDirectors().stream().map(director -> new DirectorMoviePair(director, movie.getId())))
				.collect(Collectors.toMap(DirectorMoviePair::director, dmp -> 1, (a, b) -> a + 1));

		directorMoviesNumber.forEach((a, b) -> System.out.println(a + " = " + b));










	}

}
