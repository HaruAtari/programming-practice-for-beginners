package com.haruatari.task27.tests;

import com.haruatari._src.Helper;
import com.haruatari._src.loggers.CaseLogger;
import com.haruatari._src.tests.MethodTest;
import com.haruatari.task27.Task;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

final class GetUnique_Test extends MethodTest {
    public static void main(String[] args) {
        new GetUnique_Test().run();
    }

    @Override
    protected String getMethodName() {
        return "List<Integer> Task.getUnique(List<Integer> list)";
    }

    @Override
    protected Map<String, Consumer<CaseLogger>> getCases() {
        return new HashMap<>() {{
            put("No unique values", l -> runCase(l, List.of(10, 10, 10, 10, 10), List.of(10)));
            put("All values are unique", l -> runCase(l, List.of(10, 20, 50, 40, 30), List.of(10, 20, 30, 40, 50)));
            put("Several duplicated values", l -> runCase(l, List.of(10, 50, 20, 50, 10, 10, 10, 60), List.of(10, 20, 50, 60)));
            put("A one-value list", l -> runCase(l, List.of(10), List.of(10)));
            put("An empty list", l -> runCase(l, List.of(), List.of()));
        }};
    }

    private void runCase(CaseLogger logger, List<Integer> list, List<Integer> expected) {
        var actual = new Task().getUnique(list);
        logger
            .setArguments(new HashMap<>() {{
                put("list", Helper.alignList(list, true));
            }})
            .setExpected(Helper.alignList(expected, true))
            .setActual(Helper.alignList(actual, true))
            .setIsSuccess(Helper.compareListsIgnoringOrder(expected, actual));
    }
}
