package com.haruatari.task2;

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
        return TaskNumber.TASK_2;
    }

    @Override
    public void run() {
        testFindFirstCase(new int[]{10, 20, 30}, 10, 0);
        testFindFirstCase(new int[]{10, 20, 30}, 30, 2);
        testFindFirstCase(new int[]{10, 20, 10}, 10, 0);
        testFindFirstCase(new int[]{10, 20, 30}, 40, -1);
        testFindFirstCase(new int[]{}, 10, -1);

        testFindLastCase(new int[]{10, 20, 30}, 10, 0);
        testFindLastCase(new int[]{10, 20, 30}, 30, 2);
        testFindLastCase(new int[]{10, 20, 10}, 10, 2);
        testFindLastCase(new int[]{10, 20, 30}, 40, -1);
        testFindLastCase(new int[]{}, 10, -1);

        showTotalResult();
    }

    private void testFindFirstCase(int[] list, int value, int expected) {
        var actual = new Task().findFirst(list, value);
        var isSuccess = actual == expected;

        logCase(
                "int findFirst(int[] list, int value)",
                new HashMap<>() {{
                    put("list", Arrays.toString(list));
                    put("value", String.valueOf(value));
                }},
                String.valueOf(expected),
                String.valueOf(actual),
                isSuccess
        );
    }

    private void testFindLastCase(int[] list, int value, int expected) {
        var actual = new Task().findLast(list, value);
        var isSuccess = actual == expected;

        logCase(
                "int findLast(int[] list, int value)",
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
