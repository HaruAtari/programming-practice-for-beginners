package com.haruatari.task23.tests;

import com.haruatari._src.Helper;
import com.haruatari._src.loggers.CaseLogger;
import com.haruatari._src.tests.CasesBatchTest;
import com.haruatari.task23.Task;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

final class Merge_Test extends CasesBatchTest {
    public static void main(String[] args) {
        new Merge_Test().run();
    }

    @Override
    protected String getCasesBatchName() {
        return "List<Integer> merge(List<Integer> x, List<Integer> y)";
    }

    @Override
    protected Map<String, Consumer<CaseLogger>> getCases() {
        return new HashMap<>() {{
            put("1", l -> runCase(l, List.of(10, 20), List.of(30, 40), List.of(10, 20, 30, 40)));
            put("2", l -> runCase(l, List.of(30, 40), List.of(10, 20), List.of(30, 40, 10, 20)));
            put("3", l -> runCase(l, List.of(10), List.of(10), List.of(10, 10)));
            put("4", l -> runCase(l, List.of(), List.of(10), List.of(10)));
            put("5", l -> runCase(l, List.of(10), List.of(), List.of(10)));
            put("6", l -> runCase(l, List.of(), List.of(), List.of()));
        }};
    }

    private void runCase(CaseLogger logger, List<Integer> x, List<Integer> y, List<Integer> expected) {
        var actual = new Task().merge(x, y);

        logger
            .setArguments(new HashMap<>() {{
                put("x", Helper.alignList(x, true));
                put("y", Helper.alignList(y, true));
            }})
            .setExpected(Helper.alignList(expected, true))
            .setActual(Helper.alignList(actual, true))
            .setIsSuccess(Helper.compareListsIgnoringOrder(expected, actual));
    }
}
