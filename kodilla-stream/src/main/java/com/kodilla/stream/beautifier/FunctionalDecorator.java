package com.kodilla.stream.beautifier;

public class FunctionalDecorator {
    public static String getABCLetters(String toBeautify) {
        return "ABC " + "\033[3m" + toBeautify + "\033[0m" + " ABC";
    }
}
