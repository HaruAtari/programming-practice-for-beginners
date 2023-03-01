package org.haruatari.task3;

import org.haruatari.BaseTest;

import java.util.Arrays;
import java.util.HashMap;

final public class Test extends BaseTest {
    public static void main(String[] args) {
        new Test().run();
    }

    @Override
    public void run() {
        testMergeCase(new int[]{10, 20}, new int[]{30, 40}, new int[]{10, 20, 30, 40});
        testMergeCase(new int[]{30, 40}, new int[]{10, 20}, new int[]{30, 40, 10, 20});
        testMergeCase(new int[]{10}, new int[]{10}, new int[]{10, 10});
        testMergeCase(new int[]{}, new int[]{10}, new int[]{10});
        testMergeCase(new int[]{10}, new int[]{}, new int[]{10});
        testMergeCase(new int[]{}, new int[]{}, new int[]{});

        logTotalResult();
    }

    public void testMergeCase(int[] x, int[] y, int[] expected) {
        logMethodName("int[] merge(int[] x, int[] y)");
        logMethodArguments(new HashMap<>() {{
            put("x", Arrays.toString(x));
            put("y", Arrays.toString(y));
        }});

        var actual = new Task().merge(x, y);
        var isSuccess = Arrays.equals(actual, expected);

        logMethodResults(Arrays.toString(expected), Arrays.toString(actual), isSuccess);
        increaseCasesCounter(isSuccess);
    }

}
