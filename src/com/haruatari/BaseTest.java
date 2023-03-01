package com.haruatari;

import java.util.Comparator;
import java.util.HashMap;

abstract public class BaseTest {
    final static private String ErrorColour = "\u001B[31m";
    final static private String SuccessColour = "\u001B[32m";
    final static private String ErrorBackground = "\u001B[41m";
    final static private String SuccessBackground = "\u001B[42m";
    final static private String ResetColour = "\u001B[0m";

    private int totalCasesNumber = 0;
    private int successCasesNumber = 0;

    abstract public void run();

    protected void increaseCasesCounter(boolean isSuccess) {
        totalCasesNumber++;
        if (isSuccess) {
            successCasesNumber++;
        }
    }

    protected void logMethodName(String name) {
        System.out.println("--------------------------------------------------");
        System.out.println("Method: " + name);
    }

    protected void logMethodArguments(HashMap<String, String> arguments) {
        System.out.println("Arguments:");

        int longestArgumentName = arguments
                .keySet()
                .stream()
                .map(String::length)
                .max(Comparator.comparingInt(i -> i))
                .get();

        for (var entity : arguments.entrySet()) {
            System.out.print("  " + entity.getKey());
            System.out.print(" ".repeat(longestArgumentName - entity.getKey().length()));
            System.out.println(": " + entity.getValue());
        }
    }

    protected void logTotalResult() {
        System.out.println("--------------------------------------------------");
        System.out.println();
        System.out.println("  Total test case: " + totalCasesNumber + "  ");
        System.out.println(SuccessBackground + "  Success:         " + successCasesNumber + "  " + ResetColour);
        System.out.println(ErrorBackground + "  Failed:          " + (totalCasesNumber - successCasesNumber) + "  " + ResetColour);

    }

    protected void logMethodResults(String expected, String actual, boolean isSuccess) {
        System.out.println("Result:");
        System.out.println("  Expected: " + expected);
        System.out.println("  Actual:   " + actual);
        if (isSuccess) {
            System.out.println(SuccessColour + "            Success" + ResetColour);
        } else {
            System.out.println(ErrorColour + "            Failed" + ResetColour);
        }

    }
}
