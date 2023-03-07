package com.haruatari.task14;

import com.haruatari.BaseTest;
import com.haruatari.TaskNumber;

import java.util.HashMap;

final public class Test extends BaseTest {
    public static void main(String[] args) {
        new Test().run();
    }

    @Override
    public TaskNumber getNumber() {
        return TaskNumber.TASK_14;
    }

    @Override
    public void run() {
        testCase(new Cart(new Product[]{
                new Product("cheese", 10, 2),
                new Product("bread", 5, 1),
                new Product("tea", 15, 1)
        }), 40);
        testCase(new Cart(new Product[]{
                new Product("meat", 250, 3),
                new Product("spices", 15, 4),
                new Product("beans", 50, 1)
        }), 860);
        testCase(new Cart(new Product[]{
                new Product("candies", 50, 5),
        }), 250);
        testCase(new Cart(new Product[]{}), 0);

        logTotalResult();
    }

    private void testCase(Cart cart, int expected) {
        logMethodName("int calculatePayment(Cart cart)");
        logMethodArguments(new HashMap<>() {{
            put("cart", String.valueOf(cart));
        }});

        var actual = new Task().calculatePayment(cart);
        var isSuccess = actual == expected;

        logMethodResults(String.valueOf(expected), String.valueOf(actual), isSuccess);
        increaseCasesCounter(isSuccess);
    }
}
