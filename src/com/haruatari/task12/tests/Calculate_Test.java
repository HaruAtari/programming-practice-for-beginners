package com.haruatari.task12.tests;

import com.haruatari._src.loggers.CaseLogger;
import com.haruatari._src.tests.MethodTest;
import com.haruatari.task12.Task;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

final class Calculate_Test extends MethodTest {
    public static void main(String[] args) {
        new Calculate_Test().run();
    }

    @Override
    protected String getMethodName() {
        return "int calculate(int[] values, int[] indexes)";
    }

    @Override
    protected Map<String, Consumer<CaseLogger>> getCases() {
        return new HashMap<>() {{
            put("Normal", l -> runCase(l, new int[]{10, 20, 30, 40}, new int[]{0, 1, 2, 3}, 100));
            put("Not existing index", l -> runCase(l, new int[]{-10, -20, -30}, new int[]{10, 0, 1, 2}, -60));
            put("Repeated index", l -> runCase(l, new int[]{10, 20, 30}, new int[]{1, 0, 1}, 50));
            put("An empty list of indexes", l -> runCase(l, new int[]{10, 20, 30}, new int[]{}, 0));
            put("An empty list of value", l -> runCase(l, new int[]{}, new int[]{0, 1, 2}, 0));
            put("No values and indexes", l -> runCase(l, new int[]{}, new int[]{}, 0));
        }};
    }

    private void runCase(CaseLogger logger, int[] values, int[] indexes, int expected) {
        var actual = new Task().calculate(values, indexes);
        logger
            .setArguments(new HashMap<>() {{
                put("values", Arrays.toString(values));
                put("indexes", Arrays.toString(indexes));
            }})
            .setExpected(String.valueOf(expected))
            .setActual(String.valueOf(actual))
            .setIsSuccess(expected == actual);
    }
}
