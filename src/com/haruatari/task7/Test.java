package com.haruatari.task7;

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
        return TaskNumber.TASK_7;
    }

    @Override
    public void run() {
        testZipCase(new int[]{1, 2, 3}, new int[]{10, 20, 30}, new int[][]{{1, 10}, {2, 20}, {3, 30}});
        testZipCase(new int[]{1, 1, 1}, new int[]{1, 1, 1}, new int[][]{{1, 1}, {1, 1}, {1, 1}});
        testZipCase(new int[]{1, 2, 3}, new int[]{10, 20}, new int[][]{{1, 10}, {2, 20}, {3, -1}});
        testZipCase(new int[]{1, 2}, new int[]{}, new int[][]{{1, -1}, {2, -1}});
        testZipCase(new int[]{}, new int[]{10, 20}, new int[][]{{-1, 10}, {-1, 20}});
        testZipCase(new int[]{}, new int[]{}, new int[][]{});

        showTotalResult();
    }

    private void testZipCase(int[] x, int[] y, int[][] expected) {
        var actual = new Task().zip(x, y);
        var isSuccess = Arrays.deepEquals(actual, expected);

        logCase(
                "int[][] zip(int[] x, int[] y)",
                new HashMap<>() {{
                    put("x", Arrays.toString(x));
                    put("y", Arrays.toString(y));
                }},
                Arrays.deepToString(expected),
                Arrays.deepToString(actual),
                isSuccess
        );
    }
}
