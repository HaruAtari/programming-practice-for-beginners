package com.haruatari.task7.tests;

import com.haruatari._src.loggers.CaseLogger;
import com.haruatari._src.tests.MethodTest;
import com.haruatari.task7.Task;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.Consumer;

final class Zip_Test extends MethodTest {
    public static void main(String[] args) {
        new Zip_Test().run();
    }

    @Override
    protected String getMethodName() {
        return "int[][] zip(int[] x, int[] y)";
    }

    @Override
    protected Map<String, Consumer<CaseLogger>> getCases() {
        return new HashMap<>() {{
            put("X and Y have equals lengths", l -> runCase(l, new int[]{1, 2, 3, 4, 5, 6}, new int[]{10, 20, 30, 40, 50, 60}, new int[][]{{1, 10}, {2, 20}, {3, 30}, {4, 40}, {5, 50}, {6, 60}}));
            put("X and Y are equals", l -> runCase(l, new int[]{1, 1, 1, 1, 1,}, new int[]{1, 1, 1, 1, 1}, new int[][]{{1, 1}, {1, 1}, {1, 1}, {1, 1}, {1, 1}}));
            put("X is longer then Y", l -> runCase(l, new int[]{1, 2, 3, 4, 5, 6}, new int[]{10, 20, 30}, new int[][]{{1, 10}, {2, 20}, {3, 30}, {4, -1}, {5, -1}, {6, -1}}));
            put("X is shorter then Y", l -> runCase(l, new int[]{1, 2, 3}, new int[]{10, 20, 30, 40, 50, 60}, new int[][]{{1, 10}, {2, 20}, {3, 30}, {-1, 40}, {-1, 50}, {-1, 60}}));
            put("Y is empty", l -> runCase(l, new int[]{1, 2, 3, 4, 5}, new int[]{}, new int[][]{{1, -1}, {2, -1}, {3, -1}, {4, -1}, {5, -1}}));
            put("X is empty", l -> runCase(l, new int[]{}, new int[]{10, 20, 30, 40}, new int[][]{{-1, 10}, {-1, 20}, {-1, 30}, {-1, 40}}));
            put("X and Y are empty", l -> runCase(l, new int[]{}, new int[]{}, new int[][]{}));
        }};
    }

    private void runCase(CaseLogger logger, int[] x, int[] y, int[][] expected) {
        var actual = new Task().zip(x, y);
        logger
            .setArguments(new HashMap<>() {{
                put("x", Arrays.toString(x));
                put("y", Arrays.toString(y));
            }})
            .setExpected(Arrays.deepToString(expected))
            .setActual(Arrays.deepToString(actual))
            .setIsSuccess(Objects.deepEquals(actual, expected));
    }
}
