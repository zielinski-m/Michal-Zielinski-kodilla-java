package com.kodilla.testing.collection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class OddNumbersExterminator {
    List<Integer> temporaryList = new ArrayList<>(Arrays.asList());
    public List<Integer> exterminate(List<Integer> numbers) {
        int temporaryValue = 0;
        for (int i = 0; i < numbers.size(); i++) {
            temporaryValue = numbers.get(i);
            if (temporaryValue % 2 == 0) {
//                System.out.println(temporaryValue);
                temporaryList.add(temporaryValue);
            }
        }
        return temporaryList;
    }
}

