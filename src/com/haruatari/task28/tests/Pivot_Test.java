package com.haruatari.task28.tests;

import com.haruatari._src.Helper;
import com.haruatari._src.loggers.CaseLogger;
import com.haruatari._src.tests.MethodTest;
import com.haruatari.task28.Task;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.Consumer;

final class Pivot_Test extends MethodTest {
    public static void main(String[] args) {
        new Pivot_Test().run();
    }

    @Override
    protected String getMethodName() {
        return "Map<Integer, String> Task.pivot(Map<String, Integer> map)";
    }

    @Override
    protected Map<String, Consumer<CaseLogger>> getCases() {
        return new HashMap<>() {{
            put("A small normal map", l -> runCase(
                l,
                new HashMap<>() {{
                    put("Bob", 29);
                    put("Alice", 41);
                }},
                new HashMap<>() {{
                    put(29, "Bob");
                    put(41, "Alice");
                }}
            ));
            put("A big normal map", l -> runCase(
                l,
                new HashMap<>() {{
                    put("Viktor", 31);
                    put("Marina", 23);
                    put("Bob", 29);
                    put("Alice", 41);
                    put("Alina", 28);
                }},
                new HashMap<>() {{
                    put(31, "Viktor");
                    put(23, "Marina");
                    put(29, "Bob");
                    put(28, "Alina");
                    put(41, "Alice");
                }}
            ));
            put("A one-element map", l -> runCase(
                l,
                new HashMap<>() {{
                    put("Marina", 23);
                }},
                new HashMap<>() {{
                    put(23, "Marina");
                }}
            ));
            put("An empty map", l -> runCase(l, Collections.emptyMap(), Collections.emptyMap()));
        }};
    }

    private void runCase(CaseLogger logger, Map<String, Integer> map, Map<Integer, String> expected) {
        var actual = new Task().pivot(map);
        logger
            .setArguments(new HashMap<>() {{
                put("map", Helper.alignMap(map));
            }})
            .setExpected(Helper.alignMap(expected))
            .setActual(Helper.alignMap(actual))
            .setIsSuccess(Objects.equals(expected, actual));
    }
}
