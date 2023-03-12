package com.haruatari.task4;

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
        return TaskNumber.TASK_4;
    }

    @Override
    public void run() {
        testSortCase(new int[]{10, 20, 30, 40, 50}, new int[]{10, 20, 30, 40, 50});
        testSortCase(new int[]{50, 40, 30, 20, 10}, new int[]{10, 20, 30, 40, 50});
        testSortCase(new int[]{10, 20, 10}, new int[]{10, 10, 20});
        testSortCase(new int[]{10, 10, 10}, new int[]{10, 10, 10});
        testSortCase(new int[]{10}, new int[]{10});
        testSortCase(new int[]{}, new int[]{});
        showTotalResult();
    }

    public void testSortCase(int[] list, int[] expected) {
        new Task().sort(list);
        var isSuccess = Arrays.equals(list, expected);

        logCase(
                "void sort(int[] list)",
                new HashMap<>() {{
                    put("list", Arrays.toString(list));
                }},
                Arrays.toString(expected),
                Arrays.toString(list),
                isSuccess
        );
    }
}
