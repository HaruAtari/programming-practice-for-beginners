package com.haruatari.task35.tests;

import com.haruatari._src.Helper;
import com.haruatari._src.loggers.CaseLogger;
import com.haruatari._src.tests.CasesBatchTest;
import com.haruatari.task35.Device;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class GetFullInfo_Method extends CasesBatchTest {
    public static void main(String[] args) {
        new GetFullInfo_Method().run();
    }

    @Override
    protected String getCasesBatchName() {
        return "String Device.getFullInfo()";
    }

    @Override
    protected CaseLogger.Type getCaseLoggerType() {
        return CaseLogger.Type.METHOD;
    }

    @Override
    protected Map<String, Consumer<CaseLogger>> getCases() {
        return new HashMap<>() {{
            put("1", l -> phone(l));
            put("2", l -> laptop(l));
        }};
    }

    private void phone(CaseLogger logger) {
        var battery = Helper.randomInt(10, 100);
        var name = "Mobile phone";
        logger.setCaseDescription(new StringBuilder()
            .append("\nclass MobilePhone extends Device {\n")
            .append("    protected int getBatteryPercentage() { return " + battery + "; }\n")
            .append("    protected String getName() { return \"Mobile phone\"; }\n")
            .append("}")

            .toString());

        logger.addFlowStep("var phone = new MobilePhone()");
        var phone = new TestDevice(battery, name);

        logger.addFlowStep("var result = phone.getFullInfo()");
        var actual = phone.getFullInfo();

        var expected = "Device " + name + " has " + battery + "% battery";

        logger
            .setExpected(expected)
            .setActual(actual)
            .setIsSuccess(expected.equals(actual));
    }

    private void laptop(CaseLogger logger) {
        var battery = Helper.randomInt(10, 100);
        var name = "Laptop";
        logger.setCaseDescription(new StringBuilder()
            .append("\nclass Laptop extends Device {\n")
            .append("    protected int getBatteryPercentage() { return " + battery + "; }\n")
            .append("    protected String getName() { return \"Laptop\"; }\n")
            .append("}")

            .toString());

        logger.addFlowStep("var laptop = new Laptop()");
        var phone = new TestDevice(battery, name);

        logger.addFlowStep("var result = laptop.getFullInfo()");
        var actual = phone.getFullInfo();

        var expected = "Device " + name + " has " + battery + "% battery";

        logger
            .setExpected(expected)
            .setActual(actual)
            .setIsSuccess(expected.equals(actual));
    }

    private static class TestDevice extends Device {
        private int battery;
        private String name;

        public TestDevice(int battery, String name) {
            this.battery = battery;
            this.name = name;
        }

        @Override
        protected int getBatteryPercentage() {
            return battery;
        }

        @Override
        protected String getName() {
            return name;
        }
    }
}