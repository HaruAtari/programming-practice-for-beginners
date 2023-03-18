package com.haruatari.task2.tests;

import com.haruatari._src.loggers.CaseLogger;
import com.haruatari._src.tests.MethodTest;
import com.haruatari.task2.Task;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

final class FindLast_Test extends MethodTest {
    public static void main(String[] args) {
        new FindLast_Test().run();
    }

    @Override
    protected String getMethodName() {
        return "int findLast(int[] list, int value)";
    }

    @Override
    protected Map<String, Consumer<CaseLogger>> getCases() {
        return new HashMap<>() {{
            put("1", l -> runCase(l, new int[]{10, 20, 30}, 10, 0));
            put("2", l -> runCase(l, new int[]{10, 20, 30}, 30, 2));
            put("3", l -> runCase(l, new int[]{10, 20, 10}, 10, 2));
            put("4", l -> runCase(l, new int[]{10, 20, 30}, 40, -1));
            put("5", l -> runCase(l, new int[]{}, 10, -1));
        }};
    }

    private void runCase(CaseLogger logger, int[] list, int value, int expected) {
        var actual = new Task().findLast(list, value);

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
