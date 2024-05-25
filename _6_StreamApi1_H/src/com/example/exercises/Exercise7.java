package com.example.exercises;

import com.example.domain.Country;
import com.example.domain.Genre;
import com.example.domain.Movie;
import com.example.service.InMemoryMovieService;
import com.example.service.MovieService;

import java.util.Collection;
import java.util.List;
import java.util.HashSet;
import java.util.stream.Collectors;

/**
 * 
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 *
 */
public class Exercise7 {
	private static final MovieService movieService = InMemoryMovieService.getInstance();

	public static void main(String[] args) {
		// Find the list of movies having the genres "Drama" and "Comedy" only
		final Collection<Movie> movies = movieService.findAllMovies();
		final List<Genre> genres = movieService.findAllGenres().stream().toList();
		List<Movie> dramaComedyMovies = movies.stream()
				.filter(movie -> (movie.getGenres().size() == 2
						&& movie.getGenres().contains(genres.get(0))
						&& movie.getGenres().contains(genres.get(1))))
				.collect(Collectors.toList());

		dramaComedyMovies.forEach(System.out::println);

	}

}
