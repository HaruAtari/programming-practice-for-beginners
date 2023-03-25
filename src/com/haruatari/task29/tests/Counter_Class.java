package com.haruatari.task29.tests;

import com.haruatari._src.loggers.CaseLogger;
import com.haruatari._src.tests.CasesBatchTest;
import com.haruatari.task29.Counter;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

final class Counter_Class extends CasesBatchTest {
    public static void main(String[] args) {
        new Counter_Class().run();
    }

    @Override
    protected String getCasesBatchName() {
        return "Counter";
    }

    @Override
    protected CaseLogger.Type getCaseLoggerType() {
        return CaseLogger.Type.CLASS;
    }

    @Override
    protected Map<String, Consumer<CaseLogger>> getCases() {
        return new HashMap<>() {{
            put("Common flow", l -> common(l));
            put("With resetting", l -> reset(l));
            put("Without any changes", l -> empty(l));
            put("Several parallel counters", l -> several(l));
            put("Several calling of getValue()", l -> severalGetValue(l));
        }};
    }

    private void severalGetValue(CaseLogger logger) {
        logger.addFlowStep("Counter counter = new Counter();");
        var counter = new Counter();

        logger.addFlowStep("counter.add(5);");
        counter.add(5);

        logger.addFlowStep("counter.add(7);");
        counter.add(7);

        logger.addFlowStep("counter.subtract(2);");
        counter.subtract(2);

        logger.addFlowStep("int value1 = counter.getValue();");
        var actual1 = counter.getValue();

        logger.addFlowStep("counter.add(4);");
        counter.add(4);

        logger.addFlowStep("counter.subtract(1);");
        counter.subtract(1);

        logger.addFlowStep("counter.subtract(1);");
        counter.subtract(1);

        logger.addFlowStep("int value2 = counter.getValue();");
        var actual2 = counter.getValue();

        var expected1 = 10;
        var expected2 = 12;

        logger
            .setExpected(new HashMap<>(){{
                put("value1",String.valueOf(expected1));
                put("value2",String.valueOf(expected2));
            }})
            .setActual(new HashMap<>(){{
                put("value1",String.valueOf(actual1));
                put("value2",String.valueOf(actual2));
            }})
            .setIsSuccess(actual1 == expected1 && actual2 == expected2);

        if (actual2 == expected2 - expected1) {
            logger.hint("The getValue() calling should not reser the current value");
        }
    }

    private void common(CaseLogger logger) {
        logger.addFlowStep("Counter counter = new Counter();");
        var counter = new Counter();

        logger.addFlowStep("counter.add(5);");
        counter.add(5);

        logger.addFlowStep("counter.add(7);");
        counter.add(7);

        logger.addFlowStep("counter.subtract(2);");
        counter.subtract(2);

        logger.addFlowStep("counter.add(4);");
        counter.add(4);

        logger.addFlowStep("counter.subtract(1);");
        counter.subtract(1);

        logger.addFlowStep("counter.subtract(1);");
        counter.subtract(1);

        logger.addFlowStep("int value = counter.getValue();");
        var actual = counter.getValue();
        var expected = 12;

        logger
            .setExpected(String.valueOf(expected))
            .setActual(String.valueOf(actual))
            .setIsSuccess(expected == actual);
    }

    private void reset(CaseLogger logger) {
        logger.addFlowStep("Counter counter = new Counter();");
        var counter = new Counter();

        logger.addFlowStep("counter.add(5);");
        counter.add(5);

        logger.addFlowStep("counter.add(7);");
        counter.add(7);

        logger.addFlowStep("counter.subtract(2);");
        counter.subtract(2);

        logger.addFlowStep("counter.reset();");
        counter.reset();

        logger.addFlowStep("counter.add(5);");
        counter.add(5);

        logger.addFlowStep("counter.subtract(2);");
        counter.subtract(2);

        logger.addFlowStep("int value = counter.getValue();");
        var actual = counter.getValue();
        var expected = 3;

        logger
            .setExpected(String.valueOf(expected))
            .setActual(String.valueOf(actual))
            .setIsSuccess(expected == actual);
    }

    private void empty(CaseLogger logger) {
        logger.addFlowStep("Counter counter = new Counter();");
        var counter = new Counter();

        logger.addFlowStep("int value = counter.getValue();");
        var actual = counter.getValue();
        var expected = 0;

        logger
            .setExpected(String.valueOf(expected))
            .setActual(String.valueOf(actual))
            .setIsSuccess(expected == actual);
    }

    private void several(CaseLogger logger) {
        logger.addFlowStep("Counter counter1 = new Counter();");
        var counter1 = new Counter();

        logger.addFlowStep("Counter counter2 = new Counter();");
        var counter2 = new Counter();

        logger.addFlowStep("Counter counter3 = new Counter();");
        var counter3 = new Counter();

        logger.addFlowStep("counter1.add(3);");
        counter1.add(3);

        logger.addFlowStep("counter2.add(3);");
        counter2.add(3);

        logger.addFlowStep("counter3.add(3);");
        counter3.add(3);

        logger.addFlowStep("counter1.add(5);");
        counter1.add(5);

        logger.addFlowStep("counter2.subtract(7);");
        counter2.subtract(7);

        logger.addFlowStep("counter3.reset();");
        counter3.reset();

        logger.addFlowStep("int value1 = counter1.getValue();");
        var actual1 = counter1.getValue();
        var expected1 = 8;

        logger.addFlowStep("int value2 = counter2.getValue();");
        var actual2 = counter2.getValue();
        var expected2 = -4;

        logger.addFlowStep("int value3 = counter3.getValue();");
        var actual3 = counter3.getValue();
        var expected3 = 0;

        logger
            .setExpected(new HashMap<>(){{
                put("value1",String.valueOf(expected1));
                put("value2",String.valueOf(expected2));
                put("value3",String.valueOf(expected3));
            }})
            .setActual(new HashMap<>(){{
                put("value1",String.valueOf(actual1));
                put("value2",String.valueOf(actual2));
                put("value3",String.valueOf(actual3));
            }})
            .setIsSuccess(actual1 == expected1 && actual2 == expected2 && actual3 == expected3);
    }
}
