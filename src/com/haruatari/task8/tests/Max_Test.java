package com.haruatari.task8.tests;

import com.haruatari._src.loggers.CaseLogger;
import com.haruatari._src.tests.MethodTest;
import com.haruatari.task8.Task;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

final class Max_Test extends MethodTest {
    public static void main(String[] args) {
        new Max_Test().run();
    }

    @Override
    protected String getMethodName() {
        return "int max(int[] list)";
    }

    @Override
    protected Map<String, Consumer<CaseLogger>> getCases() {
        return new HashMap<>() {{
            put("The searched element is the first", logger -> runCase(logger, new int[]{-10, -20, -30, -40, -50}, -10));
            put("The searched element is the last", logger -> runCase(logger, new int[]{10, 20, 30, 40, 50}, 50));
            put("The searched element is in the middle", logger -> runCase(logger, new int[]{10, 20, 40, 30, 50, 40, 20, 20}, 50));
            put("The list has several equals minimal values", logger -> runCase(logger, new int[]{10, 40, 20, 30, 40, 40}, 40));
            put("All elements are equals", logger -> runCase(logger, new int[]{10, 10, 10, 10, 10}, 10));
            put("The list contains only one element", logger -> runCase(logger, new int[]{10}, 10));
            put("A empty list", logger -> runCase(logger, new int[]{}, 0));
            put("The list contains integer's minimal and maximum possible values", logger -> runCase(logger, new int[]{Integer.MIN_VALUE, 0, Integer.MAX_VALUE}, Integer.MAX_VALUE));
        }};
    }

    private void runCase(CaseLogger logger, int[] input, int expected) {
        var actual = new Task().min(input);

        logger
                .setArguments(new HashMap<>() {{
                    put("list", Arrays.toString(input));
                }})
                .setIsSuccess(actual == expected)
                .setActual(String.valueOf(actual))
                .setExpected(String.valueOf(expected));
    }
}
