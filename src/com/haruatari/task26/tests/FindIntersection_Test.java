package com.haruatari.task26.tests;

import com.haruatari._src.Helper;
import com.haruatari._src.loggers.CaseLogger;
import com.haruatari._src.tests.CasesBatchTest;
import com.haruatari.task26.Task;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

final class FindIntersection_Test extends CasesBatchTest {
    public static void main(String[] args) {
        new FindIntersection_Test().run();
    }

    @Override
    protected String getCasesBatchName() {
        return "List<Integer> Task.findIntersection(List<Integer> x, List<Integer> y)";
    }

    @Override
    protected Map<String, Consumer<CaseLogger>> getCases() {
        return new HashMap<>() {{
            put("No common values", l -> runCase(l, List.of(10, 20, 30, 40), List.of(50, 60, 70, 80, 90), List.of()));
            put("No common values (unsorted)", l -> runCase(l, List.of(20, 10, 40, 30), List.of(50, 90, 70, 60, 80), List.of()));
            put("Several common values", l -> runCase(l, List.of(10, 20, 30, 40), List.of(20, 40, 70, 80, 90), List.of(20, 40)));
            put("All values are common", l -> runCase(l, List.of(10, 20, 30, 40, 50), List.of(10, 20, 30, 40, 50), List.of(10, 20, 30, 40, 50)));
            put("All values are in revert order", l -> runCase(l, List.of(10, 20, 30, 40, 50), List.of(50, 40, 30, 20, 10), List.of(10, 20, 30, 40, 50)));
            put("The first list is empty", l -> runCase(l, List.of(), List.of(10, 20, 30, 40), List.of()));
            put("The second list is empty", l -> runCase(l, List.of(10, 20, 30, 40), List.of(), List.of()));
            put("Both lists are empty", l -> runCase(l, List.of(), List.of(), List.of()));
            put("The first list contains only one value", l -> runCase(l, List.of(10), List.of(10, 20, 30, 40), List.of(10)));
            put("The second list contains only one value", l -> runCase(l, List.of(10, 20, 30, 40), List.of(30), List.of(30)));
            put("Both lists contain only one element", l -> runCase(l, List.of(10), List.of(10), List.of(10)));
        }};
    }

    private void runCase(CaseLogger logger, List<Integer> x, List<Integer> y, List<Integer> expected) {
        var actual = new Task().findIntersection(x, y);
        logger
            .setArguments(new HashMap<>() {{
                put("x", Helper.alignList(x, true));
                put("y", Helper.alignList(y, true));
            }})
            .setExpected(Helper.alignList(expected, true))
            .setActual(Helper.alignList(actual, true))
            .setIsSuccess(Helper.compareListsIgnoringOrder(actual, expected));
    }
}
