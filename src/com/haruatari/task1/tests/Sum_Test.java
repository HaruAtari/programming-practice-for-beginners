package com.haruatari.task1.tests;

import com.haruatari._src.loggers.CaseLogger;
import com.haruatari._src.tests.CasesBatchTest;
import com.haruatari.task1.Task;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

final class Sum_Test extends CasesBatchTest {
    public static void main(String[] args) {
        new Sum_Test().run();
    }

    @Override
    protected String getCasesBatchName() {
        return "int sum(int x, int y)";
    }

    @Override
    protected Map<String, Consumer<CaseLogger>> getCases() {
        return new HashMap<>() {{
            put("1", l -> runCase(l, 0, 0, 0));
            put("2", l -> runCase(l, 1, 2, 3));
            put("3", l -> runCase(l, -1, -2, -3));
        }};
    }

    private void runCase(CaseLogger logger, int x, int y, int expected) {
        var actual = new Task().sum(x, y);

        logger
            .setArguments(new HashMap<>() {{
                put("x", String.valueOf(x));
                put("y", String.valueOf(y));
            }})
            .setExpected(String.valueOf(expected))
            .setActual(String.valueOf(actual))
            .setIsSuccess(expected == actual);
    }
}
