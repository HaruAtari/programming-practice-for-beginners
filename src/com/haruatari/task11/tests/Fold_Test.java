package com.haruatari.task11.tests;

import com.haruatari._src.loggers.CaseLogger;
import com.haruatari._src.tests.CasesBatchTest;
import com.haruatari.task11.Task;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

final class Fold_Test extends CasesBatchTest {
    public static void main(String[] args) {
        new Fold_Test().run();
    }

    @Override
    protected String getCasesBatchName() {
        return "int fold(int[][] list)";
    }

    @Override
    protected Map<String, Consumer<CaseLogger>> getCases() {
        return new HashMap<>() {{
            var i = 1;
            put(String.valueOf(i++), l -> runCase(l, new int[][]{{10, 20}, {30, 40}, {50, 60}}, 210));
            put(String.valueOf(i++), l -> runCase(l, new int[][]{{-10, -20}, {-30, -40}, {-50, -60}}, -210));
            put(String.valueOf(i++), l -> runCase(l, new int[][]{{10, 20, 30}, {40, 50, 60}}, 210));
            put(String.valueOf(i++), l -> runCase(l, new int[][]{{-10, -20, -30}, {-40, -50, -60}}, -210));
            put(String.valueOf(i++), l -> runCase(l, new int[][]{{10, 20}, {30}, {40, 50, 60}}, 210));
            put(String.valueOf(i++), l -> runCase(l, new int[][]{}, 0));
            put(String.valueOf(i++), l -> runCase(l, new int[][]{{}, {}}, 0));
        }};
    }

    private void runCase(CaseLogger logger, int[][] list, int expected) {
        var actual = new Task().fold(list);
        logger
            .setArguments(new HashMap<>() {{
                put("list", Arrays.deepToString(list));
            }})
            .setExpected(String.valueOf(expected))
            .setActual(String.valueOf(actual))
            .setIsSuccess(expected == actual);
    }
}
