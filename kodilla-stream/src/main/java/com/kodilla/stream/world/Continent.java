package com.kodilla.stream.world;

import java.util.*;

public final class Continent {

private final String continent;
private final List<Country> countriesOnContinent;

    public Continent(final String continent, final List<Country> countriesOnContinent) {
        this.continent = continent;
        this.countriesOnContinent = countriesOnContinent;
    }

    public List<Country> getCountriesOnContinent() {
        return countriesOnContinent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Continent continent1 = (Continent) o;

        if (!continent.equals(continent1.continent)) return false;
        return countriesOnContinent.equals(continent1.countriesOnContinent);
    }

    @Override
    public int hashCode() {
        int result = continent.hashCode();
        result = 31 * result + countriesOnContinent.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Continent{" +
                "continent='" + continent + '\'' +
                ", countriesOnContinent=" + countriesOnContinent +
                '}';
    }
}
