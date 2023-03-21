package com.kodilla.stream.world;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

public final class World {
    private final List<Continent> continentList;

    public World(final List<Continent> continentList) {
        this.continentList = continentList;
    }

    public List<Continent> getContinentList() {
        return continentList;
    }

    public BigDecimal getPeopleQuantity() {
        return continentList.stream()
                .flatMap(continent -> continent.getCountriesOnContinent().stream())
                .map(Country::getPeoplePopulation)
                .reduce(BigDecimal.ZERO, (sum, current) -> sum = sum.add(current));
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        World world = (World) o;

        return Objects.equals(continentList, world.continentList);
    }

    @Override
    public int hashCode() {
        return continentList != null ? continentList.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "World{" +
                "continentList=" + continentList +
                '}';
    }
}
