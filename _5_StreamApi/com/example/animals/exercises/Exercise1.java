package com.example.animals.exercises;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.example.animals.domain.Animal;
import com.example.animals.domain.Cat;
import com.example.animals.domain.Fish;
import com.example.animals.domain.Pet;
import com.example.animals.domain.Spider;

//@author Binnur Kurt <binnur.kurt@gmail.com>
public class Exercise1 {
	private static final List<Animal> animals = Arrays.asList(new Cat(), new Spider(), new Cat(),
			new Fish("first"), new Spider(), new Fish("second"));
	private static final Predicate<Animal> isPet = Pet.class::isInstance;
	private static final Predicate<Animal> isWild = isPet.negate();

	public static void main(String[] args) {
		// Take a list of wild animals
		animals.stream().filter(isWild::test).forEach(System.out::print);
	}
}
