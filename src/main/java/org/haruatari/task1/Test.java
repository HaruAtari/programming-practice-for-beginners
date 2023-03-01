package org.haruatari.task1;

import org.haruatari.BaseTest;

import java.util.HashMap;

final public class Test extends BaseTest {
    public static void main(String[] args) {
        new Test().run();
    }

    @Override
    public void run() {
        testSumCase(0, 0, 0);
        testSumCase(1, 2, 3);
        testSumCase(-1, -2, -3);

        testSubCase(0, 0, 0);
        testSubCase(3, 2, 1);
        testSubCase(-3, -2, -1);

        logTotalResult();
    }

    private void testSumCase(int x, int y, int expected) {
        logMethodName("int sum(int x, int y)");
        logMethodArguments(new HashMap<>() {{
            put("x", String.valueOf(x));
            put("y", String.valueOf(y));
        }});

        var actual = new Task().sum(x, y);
        var isSuccess = actual == expected;

        logMethodResults(String.valueOf(expected), String.valueOf(actual), isSuccess);
        increaseCasesCounter(isSuccess);
    }

    private void testSubCase(int x, int y, int expected) {
        logMethodName("int sub(int x, int y)");
        logMethodArguments(new HashMap<>() {{
            put("x", String.valueOf(x));
            put("y", String.valueOf(y));
        }});

        var actual = new Task().sub(x, y);
        var isSuccess = actual == expected;

        logMethodResults(String.valueOf(expected), String.valueOf(actual), isSuccess);
        increaseCasesCounter(isSuccess);
    }
}
