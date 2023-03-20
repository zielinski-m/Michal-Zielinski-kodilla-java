package com.kodilla.stream;
import com.kodilla.stream.beautifier.FunctionalDecorator;
import com.kodilla.stream.beautifier.PoemBeautifier;
import com.kodilla.stream.lambda.*;
import com.kodilla.stream.reference.FunctionalCalculator;

public class StreamMain {
    public static void main(String[] args) {
        ExpressionExecutor expressionExecutor = new ExpressionExecutor();

        expressionExecutor.executeExpression(10, 5, Double::sum);
        expressionExecutor.executeExpression(10, 5, (a, b) -> a - b);
        expressionExecutor.executeExpression(10, 5, (a, b) -> a * b);
        expressionExecutor.executeExpression(10, 5, (a, b) -> a / b);
        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::addAToB);

        PoemBeautifier poemBeautifier = new PoemBeautifier();
        poemBeautifier.beautify("Example text", toBeautify -> ("\n" + toBeautify));
        poemBeautifier.beautify("EXAMPLE STRING", String::toLowerCase);
        poemBeautifier.beautify("example text", String::toUpperCase);
        poemBeautifier.beautify("Example", FunctionalDecorator::getABCLetters);
        poemBeautifier.beautify("TextToBold", toBeautify -> ("\033[1m" + toBeautify + "\033[0m"));
    }
}

