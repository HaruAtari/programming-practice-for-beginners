package com.haruatari.task6.tests;

import com.haruatari._src.loggers.CaseLogger;
import com.haruatari._src.tests.CasesBatchTest;
import com.haruatari.task6.Task;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

final class Fold_Test extends CasesBatchTest {
    public static void main(String[] args) {
        new Fold_Test().run();
    }

    @Override
    protected String getCasesBatchName() {
        return "int fold(int[] list)";
    }

    @Override
    protected Map<String, Consumer<CaseLogger>> getCases() {
        return new HashMap<>() {{
            put("Positive numbers", l -> runCase(l, new int[]{10, 20, 30, 60, 80, 50}, 250));
            put("Negative numbers", l -> runCase(l, new int[]{-10, -20, -30, -60, -80, -50}, -250));
            put("A one-element list", l -> runCase(l, new int[]{10}, 10));
            put("A empty list", l -> runCase(l, new int[]{}, 0));
        }};
    }

    private void runCase(CaseLogger logger, int[] list, int expected) {
        var actual = new Task().fold(list);
        logger
            .setArguments(new HashMap<>() {{
                put("list", Arrays.toString(list));
            }})
            .setExpected(String.valueOf(expected))
            .setActual(String.valueOf(actual))
            .setIsSuccess(actual == expected);
    }
}
