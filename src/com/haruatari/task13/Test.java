package com.haruatari.task13;

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
        return TaskNumber.TASK_13;
    }

    @Override
    public void run() {
        testCase(new int[]{10, 20, 30}, 10, 1);
        testCase(new int[]{10, 20, 30}, 30, 1);
        testCase(new int[]{10, 20, 10}, 10, 2);
        testCase(new int[]{10, 20, 30}, 40, 0);
        testCase(new int[]{10}, 10, 1);
        testCase(new int[]{}, 10, 0);

        showTotalResult();
    }

    private void testCase(int[] list, int value, int expected) {
        var actual = new Task().countOccurrences(list, value);
        var isSuccess = actual == expected;

        logCase(
                "int countOccurrences(int[] list, int value)",
                new HashMap<>() {{
                    put("list", Arrays.toString(list));
                    put("value", String.valueOf(value));
                }},
                String.valueOf(expected),
                String.valueOf(actual),
                isSuccess
        );
    }
}
