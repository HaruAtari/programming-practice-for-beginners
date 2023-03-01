package com.haruatari.task6;

import com.haruatari.BaseTest;

import java.util.Arrays;
import java.util.HashMap;

final public class Test extends BaseTest {
    public static void main(String[] args) {
        new Test().run();
    }

    @Override
    public void run() {
        testFoldCase(new int[]{10, 20, 30}, 60);
        testFoldCase(new int[]{-10, -20, -30}, -60);
        testFoldCase(new int[]{10}, 10);
        testFoldCase(new int[]{}, 0);

        logTotalResult();
    }

    public void testFoldCase(int[] list, int expected) {
        logMethodName("int fold(int[] list)");
        logMethodArguments(new HashMap<>() {{
            put("list", Arrays.toString(list));
        }});

        var actual = new Task().fold(list);
        var isSuccess = actual == expected;

        logMethodResults(String.valueOf(expected), String.valueOf(actual), isSuccess);
        increaseCasesCounter(isSuccess);
    }
}
