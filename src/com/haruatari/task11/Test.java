package com.haruatari.task11;

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
        return TaskNumber.TASK_11;
    }

    @Override
    public void run() {
        testFoldCase(new int[][]{{10, 20}, {30, 40}, {50, 60}}, 210);
        testFoldCase(new int[][]{{-10, -20}, {-30, -40}, {-50, -60}}, -210);
        testFoldCase(new int[][]{{10, 20, 30}, {40, 50, 60}}, 210);
        testFoldCase(new int[][]{{-10, -20, -30}, {-40, -50, -60}}, -210);
        testFoldCase(new int[][]{{10, 20}, {30}, {40, 50, 60}}, 210);
        testFoldCase(new int[][]{}, 0);
        testFoldCase(new int[][]{{}, {}}, 0);

        logTotalResult();
    }

    public void testFoldCase(int[][] list, int expected) {
        logMethodName("int fold(int[][] list)");
        logMethodArguments(new HashMap<>() {{
            put("list", Arrays.deepToString(list));
        }});

        var actual = new Task().fold(list);
        var isSuccess = actual == expected;

        logMethodResults(String.valueOf(expected), String.valueOf(actual), isSuccess);
        increaseCasesCounter(isSuccess);
    }
}
