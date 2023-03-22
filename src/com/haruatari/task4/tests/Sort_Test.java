package com.haruatari.task4.tests;

import com.haruatari._src.loggers.CaseLogger;
import com.haruatari._src.tests.CasesBatchTest;
import com.haruatari.task4.Task;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

final class Sort_Test extends CasesBatchTest {
    public static void main(String[] args) {
        new Sort_Test().run();
    }

    @Override
    protected String getCasesBatchName() {
        return "void sort(int[] list)";
    }

    @Override
    protected Map<String, Consumer<CaseLogger>> getCases() {
        return new HashMap<>() {{
            put("An already sorted array", l -> runCase(l, new int[]{10, 20, 30, 40, 50}, new int[]{10, 20, 30, 40, 50}));
            put("An array in the revert order", l -> runCase(l, new int[]{50, 40, 30, 20, 10}, new int[]{10, 20, 30, 40, 50}));
            put("An unsorted array", l -> runCase(l, new int[]{10, 20, 10, 30, 50, 40}, new int[]{10, 10, 20, 30, 40, 50}));
            put("All elements are equals", l -> runCase(l, new int[]{10, 10, 10}, new int[]{10, 10, 10}));
            put("An one-element array", l -> runCase(l, new int[]{10}, new int[]{10}));
            put("An empty array", l -> runCase(l, new int[]{}, new int[]{}));
        }};
    }

    private void runCase(CaseLogger logger, int[] list, int[] expected) {
        logger
            .setArguments(new HashMap<>() {{
                put("list", Arrays.toString(list));
            }});

        new Task().sort(list);

        logger
            .setExpected(Arrays.toString(expected))
            .setActual(Arrays.toString(list))
            .setIsSuccess(Arrays.equals(list, expected));
    }
}
