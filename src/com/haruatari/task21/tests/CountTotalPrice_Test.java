package com.haruatari.task21.tests;

import com.haruatari._src.Helper;
import com.haruatari._src.loggers.CaseLogger;
import com.haruatari._src.tests.MethodTest;
import com.haruatari.task21.Dish;
import com.haruatari.task21.Task;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class CountTotalPrice_Test extends MethodTest {
    public static void main(String[] args) {
        new CountTotalPrice_Test().run();
    }

    @Override
    protected String getMethodName() {
        return "int countTotalPrice(Map<Dish, Integer> order)";
    }

    @Override
    protected Map<String, Consumer<CaseLogger>> getCases() {
        var instance = this;
        return new HashMap<>() {{
            put("A normal order", instance::normal);
            put("An order with a free dish", instance::free);
            put("An order with no-ordered dish", instance::noOrdered);
            put("An empty order", instance::empty);
            put("An order with a single ordered dish", instance::single);
        }};
    }

    private void normal(CaseLogger logger) {
        var order = new HashMap<Dish, Integer>() {{
            put(new Dish("Cake", 500), 1);
            put(new Dish("Mushroom soup", 250), 2);
            put(new Dish("French fries", 100), 6);
            put(new Dish("Tea", 200), 2);
        }};
        runCase(logger, order, 2000);
    }

    private void free(CaseLogger logger) {
        var order = new HashMap<Dish, Integer>() {{
            put(new Dish("Cake", 500), 1);
            put(new Dish("Mushroom soup", 250), 2);
            put(new Dish("French fries", 100), 6);
            put(new Dish("Tea", 0), 2);
        }};
        runCase(logger, order, 1600);
    }

    private void noOrdered(CaseLogger logger) {
        var order = new HashMap<Dish, Integer>() {{
            put(new Dish("Cake", 500), 0);
            put(new Dish("Mushroom soup", 250), 2);
            put(new Dish("French fries", 100), 6);
            put(new Dish("Meat", 1250), 2);
            put(new Dish("Tea", 200), 0);
        }};
        runCase(logger, order, 3600);
    }

    private void single(CaseLogger logger) {
        var order = new HashMap<Dish, Integer>() {{
            put(new Dish("Tea", 200), 1);
        }};
        runCase(logger, order, 200);
    }

    private void empty(CaseLogger logger) {
        runCase(logger, new HashMap<>(), 0);
    }

    private void runCase(CaseLogger logger, Map<Dish, Integer> order, int expected) {
        logger
                .setArguments(new HashMap<>() {{
                    put("order", Helper.alignMap(order));
                }});

        var actual = new Task().countTotalPrice(order);

        logger
                .setExpected(String.valueOf(expected))
                .setActual(String.valueOf(actual))
                .setIsSuccess(expected == actual);
    }
}
