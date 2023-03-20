package com.kodilla.stream.beautifier;

public class PoemBeautifier {

    public void beautify(String toBeautify, PoemDecorator poemDecorator) {
        String result = poemDecorator.decorate(toBeautify);
        System.out.println("Result of String beautify:  " + result);
    }
}

