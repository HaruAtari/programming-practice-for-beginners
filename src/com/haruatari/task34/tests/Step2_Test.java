package com.haruatari.task34.tests;

import com.haruatari._src.Helper;
import com.haruatari._src.loggers.CaseLogger;
import com.haruatari._src.tests.CasesBatchTest;
import com.haruatari.task34.Product;
import com.haruatari.task34.Task;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class Step2_Test extends CasesBatchTest {
    public static void main(String[] args) {
        new Step2_Test().run();
    }

    @Override
    protected String getCasesBatchName() {
        return "Step 2";
    }

    @Override
    protected CaseLogger.Type getCaseLoggerType() {
        return CaseLogger.Type.STEP;
    }


    @Override
    protected Map<String, Consumer<CaseLogger>> getCases() {
        return new HashMap<>() {{
            put("1", l -> testCase(l, Helper.randomInt(1, 9)));
            put("2", l -> testCase(l, Helper.randomInt(1, 9)));
            put("3", l -> testCase(l, 0));
        }};
    }

    private void testCase(CaseLogger logger, int discount) {
        var price = Helper.randomInt(10, 100);

        logger.addFlowStep("Product customProduct = new Task.createProduct(\"Test product\", " + price + ", " + discount + ");");
        var customProduct = new Task().createProduct("Test product", price, discount);

        if (customProduct.getClass().getSimpleName().equals(Product.class.getSimpleName())) {
            logger
                .hint("The Task.createProduct() method should return an instance of your class but not the Product")
                .setIsSuccess(false);

            return;
        }

        logger.addFlowStep("int totalPrice = customProduct.getTotalPrice();");
        var totalPrice = customProduct.getTotalPrice();

        var expectedTotalPrice = price - discount;

        logger
            .setExpected(String.valueOf(expectedTotalPrice))
            .setActual(String.valueOf(totalPrice))
            .setIsSuccess(expectedTotalPrice == totalPrice);
    }
}
