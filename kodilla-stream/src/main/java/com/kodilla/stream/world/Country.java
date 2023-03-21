package com.kodilla.stream.world;

import java.math.BigDecimal;


public final class Country {
    private final String name;
    private final BigDecimal peoplePopulation;

    public Country(final String name, final BigDecimal peoplePopulation) {
        this.name = name;
        this.peoplePopulation = peoplePopulation;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPeoplePopulation() {
         return peoplePopulation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Country country = (Country) o;

        if (!name.equals(country.name)) return false;
        return peoplePopulation.equals(country.peoplePopulation);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + peoplePopulation.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Country{" +
                "name='" + name + '\'' +
                ", peoplePopulation=" + peoplePopulation +
                '}';
    }
}

