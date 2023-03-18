package com.haruatari.task14.tests;

import com.haruatari._src.loggers.CaseLogger;
import com.haruatari._src.tests.MethodTest;
import com.haruatari.task14.Cart;
import com.haruatari.task14.Product;
import com.haruatari.task14.Task;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

final class CalculatePayment_Test extends MethodTest {
    public static void main(String[] args) {
        new CalculatePayment_Test().run();
    }

    @Override
    protected String getMethodName() {
        return "int calculatePayment(Cart cart)";
    }

    @Override
    protected Map<String, Consumer<CaseLogger>> getCases() {
        var instance = this;

        return new HashMap<>() {{
            put("A normal cart", instance::all);
            put("Another normal cart", instance::another);
            put("A cart with teh single product", instance::single);
            put("An empty cart", instance::empty);
        }};
    }

    private void all(CaseLogger logger) {
        runCase(logger, new Cart(new Product[]{
            new Product("cheese", 10, 2),
            new Product("bread", 5, 1),
            new Product("tea", 15, 1)
        }), 40);
    }

    private void another(CaseLogger logger) {
        runCase(logger, new Cart(new Product[]{
            new Product("meat", 250, 3),
            new Product("spices", 15, 4),
            new Product("beans", 50, 1)
        }), 860);
    }

    private void single(CaseLogger logger) {
        runCase(logger, new Cart(new Product[]{
            new Product("candies", 50, 5),
        }), 250);
    }

    private void empty(CaseLogger logger) {
        runCase(logger, new Cart(new Product[]{}), 0);
    }

    private void runCase(CaseLogger logger, Cart cart, int expected) {
        var actual = new Task().calculatePayment(cart);
        logger
            .setArguments(new HashMap<>() {{
                put("cart", String.valueOf(cart));
            }})
            .setExpected(String.valueOf(expected))
            .setActual(String.valueOf(actual))
            .setIsSuccess(expected == actual);
    }
}
