package com.haruatari.task3;

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
        return TaskNumber.TASK_3;
    }

    @Override
    public void run() {
        testMergeCase(new int[]{10, 20}, new int[]{30, 40}, new int[]{10, 20, 30, 40});
        testMergeCase(new int[]{30, 40}, new int[]{10, 20}, new int[]{30, 40, 10, 20});
        testMergeCase(new int[]{10}, new int[]{10}, new int[]{10, 10});
        testMergeCase(new int[]{}, new int[]{10}, new int[]{10});
        testMergeCase(new int[]{10}, new int[]{}, new int[]{10});
        testMergeCase(new int[]{}, new int[]{}, new int[]{});

        showTotalResult();
    }

    public void testMergeCase(int[] x, int[] y, int[] expected) {
        var actual = new Task().merge(x, y);
        var isSuccess = Arrays.equals(actual, expected);

        logCase(
                "int[] merge(int[] x, int[] y)",
                new HashMap<>() {{
                    put("x", Arrays.toString(x));
                    put("y", Arrays.toString(y));
                }},
                Arrays.toString(expected),
                Arrays.toString(actual),
                isSuccess
        );
    }

}
