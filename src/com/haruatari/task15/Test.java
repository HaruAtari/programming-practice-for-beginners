package com.haruatari.task15;

import com.haruatari.BaseTest;
import com.haruatari.TaskNumber;
import com.haruatari._src.Helper;

import java.util.HashMap;

final public class Test extends BaseTest {
    public static void main(String[] args) {
        new Test().run();
    }

    @Override
    public TaskNumber getNumber() {
        return TaskNumber.TASK_15;
    }

    @Override
    public void run() {
        testCase(
                new Product[]{
                        new Product("cheese", 100, 2),
                        new Product("bread", 50, 1),
                        new Product("tea", 150, 1)
                },
                new Discount[]{
                        new Discount("cheese", 20),
                        new Discount("bread", 0),
                        new Discount("tea", 50),
                },
                310
        );
        testCase(
                new Product[]{
                        new Product("meat", 250, 2),
                        new Product("spices", 15, 4),
                        new Product("beans", 50, 1)
                },
                new Discount[]{
                        new Discount("spices", 15),
                        new Discount("dog's food", 100)
                },
                550
        );
        testCase(
                new Product[]{new Product("candies", 50, 5)},
                new Discount[]{},
                250
        );
        testCase(
                new Product[]{},
                new Discount[]{
                        new Discount("dog's food", 100)
                },
                0
        );

        showTotalResult();
    }

    private void testCase(Product[] products, Discount[] discounts, int expected) {
        var actual = new Task().calculatePayment(products, discounts);
        var isSuccess = actual == expected;

        logCase(
                "int calculatePayment(Product[] products, Discount[] discounts)",
                new HashMap<>() {{
                    put("products", Helper.alignArray(products));
                    put("discounts", Helper.alignArray(discounts));
                }},
                String.valueOf(expected),
                String.valueOf(actual),
                isSuccess
        );
    }
}
