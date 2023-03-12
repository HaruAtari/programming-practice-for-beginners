package com.haruatari.task12;

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
        return TaskNumber.TASK_12;
    }

    @Override
    public void run() {
        testCalculateCase(new int[]{10, 20, 30, 40}, new int[]{0, 1, 2, 3}, 100);
        testCalculateCase(new int[]{-10, -20, -30}, new int[]{0, 1, 2, 10}, -60);
        testCalculateCase(new int[]{-10, -20, -30}, new int[]{10, 0, 1, 2}, -60);
        testCalculateCase(new int[]{10, 20, 30}, new int[]{1, 0, 1}, 50);
        testCalculateCase(new int[]{10, 20, 30}, new int[]{}, 0);
        testCalculateCase(new int[]{}, new int[]{0, 1, 2}, 0);
        testCalculateCase(new int[]{}, new int[]{}, 0);

        showTotalResult();
    }

    public void testCalculateCase(int[] values, int[] indexes, int expected) {
        var actual = new Task().calculate(values, indexes);
        var isSuccess = actual == expected;

        logCase(
                "int calculate(int[] values, int[] indexes)",
                new HashMap<>() {{
                    put("values", Arrays.toString(values));
                    put("indexes", Arrays.toString(indexes));
                }},
                String.valueOf(expected),
                String.valueOf(actual),
                isSuccess
        );
    }
}
