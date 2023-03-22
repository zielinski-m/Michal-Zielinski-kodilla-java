package com.kodilla.stream.array;


import java.util.Arrays;
import java.util.stream.IntStream;
public interface ArrayOperations {


    public static double getAverage(int[] numbers) {
        int[] printNumbers = IntStream.range(0, numbers.length)
                .map(i -> numbers[i])
                .toArray();
        System.out.println(Arrays.toString(printNumbers));

        double average = IntStream.range(0, numbers.length)
                .map(i -> numbers[i])
                .average().getAsDouble();
        return average;
    }
}
