package com.kodilla.exception.test;


public class ExceptionHandling {

    public static void main(String[] args) {

        SecondChallenge secondChallenge = new SecondChallenge();

        try {
            String result = secondChallenge.probablyIWillThrowException(1.5, 2.0);
            System.out.println(result);
        } catch (Exception e) {
            System.out.println("An exception occurred: " + e);
        } finally {
            System.out.println("Execution completed without error" );
        }
    }
}
