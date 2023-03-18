package com.haruatari.task1.tests;

import com.haruatari._src.loggers.CaseLogger;
import com.haruatari._src.tests.MethodTest;
import com.haruatari.task1.Task;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

final class Sub_Test extends MethodTest {
    public static void main(String[] args) {
        new Sub_Test().run();
    }

    @Override
    protected String getMethodName() {
        return "int sub(int x, int y)";
    }

    @Override
    protected Map<String, Consumer<CaseLogger>> getCases() {
        return new HashMap<>() {{
            put("1", l -> runCase(l, 0, 0, 0));
            put("2", l -> runCase(l, 3, 2, 1));
            put("3", l -> runCase(l, -3, -2, -1));
        }};
    }

    private void runCase(CaseLogger logger, int x, int y, int expected) {
        var actual = new Task().sub(x, y);

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
