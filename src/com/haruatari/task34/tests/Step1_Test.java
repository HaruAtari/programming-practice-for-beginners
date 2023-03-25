package com.haruatari.task34.tests;

import com.haruatari._src.Helper;
import com.haruatari._src.loggers.CaseLogger;
import com.haruatari._src.tests.CasesBatchTest;
import com.haruatari.task34.Product;
import com.haruatari.task34.Task;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class Step1_Test extends CasesBatchTest {
    public static void main(String[] args) {
        new Step1_Test().run();
    }

    @Override
    protected String getCasesBatchName() {
        return "Step 1";
    }

    @Override
    protected CaseLogger.Type getCaseLoggerType() {
        return CaseLogger.Type.STEP;
    }

    @Override
    protected Map<String, Consumer<CaseLogger>> getCases() {
        return new HashMap<>() {{
            put("1", l -> testCase(l));
            put("2", l -> testCase(l));
            put("3", l -> testCase(l));
        }};
    }

    private void testCase(CaseLogger logger) {
        var expectedPrice = Helper.randomInt(10, 100);
        var expectedName = "Product №" + Helper.randomInt(10, 100);

        logger.addFlowStep("Product customProduct = new Task.createProduct(\"" + expectedName + "\", " + expectedPrice + ", 5);");
        var customProduct = new Task().createProduct(expectedName, expectedPrice, 5);

        if (customProduct.getClass().getSimpleName().equals(Product.class.getSimpleName())) {
            logger
                .hint("The Task.createProduct() method should return an instance of your class but not the Product")
                .setIsSuccess(false);

            return;
        }

        logger.addFlowStep("String name = customProduct.getName();");
        var name = customProduct.getName();

        logger.addFlowStep("int price = customProduct.getPrice();");
        var price = customProduct.getPrice();

        logger
            .setExpected(new HashMap<>() {{
                put("name", expectedName);
                put("price", String.valueOf(expectedPrice));
            }})
            .setActual(new HashMap<>() {{
                put("name", name);
                put("price", String.valueOf(price));
            }})
            .setIsSuccess(expectedName.equals(name) && expectedPrice == price);
    }
}
