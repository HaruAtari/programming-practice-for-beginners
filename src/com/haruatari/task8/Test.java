package com.haruatari.task8;

import com.haruatari.BaseTest;
import com.haruatari.TaskNumber;

import java.util.Arrays;
import java.util.HashMap;

final public class Test extends BaseTest {
    public static void main(String[] args) {
        new Test().run();
    }

    @Override
    public TaskNumber getNumber() {
        return TaskNumber.TASK_8;
    }

    @Override
    public void run() {
        testMinCase(new int[]{10, 20, 30}, 10);
        testMinCase(new int[]{10, 20, 10}, 10);
        testMinCase(new int[]{-10, -20, -30}, -30);
        testMinCase(new int[]{30, 10, 20}, 10);
        testMinCase(new int[]{20, 20, 20, 20}, 20);
        testMinCase(new int[]{Integer.MIN_VALUE, 0, Integer.MAX_VALUE}, Integer.MIN_VALUE);
        testMinCase(new int[]{20}, 20);
        testMinCase(new int[]{0}, 0);
        testMinCase(new int[]{}, 0);

        testMaxCase(new int[]{10, 20, 30}, 30);
        testMaxCase(new int[]{20, 10, 20}, 20);
        testMaxCase(new int[]{-10, -20, -30}, -10);
        testMaxCase(new int[]{10, 30, 20}, 30);
        testMaxCase(new int[]{20, 20, 20, 20}, 20);
        testMaxCase(new int[]{Integer.MIN_VALUE, 0, Integer.MAX_VALUE}, Integer.MAX_VALUE);
        testMaxCase(new int[]{20}, 20);
        testMaxCase(new int[]{0}, 0);
        testMaxCase(new int[]{}, 0);

        logTotalResult();
    }

    private void testMinCase(int[] list, int expected) {
        logMethodName("int min(int[] list)");
        logMethodArguments(new HashMap<>() {{
            put("list", Arrays.toString(list));
        }});

        var actual = new Task().min(list);
        var isSuccess = actual == expected;

        logMethodResults(String.valueOf(expected), String.valueOf(actual), isSuccess);
        increaseCasesCounter(isSuccess);
    }

    private void testMaxCase(int[] list, int expected) {
        logMethodName("int max(int[] list)");
        logMethodArguments(new HashMap<>() {{
            put("list", Arrays.toString(list));
        }});

        var actual = new Task().min(list);
        var isSuccess = actual == expected;

        logMethodResults(String.valueOf(expected), String.valueOf(actual), isSuccess);
        increaseCasesCounter(isSuccess);
    }
}
