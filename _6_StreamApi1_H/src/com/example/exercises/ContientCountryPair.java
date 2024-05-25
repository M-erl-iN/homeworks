package com.example.exercises;

import com.example.domain.Country;
import java.util.List;

public record ContientCountryPair(String continent, List<Country> country) {
}
