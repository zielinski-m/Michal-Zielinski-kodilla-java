package com.kodilla.testing.weather.stub;

import java.util.*;
public class WeatherForecast {
    private Temperatures temperatures;

    public WeatherForecast(Temperatures temperatures) {
        this.temperatures = temperatures;
    }

    public Map<String, Double> calculateForecast() {

        Map<String, Double> resultMap = new HashMap<>();

        for (Map.Entry<String, Double> temperature :
                temperatures.getTemperatures().entrySet()) {
            resultMap.put(temperature.getKey(), temperature.getValue() + 1.0);
        }
        return resultMap;
    }

    public double averageTemperatures() {
        double sumOfTemperatures = 0;
        for (Double value : temperatures.getTemperatures().values()) {
            sumOfTemperatures += value;
        }
        return sumOfTemperatures / temperatures.getTemperatures().size();
    }

    public double medianTemperature() {

        List<Double> sortedListOfTemps = new ArrayList<>(temperatures.getTemperatures().values());
        Collections.sort(sortedListOfTemps);
        int median = sortedListOfTemps.size() / 2;
        if (median / 2 == 0) {
            median = median > 0 && median % 2 == 0 ? median - 1 : median;
        }
        return sortedListOfTemps.get(median);
    }
}



