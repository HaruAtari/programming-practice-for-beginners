package com.haruatari.task35.tests;

import com.haruatari._src.Helper;
import com.haruatari._src.loggers.CaseLogger;
import com.haruatari._src.tests.CasesBatchTest;
import com.haruatari.task35.Device;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class NeedCharging_Method extends CasesBatchTest {
    public static void main(String[] args) {
        new NeedCharging_Method().run();
    }

    @Override
    protected String getCasesBatchName() {
        return "boolean Device.needCharging()";
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
        var battery = Helper.randomInt(1, 19);
        var name = "Mobile phone";
        logger.setCaseDescription(new StringBuilder()
            .append("\nclass MobilePhone extends Device {\n")
            .append("    protected int getBatteryPercentage() { return " + battery + "; }\n")
            .append("    protected String getName() { return \"Mobile phone\"; }\n")
            .append("}")

            .toString());

        logger.addFlowStep("var phone = new MobilePhone()");
        var phone = new TestDevice(battery, name);

        logger.addFlowStep("var result = phone.needCharging()");
        var actual = phone.needCharging();

        var expected = true;

        logger
            .setExpected(String.valueOf(expected))
            .setActual(String.valueOf(actual))
            .setIsSuccess(expected == actual);
    }

    private void laptop(CaseLogger logger) {
        var battery = Helper.randomInt(22, 100);
        var name = "Laptop";
        logger.setCaseDescription(new StringBuilder()
            .append("\nclass Laptop extends Device {\n")
            .append("    protected int getBatteryPercentage() { return " + battery + "; }\n")
            .append("    protected String getName() { return \"Laptop\"; }\n")
            .append("}")

            .toString());

        logger.addFlowStep("var laptop = new Laptop()");
        var phone = new TestDevice(battery, name);

        logger.addFlowStep("var result = laptop.needCharging()");
        var actual = phone.needCharging();

        var expected = false;

        logger
            .setExpected(String.valueOf(expected))
            .setActual(String.valueOf(actual))
            .setIsSuccess(expected == actual);
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