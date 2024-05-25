package com.example.exercises;

import java.util.List;
import com.example.domain.Country;
import com.example.domain.City;

public record CountryCitiesPair(Country country, List<City> cities) {
}
