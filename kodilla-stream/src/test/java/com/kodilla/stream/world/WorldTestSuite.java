package com.kodilla.stream.world;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

public class WorldTestSuite {

    @Test
    void testGetPeopleQuantity() {
        //Given
        Country unitedKingdom = new Country("Great Britain", new BigDecimal(51156366));
        Country france = new Country("France", new BigDecimal(46164364));
        Country poland = new Country("Poland", new BigDecimal(42521120));
        Country thailand = new Country("Thailand", new BigDecimal(36514200));
        Country singapore = new Country("Singapore", new BigDecimal(12645879));
        Country egypt = new Country("Egypt", new BigDecimal(56123654));
        Country republicOfSouthAfrica = new Country("RPA", new BigDecimal(79365412));

        List<Country> europeanCountries = new ArrayList<>();
        europeanCountries.add(unitedKingdom);
        europeanCountries.add(france);
        europeanCountries.add(poland);

        List<Country> asianCountries = new ArrayList<>();
        asianCountries.add(thailand);
        asianCountries.add(singapore);

        List<Country> africanCountries = new ArrayList<>();
        africanCountries.add(egypt);
        asianCountries.add(republicOfSouthAfrica);

        Continent europe = new Continent("Europe", europeanCountries);
        Continent asia = new Continent("Asia",asianCountries);
        Continent africa = new Continent("Africa", africanCountries);

        List<Continent> continentsList = new ArrayList<>();
        continentsList.add(europe);
        continentsList.add(asia);
        continentsList.add(africa);

        World world = new World(continentsList);
        List<Continent> worldList = world.getContinentList();
        //When
        BigDecimal providedResult = world.getPeopleQuantity();
        System.out.println(providedResult + "\n" + worldList.toString());
        BigDecimal expectedResult = worldList.stream()
                .flatMap(continent -> continent.getCountriesOnContinent().stream())
                        .map(Country::getPeoplePopulation)
                                .reduce(BigDecimal.ZERO, (sum, current) -> sum = sum.add(current));

        //Then
        assertEquals(expectedResult, providedResult);
    }
}
