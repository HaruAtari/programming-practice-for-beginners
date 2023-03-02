package com.haruatari;

import java.util.Comparator;
import java.util.HashMap;

abstract public class BaseTest {
    final static private String COLOUR_ERROR = "\u001B[31m";
    final static private String COLOUR_SUCCESS = "\u001B[32m";
    final static private String BACKGROUND_ERROR = "\u001B[41m";
    final static private String BACKGROUND_SUCCESS = "\u001B[42m";
    final static private String RESET_STYLE = "\u001B[0m";

    private int totalCasesNumber = 0;
    private int successCasesNumber = 0;

    abstract public void run();

    abstract public TaskNumber getNumber();

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
        var failedCasesNumber = totalCasesNumber - successCasesNumber;
        int longestValueLength = Math.max(
                Math.max(
                        String.valueOf(totalCasesNumber).length(),
                        String.valueOf(successCasesNumber).length()
                ),
                String.valueOf(failedCasesNumber).length()
        );

        System.out.println("--------------------------------------------------");
        System.out.println();

        System.out.print("  Total test case: " + totalCasesNumber + "  ");
        System.out.println(" ".repeat(longestValueLength - String.valueOf(totalCasesNumber).length()));

        System.out.print(BACKGROUND_SUCCESS + "  Success:         " + successCasesNumber + "  ");
        System.out.print(" ".repeat(longestValueLength - String.valueOf(successCasesNumber).length()));
        System.out.println(RESET_STYLE);

        System.out.print(BACKGROUND_ERROR + "  Failed:          " + failedCasesNumber + "  ");
        System.out.print(" ".repeat(longestValueLength - String.valueOf(failedCasesNumber).length()));
        System.out.println(RESET_STYLE);

    }

    protected void logMethodResults(String expected, String actual, boolean isSuccess) {
        System.out.println("Result:");
        System.out.println("  Expected: " + expected);
        System.out.println("  Actual:   " + actual);
        if (isSuccess) {
            System.out.println(COLOUR_SUCCESS + "            Success" + RESET_STYLE);
        } else {
            System.out.println(COLOUR_ERROR + "            Failed" + RESET_STYLE);
        }

    }
}