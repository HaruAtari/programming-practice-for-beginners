package com.haruatari.task22.tests;

import com.haruatari._src.Helper;
import com.haruatari._src.loggers.CaseLogger;
import com.haruatari._src.tests.CasesBatchTest;
import com.haruatari.task22.Dish;
import com.haruatari.task22.Friend;
import com.haruatari.task22.Task;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

public class MakeOrder_Test extends CasesBatchTest {
    public static void main(String[] args) {
        new MakeOrder_Test().run();
    }

    @Override
    protected String getCasesBatchName() {
        return "Map<Dish, List<Friend>> makeOrder(Map<Friend, List<Dish>> friendsOrders)";
    }

    @Override
    protected Map<String, Consumer<CaseLogger>> getCases() {
        var instance = this;
        return new HashMap<>() {{
            put("A normal order", instance::normal);
            put("One friend has an empty order", instance::oneEmpty);
            put("All friends have empty orders", instance::allEmpty);
            put("All friends order the same dishes", instance::same);
            put("All friends order different dishes", instance::different);
        }};
    }

    private void normal(CaseLogger logger) {
        var order = new HashMap<Friend, List<Dish>>() {{
            put(new Friend("Bob"), new ArrayList<>() {{
                add(new Dish("Tea"));
                add(new Dish("Meat"));
                add(new Dish("Soup"));
            }});
            put(new Friend("Alice"), new ArrayList<>() {{
                add(new Dish("Salad"));
                add(new Dish("Cake"));
                add(new Dish("Soup"));
            }});
            put(new Friend("Marina"), new ArrayList<>() {{
                add(new Dish("Salad"));
                add(new Dish("Tea"));
                add(new Dish("Soup"));
                add(new Dish("Cocktail"));
            }});
            put(new Friend("Viktor"), new ArrayList<>() {{
                add(new Dish("Meat"));
                add(new Dish("Tea"));
            }});
        }};
        var expected = new HashMap<Dish, List<Friend>>() {{
            put(new Dish("Tea"), new ArrayList<>() {{
                add(new Friend("Bob"));
                add(new Friend("Marina"));
                add(new Friend("Viktor"));
            }});
            put(new Dish("Meat"), new ArrayList<>() {{
                add(new Friend("Bob"));
                add(new Friend("Viktor"));
            }});
            put(new Dish("Soup"), new ArrayList<>() {{
                add(new Friend("Alice"));
                add(new Friend("Marina"));
                add(new Friend("Bob"));
            }});
            put(new Dish("Salad"), new ArrayList<>() {{
                add(new Friend("Alice"));
                add(new Friend("Marina"));
            }});
            put(new Dish("Cake"), new ArrayList<>() {{
                add(new Friend("Alice"));
            }});
            put(new Dish("Cocktail"), new ArrayList<>() {{
                add(new Friend("Marina"));
            }});
        }};
        runCase(logger, order, expected);
    }

    private void oneEmpty(CaseLogger logger) {
        var order = new HashMap<Friend, List<Dish>>() {{
            put(new Friend("Bob"), new ArrayList<>() {{
                add(new Dish("Tea"));
                add(new Dish("Meat"));
            }});
            put(new Friend("Alice"), new ArrayList<>() {{
            }});
            put(new Friend("Marina"), new ArrayList<>() {{
                add(new Dish("Salad"));
                add(new Dish("Tea"));
            }});
        }};
        var expected = new HashMap<Dish, List<Friend>>() {{
            put(new Dish("Tea"), new ArrayList<>() {{
                add(new Friend("Bob"));
                add(new Friend("Marina"));
            }});
            put(new Dish("Meat"), new ArrayList<>() {{
                add(new Friend("Bob"));
            }});
            put(new Dish("Salad"), new ArrayList<>() {{
                add(new Friend("Marina"));
            }});
        }};
        runCase(logger, order, expected);
    }

    private void same(CaseLogger logger) {
        var order = new HashMap<Friend, List<Dish>>() {{
            put(new Friend("Bob"), new ArrayList<>() {{
                add(new Dish("Tea"));
                add(new Dish("Meat"));
            }});
            put(new Friend("Alice"), new ArrayList<>() {{
                add(new Dish("Tea"));
                add(new Dish("Meat"));
            }});
            put(new Friend("Marina"), new ArrayList<>() {{
                add(new Dish("Tea"));
                add(new Dish("Meat"));
            }});
        }};
        var expected = new HashMap<Dish, List<Friend>>() {{
            put(new Dish("Tea"), new ArrayList<>() {{
                add(new Friend("Bob"));
                add(new Friend("Alice"));
                add(new Friend("Marina"));
            }});
            put(new Dish("Meat"), new ArrayList<>() {{
                add(new Friend("Bob"));
                add(new Friend("Alice"));
                add(new Friend("Marina"));
            }});
        }};
        runCase(logger, order, expected);
    }

    private void different(CaseLogger logger) {
        var order = new HashMap<Friend, List<Dish>>() {{
            put(new Friend("Bob"), new ArrayList<>() {{
                add(new Dish("Tea"));
                add(new Dish("Meat"));
            }});
            put(new Friend("Alice"), new ArrayList<>() {{
                add(new Dish("Salad"));
                add(new Dish("Cake"));
            }});
            put(new Friend("Marina"), new ArrayList<>() {{
                add(new Dish("Cocktail"));
                add(new Dish("Soup"));
            }});
        }};
        var expected = new HashMap<Dish, List<Friend>>() {{
            put(new Dish("Tea"), new ArrayList<>() {{
                add(new Friend("Bob"));
            }});
            put(new Dish("Meat"), new ArrayList<>() {{
                add(new Friend("Bob"));
            }});
            put(new Dish("Salad"), new ArrayList<>() {{
                add(new Friend("Alice"));
            }});
            put(new Dish("Cake"), new ArrayList<>() {{
                add(new Friend("Alice"));
            }});
            put(new Dish("Cocktail"), new ArrayList<>() {{
                add(new Friend("Marina"));
            }});
            put(new Dish("Soup"), new ArrayList<>() {{
                add(new Friend("Marina"));
            }});
        }};
        runCase(logger, order, expected);
    }

    private void allEmpty(CaseLogger logger) {
        var order = new HashMap<Friend, List<Dish>>() {{
            put(new Friend("Bob"), new ArrayList<>() {{
            }});
            put(new Friend("Alice"), new ArrayList<>() {{
            }});
            put(new Friend("Marina"), new ArrayList<>() {{
            }});
        }};
        var expected = new HashMap<Dish, List<Friend>>();
        runCase(logger, order, expected);
    }

    private void runCase(CaseLogger logger, Map<Friend, List<Dish>> order, Map<Dish, List<Friend>> expected) {
        logger
            .setArguments(new HashMap<>() {{
                put("order", Helper.alignMap(order));
            }});

        var actual = new Task().makeOrder(order);

        logger
            .setExpected(Helper.alignMap(expected))
            .setActual(Helper.alignMap(actual))
            .setIsSuccess(isSuccess(actual, expected));
    }

    private boolean isSuccess(Map<Dish, List<Friend>> expected, Map<Dish, List<Friend>> actual) {
        if (actual.size() != expected.size()) {
            return false;
        }

        if (!actual.keySet().equals(expected.keySet())) {
            return false;
        }

        for (var key : actual.keySet()) {
            var actualList = actual.get(key);
            var expectedList = expected.get(key);

            if (!Helper.compareListsIgnoringOrder(expectedList,actualList)) {
                return false;
            }
        }

        return true;
    }
}