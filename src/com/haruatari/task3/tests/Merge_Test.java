package com.haruatari.task3.tests;

import com.haruatari._src.loggers.CaseLogger;
import com.haruatari._src.tests.MethodTest;
import com.haruatari.task3.Task;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

final class Merge_Test extends MethodTest {
    public static void main(String[] args) {
        new Merge_Test().run();
    }

    @Override
    protected String getMethodName() {
        return "int[] merge(int[] x, int[] y)";
    }

    @Override
    protected Map<String, Consumer<CaseLogger>> getCases() {
        return new HashMap<>() {{
            put("1", l -> runCase(l, new int[]{10, 20}, new int[]{30, 40}, new int[]{10, 20, 30, 40}));
            put("2", l -> runCase(l, new int[]{30, 40}, new int[]{10, 20}, new int[]{30, 40, 10, 20}));
            put("3", l -> runCase(l, new int[]{10}, new int[]{10}, new int[]{10, 10}));
            put("4", l -> runCase(l, new int[]{}, new int[]{10}, new int[]{10}));
            put("5", l -> runCase(l, new int[]{10}, new int[]{}, new int[]{10}));
            put("6", l -> runCase(l, new int[]{}, new int[]{}, new int[]{}));
        }};
    }

    private void runCase(CaseLogger logger, int[] x, int[] y, int[] expected) {
        var actual = new Task().merge(x, y);

        logger
            .setArguments(new HashMap<>() {{
                put("x", Arrays.toString(x));
                put("y", Arrays.toString(y));
            }})
            .setExpected(Arrays.toString(expected))
            .setActual(Arrays.toString(actual))
            .setIsSuccess(Arrays.equals(actual, expected));
    }
}
