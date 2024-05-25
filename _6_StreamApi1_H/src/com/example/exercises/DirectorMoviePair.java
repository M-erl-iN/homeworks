package com.example.exercises;

import com.example.domain.Movie;
import com.example.domain.Director;

public record DirectorMoviePair(Director director, Integer movieId) {}
