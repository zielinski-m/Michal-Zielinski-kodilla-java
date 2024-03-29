package com.kodilla.good.patterns.challenges.moviesStore;

import java.util.*;
import java.util.stream.Collectors;

public class MoviesStore {
    public Map<String, List<String>> getMovies() {

        List<String> ironManTranslations = new ArrayList<>();
        ironManTranslations.add("Żelazny Człowiek");
        ironManTranslations.add("Iron Man");

        List<String> avengersTranslations = new ArrayList<>();
        avengersTranslations.add("Mściciele");
        avengersTranslations.add("Avengers");

        List<String> flashTranslations = new ArrayList<>();
        flashTranslations.add("Błyskawica");
        flashTranslations.add("Flash");

        Map<String, List<String>> booksTitlesWithTranslations = new HashMap<>();
        booksTitlesWithTranslations.put("IM", ironManTranslations);
        booksTitlesWithTranslations.put("AV", avengersTranslations);
        booksTitlesWithTranslations.put("FL", flashTranslations);

        return booksTitlesWithTranslations;
    }

    public String getAllTitles() {
        Map<String, List<String>> movies = new MoviesStore().getMovies();
        String allTitles = movies.values().stream()
                .flatMap(Collection::stream)
                .collect(Collectors.joining("!"));
        return allTitles;
    }
}
