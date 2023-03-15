package com.kodilla.testing.weather.mock;

import com.kodilla.testing.weather.stub.Temperatures;
import com.kodilla.testing.weather.stub.WeatherForecast;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.*;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class WeatherForecastTestSuite {
    @Mock
    private Temperatures temperaturesMock;
    private WeatherForecast weatherForecast;
    private Map<String, Double> temperaturesMap = new HashMap<>();


    @BeforeEach
    void beforeTestAnnotation() { System.out.println("Test begin:"); }
    void setWeatherForecast() {
        weatherForecast = new WeatherForecast(temperaturesMock);
    }
    void setTemperaturesMap() {

        temperaturesMap = new HashMap<>();
        temperaturesMap.put("Rzeszow", 25.5);
        temperaturesMap.put("Krakow", 26.2);
        temperaturesMap.put("Wroclaw", 24.8);
        temperaturesMap.put("Warszawa", 25.2);
        temperaturesMap.put("Gdansk", 26.1);
        when(temperaturesMock.getTemperatures()).thenReturn(temperaturesMap);
    }

    @AfterEach
    void afterTestAnnotation() { System.out.println("Test ended without errors:"); }

    @Test
    void testCalculateForecastWithMock() {
        //Given
        setTemperaturesMap();
        setWeatherForecast();

        //When
        int quantityOfSensors = weatherForecast.calculateForecast().size();

        //Then
        Assertions.assertEquals(5, quantityOfSensors);
    }

    @Test
    void testCountAverageTemperature() {
        //Given
        setTemperaturesMap();
        setWeatherForecast();

        //When
        double averageTemperature = weatherForecast.averageTemperatures();
        double expectedValue = ((temperaturesMap.values().stream()
                .mapToDouble(Double::doubleValue).sum())) / temperaturesMap.size();

        //Then
        Assertions.assertEquals(expectedValue, averageTemperature);
    }

    @Test
    void testMedianOfTemperatures() {
        //Given
        setTemperaturesMap();
        setWeatherForecast();

        //When
        double median = weatherForecast.medianTemperature();
        List<Double> expectedValuesList = new ArrayList<>(temperaturesMap.values());
        Collections.sort(expectedValuesList);
        int expectedResult = expectedValuesList.size() / 2;

        //Then
        Assertions.assertEquals(expectedValuesList.get(expectedResult), median);
    }
}
