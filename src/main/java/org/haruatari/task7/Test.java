package org.haruatari.task7;

import org.haruatari.BaseTest;

import java.util.Arrays;
import java.util.HashMap;

final public class Test extends BaseTest {
    public static void main(String[] args) {
        new Test().run();
    }

    @Override
    public void run() {
        testZipCase(new int[]{1, 2, 3}, new int[]{10, 20, 30}, new int[][]{{1, 10}, {2, 20}, {3, 30}});
        testZipCase(new int[]{1, 1, 1}, new int[]{1, 1, 1}, new int[][]{{1, 1}, {1, 1}, {1, 1}});
        testZipCase(new int[]{1, 2, 3}, new int[]{10, 20}, new int[][]{{1, 10}, {2, 20}, {3, -1}});
        testZipCase(new int[]{1, 2}, new int[]{}, new int[][]{{1, -1}, {2, -1}});
        testZipCase(new int[]{}, new int[]{10, 20}, new int[][]{{-1, 10}, {-1, 20}});
        testZipCase(new int[]{}, new int[]{}, new int[][]{});

        logTotalResult();
    }

    private void testZipCase(int[] x, int[] y, int[][] expected) {
        logMethodName("int[][] zip(int[] x, int[] y)");
        logMethodArguments(new HashMap<>() {{
            put("x", Arrays.toString(x));
            put("y", Arrays.toString(y));
        }});

        var actual = new Task().zip(x, y);
        var isSuccess = Arrays.deepEquals(actual, expected);

        logMethodResults(Arrays.deepToString(expected), Arrays.deepToString(actual), isSuccess);
        increaseCasesCounter(isSuccess);
    }
}
