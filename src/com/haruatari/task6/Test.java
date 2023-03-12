package com.haruatari.task6;

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
        return TaskNumber.TASK_6;
    }

    @Override
    public void run() {
        testFoldCase(new int[]{10, 20, 30}, 60);
        testFoldCase(new int[]{-10, -20, -30}, -60);
        testFoldCase(new int[]{10}, 10);
        testFoldCase(new int[]{}, 0);

        showTotalResult();
    }

    public void testFoldCase(int[] list, int expected) {
        var actual = new Task().fold(list);
        var isSuccess = actual == expected;

        logCase(
                "int fold(int[] list)",
                new HashMap<>() {{
                    put("list", Arrays.toString(list));
                }},
                String.valueOf(expected),
                String.valueOf(actual),
                isSuccess
        );
    }
}
