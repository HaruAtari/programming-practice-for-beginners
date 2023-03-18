package com.haruatari.task15.tests;

import com.haruatari._src.Helper;
import com.haruatari._src.loggers.CaseLogger;
import com.haruatari._src.tests.MethodTest;
import com.haruatari.task15.Discount;
import com.haruatari.task15.Product;
import com.haruatari.task15.Task;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

final class CalculatePayment_Test extends MethodTest {
    public static void main(String[] args) {
        new CalculatePayment_Test().run();
    }

    @Override
    protected String getMethodName() {
        return "int calculatePayment(Product[] products, Discount[] discounts)";
    }

    @Override
    protected Map<String, Consumer<CaseLogger>> getCases() {
        var instance = this;

        return new HashMap<>() {{
            put("All products have discounts", instance::all);
            put("There are products without discount and discounts without products", instance::abandoned);
            put("Single product without discount", instance::oneProduct);
            put("Single discount without products", instance::oneDiscount);
            put("No products, no discounts", instance::nothing);
        }};
    }

    private void all(CaseLogger logger) {
        var products = new Product[]{
            new Product("cheese", 100, 2),
            new Product("bread", 50, 1),
            new Product("tea", 150, 1)
        };
        var discounts = new Discount[]{
            new Discount("cheese", 20),
            new Discount("bread", 0),
            new Discount("tea", 50),
        };
        runCase(logger, products, discounts, 310);
    }

    private void abandoned(CaseLogger logger) {
        var products = new Product[]{
            new Product("meat", 250, 2),
            new Product("spices", 15, 4),
            new Product("beans", 50, 1)
        };
        var discounts = new Discount[]{
            new Discount("spices", 15),
            new Discount("dog's food", 100)
        };
        runCase(logger, products, discounts, 550);
    }

    private void oneProduct(CaseLogger logger) {
        var products = new Product[]{new Product("candies", 50, 5)};
        var discounts = new Discount[]{};
        runCase(logger, products, discounts, 250);
    }

    private void oneDiscount(CaseLogger logger) {
        var products = new Product[]{};
        var discounts = new Discount[]{new Discount("dog's food", 100)};
        runCase(logger, products, discounts, 0);
    }

    private void nothing(CaseLogger logger) {
        var products = new Product[]{};
        var discounts = new Discount[]{};
        runCase(logger, products, discounts, 0);
    }

    private void runCase(CaseLogger logger, Product[] products, Discount[] discounts, int expected) {
        var actual = new Task().calculatePayment(products, discounts);
        logger
            .setArguments(new HashMap<>() {{
                put("products", Helper.alignArray(products));
                put("discounts", Helper.alignArray(discounts));
            }})
            .setExpected(String.valueOf(expected))
            .setActual(String.valueOf(actual))
            .setIsSuccess(expected == actual);
    }
}
