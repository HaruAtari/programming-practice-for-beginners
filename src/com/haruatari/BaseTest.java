package com.haruatari;

import java.util.HashMap;

abstract public class BaseTest {
    final static private String COLOUR_ERROR = "\u001B[31m";
    final static private String COLOUR_SUCCESS = "\u001B[32m";
    final static private String COLOUR_HIGHLIGHT = "\u001B[34m";
    final static private String BACKGROUND_ERROR = "\u001B[41m";
    final static private String BACKGROUND_SUCCESS = "\u001B[42m";
    final static private String RESET_STYLE = "\u001B[0m";

    private StringBuilder successCasesOutput = new StringBuilder();
    private StringBuilder failedCasesOutput = new StringBuilder();

    private int totalCasesNumber = 0;
    private int successCasesNumber = 0;

    abstract public void run();

    abstract public TaskNumber getNumber();

    @Deprecated
    protected void logCase(
            String methodName,
            HashMap<String, String> arguments,
            String expected,
            String actual,
            boolean isSuccess
    ) {
        logCase(methodName, null, arguments, expected, actual, isSuccess);
    }

    protected void logCase(
            String methodName,
            String caseName,
            HashMap<String, String> arguments,
            String expected,
            String actual,
            boolean isSuccess
    ) {
        var sb = new StringBuilder();
        sb.append(logMethodName(methodName));
        sb.append(logCaseName(caseName));
        sb.append(logCaseArguments(arguments));
        sb.append(logCaseResults(expected, actual, isSuccess));

        if (isSuccess) {
            successCasesOutput.append(sb);
        } else {
            failedCasesOutput.append(sb);
        }

        totalCasesNumber++;
        if (isSuccess) {
            successCasesNumber++;
        }
    }

    private String logMethodName(String name) {
        var sb = new StringBuilder();
        sb.append("----------------------------------------------------------------------------------------------------\n");
        sb.append(COLOUR_HIGHLIGHT + "Method: " + RESET_STYLE);
        sb.append(name + "\n");
        return sb.toString();
    }

    private String logCaseName(String name) {
        var sb = new StringBuilder();

        if (name == null) {
            sb.append("\n");

            return sb.toString();
        }

        sb.append(COLOUR_HIGHLIGHT + "Case: " + RESET_STYLE);
        sb.append(name + "\n\n");
        return sb.toString();
    }

    private String logCaseArguments(HashMap<String, String> arguments) {
        var sb = new StringBuilder();

        sb.append(COLOUR_HIGHLIGHT + "Arguments:" + RESET_STYLE + "\n");
        for (var entity : arguments.entrySet()) {
            sb.append(entity.getKey() + ": " + entity.getValue() + "\n");
        }
        sb.append("\n");

        return sb.toString();
    }

    private String logCaseResults(String expected, String actual, boolean isSuccess) {
        var sb = new StringBuilder();
        sb.append(COLOUR_HIGHLIGHT + "Result:" + RESET_STYLE + "\n");
        sb.append("Expected: " + expected + "\n");
        sb.append("Actual: " + actual + "\n");
        sb.append("Summary: ");
        if (isSuccess) {
            sb.append(COLOUR_SUCCESS + "Success" + RESET_STYLE + "\n");
        } else {
            sb.append(COLOUR_ERROR + "Failed" + RESET_STYLE + "\n");
        }

        return sb.toString();
    }

    protected void showTotalResult() {
        System.out.println(successCasesOutput.toString());
        System.out.println(failedCasesOutput.toString());

        var failedCasesNumber = totalCasesNumber - successCasesNumber;
        int longestValueLength = Math.max(
                Math.max(
                        String.valueOf(totalCasesNumber).length(),
                        String.valueOf(successCasesNumber).length()
                ),
                String.valueOf(failedCasesNumber).length()
        );

        System.out.println("----------------------------------------------------------------------------------------------------");
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
}
