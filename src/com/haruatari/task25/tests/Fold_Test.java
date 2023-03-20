package com.haruatari.task25.tests;

import com.haruatari._src.Helper;
import com.haruatari._src.loggers.CaseLogger;
import com.haruatari._src.tests.MethodTest;
import com.haruatari.task25.Task;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.stream.Collectors;

final class Fold_Test extends MethodTest {
    public static void main(String[] args) {
        new Fold_Test().run();
    }

    @Override
    protected String getMethodName() {
        return "int fold(List<List<Integer>> list)";
    }

    @Override
    protected Map<String, Consumer<CaseLogger>> getCases() {
        return new HashMap<>() {{
            var i = 1;
            put(String.valueOf(i++), l -> runCase(l, List.of(List.of(10, 20), List.of(30, 40), List.of(50, 60)), 210));
            put(String.valueOf(i++), l -> runCase(l, List.of(List.of(-10, -20), List.of(-30, -40), List.of(-50, -60)), -210));
            put(String.valueOf(i++), l -> runCase(l, List.of(List.of(10, 20, 30), List.of(40, 50, 60)), 210));
            put(String.valueOf(i++), l -> runCase(l, List.of(List.of(-10, -20, -30), List.of(-40, -50, -60)), -210));
            put(String.valueOf(i++), l -> runCase(l, List.of(List.of(10, 20), List.of(30), List.of(40, 50, 60)), 210));
            put(String.valueOf(i++), l -> runCase(l, List.of(), 0));
            put(String.valueOf(i++), l -> runCase(l, List.of(List.of(), List.of()), 0));
        }};
    }

    private void runCase(CaseLogger logger, List<List<Integer>> list, int expected) {
        var actual = new Task().fold(list);
        logger
            .setArguments(new HashMap<>() {{
                put("list", "List(\n" + list.stream().map(i -> "  " + Helper.alignList(i, true)).collect(Collectors.joining("\n")) + "\n)");
            }})
            .setExpected(String.valueOf(expected))
            .setActual(String.valueOf(actual))
            .setIsSuccess(expected == actual);
    }
}
