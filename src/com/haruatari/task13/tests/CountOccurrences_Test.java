package com.haruatari.task13.tests;

import com.haruatari._src.loggers.CaseLogger;
import com.haruatari._src.tests.MethodTest;
import com.haruatari.task13.Task;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

final class CountOccurrences_Test extends MethodTest {
    public static void main(String[] args) {
        new CountOccurrences_Test().run();
    }

    @Override
    protected String getMethodName() {
        return "int countOccurrences(int[] list, int value)";
    }

    @Override
    protected Map<String, Consumer<CaseLogger>> getCases() {
        return new HashMap<>() {{
            put("The single occurrence in the beginning", logger -> runCase(logger, new int[]{10, 20, 30, 40, 50, 60, 70, 80, 90}, 10, 1));
            put("The single occurrence in the end", logger -> runCase(logger, new int[]{10, 20, 30, 40, 50, 60, 70, 80, 90}, 90, 1));
            put("Several occurrences in with edged", logger -> runCase(logger, new int[]{10, 20, 30, 10, 60, 70, 10, 10, 90, 50, 10}, 10, 10));
            put("Several occurrences in without edged", logger -> runCase(logger, new int[]{10, 20, 30, 20, 60, 40, 30, 10, 20, 50, 10}, 20, 3));
            put("An one-element list with occurrence", logger -> runCase(logger, new int[]{10}, 10, 1));
            put("An one-element list with no occurrences", logger -> runCase(logger, new int[]{10}, 20, 0));
            put("An empty list", logger -> runCase(logger, new int[]{}, 10, 0));
        }};
    }

    private void runCase(CaseLogger logger, int[] list, int value, int expected) {
        var actual = new Task().countOccurrences(list, value);
        logger
            .setArguments(new HashMap<>() {{
                put("list", Arrays.toString(list));
                put("value", String.valueOf(value));
            }})
            .setExpected(String.valueOf(expected))
            .setActual(String.valueOf(actual))
            .setIsSuccess(expected == actual);
    }
}
