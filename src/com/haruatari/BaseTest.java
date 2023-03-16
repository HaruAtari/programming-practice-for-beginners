package com.haruatari;

import java.util.HashMap;
import java.util.Map;

abstract public class BaseTest {
    final static private String COLOUR_ERROR = "\u001B[31m";
    final static private String COLOUR_SUCCESS = "\u001B[32m";
    final static private String COLOUR_HIGHLIGHT = "\u001B[34m";
    final static private String BACKGROUND_ERROR = "\u001B[41m";
    final static private String BACKGROUND_SUCCESS = "\u001B[42m";
    final static private String BACKGROUND_WHITE = "\u001B[47m";
    final static private String RESET_STYLE = "\u001B[0m";

    final private StringBuilder successCasesOutput = new StringBuilder();
    final private StringBuilder failedCasesOutput = new StringBuilder();

    final private Map<String, int[]> methodsStatistic = new HashMap<>();
    private int failedCasesNumber = 0;
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

        if (!methodsStatistic.containsKey(methodName)) {
            methodsStatistic.put(methodName, new int[]{0, 0});
        }

        if (isSuccess) {
            successCasesNumber++;
            methodsStatistic.get(methodName)[0]++;
        } else {
            failedCasesNumber++;
            methodsStatistic.get(methodName)[1]++;
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

        System.out.println("----------------------------------------------------------------------------------------------------");
        System.out.println();

        var longestName = 6; // "method"
        var longestSuccessNumber = 7; // "Success"
        var longestFailedNumber = 6; // "failed"

        for (var methodName : methodsStatistic.keySet()) {
            var statistic = methodsStatistic.get(methodName);

            if (methodName.length() > longestName) {
                longestName = methodName.length();
            }
            if (String.valueOf(statistic[0]).length() > longestSuccessNumber) {
                longestSuccessNumber = String.valueOf(statistic[0]).length();
            }
            if (String.valueOf(statistic[1]).length() > longestFailedNumber) {
                longestFailedNumber = String.valueOf(statistic[1]).length();
            }
        }

        System.out.print("| " + COLOUR_HIGHLIGHT + "Method" + " ".repeat(longestName - 6) + RESET_STYLE + " ");
        System.out.print("| " + COLOUR_HIGHLIGHT + "Success" + " ".repeat(longestSuccessNumber - 7) + RESET_STYLE + " ");
        System.out.print("| " + COLOUR_HIGHLIGHT + "Failed" + " ".repeat(longestFailedNumber - 6) + RESET_STYLE + " |");
        System.out.println();

        for (var methodData : methodsStatistic.entrySet()) {
            System.out.print("| " + methodData.getKey() + " ".repeat(longestName - methodData.getKey().length()) + " ");
            System.out.print("| " + COLOUR_SUCCESS + methodData.getValue()[0] + " ".repeat(longestSuccessNumber - String.valueOf(methodData.getValue()[0]).length()) + RESET_STYLE + " ");
            System.out.print("| " + COLOUR_ERROR + methodData.getValue()[1] + " ".repeat(longestFailedNumber - String.valueOf(methodData.getValue()[1]).length()) + RESET_STYLE + " |");
            System.out.println();
        }

        System.out.print("|" + BACKGROUND_WHITE + " Total" + " ".repeat(longestName - 5) + " " + RESET_STYLE);
        System.out.print("|" + BACKGROUND_SUCCESS + " " + successCasesNumber + " ".repeat(longestSuccessNumber - String.valueOf(successCasesNumber).length()) + " " + RESET_STYLE);
        System.out.print("|" + BACKGROUND_ERROR + " " + failedCasesNumber + " ".repeat(longestFailedNumber - String.valueOf(failedCasesNumber).length()) + " " + RESET_STYLE + "|");
        System.out.println();
    }
}
