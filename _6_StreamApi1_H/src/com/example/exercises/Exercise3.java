package com.example.exercises;

import com.example.domain.Director;
import com.example.domain.Movie;
import com.example.service.InMemoryMovieService;
import com.example.service.MovieService;
import com.example.domain.Genre;

import java.util.Collection;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.HashSet;
import java.util.List;

/**
 * 
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 *
 */
public class Exercise3 {
	private static final MovieService movieService = InMemoryMovieService.getInstance();

	public static void main(String[] args) {
		final Collection<Movie> movies = movieService.findAllMovies();
		Map<Director, Integer> numberOfGenresOfEachDirectors = movieService.findAllMovies().stream()
				.flatMap( (m) -> m.getDirectors().stream().map( (d) -> new DirectorGenresPair(d, m.getGenres())))
				.collect(Collectors.toMap(
						DirectorGenresPair::director,
						(dgp) -> new HashSet<Genre>(dgp.genres()),
						(o, n) -> {o.addAll(n); return o;}
				))
				.entrySet()
				.stream()
				.collect(Collectors.toMap(Map.Entry::getKey, (e) -> e.getValue().size()));

		System.out.println(numberOfGenresOfEachDirectors);

	}

}