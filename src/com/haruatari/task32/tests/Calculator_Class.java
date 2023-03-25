package com.haruatari.task32.tests;

import com.haruatari._src.loggers.CaseLogger;
import com.haruatari._src.tests.CasesBatchTest;
import com.haruatari.task32.Calculator;
import com.haruatari.task32.Point;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

final class Calculator_Class extends CasesBatchTest {
    private static final double PRECIOUS = 0.0001;

    public static void main(String[] args) {
        new Calculator_Class().run();
    }

    @Override
    protected String getCasesBatchName() {
        return "Calculator";
    }

    @Override
    protected CaseLogger.Type getCaseLoggerType() {
        return CaseLogger.Type.CLASS;
    }

    @Override
    protected Map<String, Consumer<CaseLogger>> getCases() {
        return new HashMap<>() {{
            put("A line with the single segment", l -> one(l));
            put("A line with the three segments", l -> three(l));
            put("A line with the four segments", l -> four(l));
            put("A line with the only one point", l -> onePoint(l));
            put("A line with no points specified at all", l -> noPoint(l));
            put("Two parallel calculators", l -> parallel(l));
        }};
    }

    private void parallel(CaseLogger logger) {
        logger.addFlowStep("Calculator calculator1 = new Calculator();");
        var calculator1 = new Calculator();

        logger.addFlowStep("Calculator calculator2 = new Calculator();");
        var calculator2 = new Calculator();

        logger.addFlowStep("calculator1.addPoint(new Point(10,10));");
        calculator1.addPoint(new Point(10, 10));

        logger.addFlowStep("calculator1.addPoint(new Point(10,20));");
        calculator1.addPoint(new Point(10, 20));

        logger.addFlowStep("calculator2.addPoint(new Point(10,10));");
        calculator2.addPoint(new Point(10, 10));

        logger.addFlowStep("calculator2.addPoint(new Point(20,20));");
        calculator2.addPoint(new Point(20, 20));

        logger.addFlowStep("double length1 = calculator1.calculateLength();");
        var actual1 = calculator1.calculateLength();

        logger.addFlowStep("double length2 = calculator1.calculateLength();");
        var actual2 = calculator2.calculateLength();

        var expected1 = 10.0;
        var expected2 = 14.14214;

        DecimalFormat formatter = new DecimalFormat("#.###");

        var isSuccess = Math.abs(Math.abs(expected1) - Math.abs(actual1)) < PRECIOUS &&
            Math.abs(Math.abs(expected2) - Math.abs(actual2)) < PRECIOUS;

        logger
            .setExpected(new HashMap<>(){{
                put("length1",String.valueOf(expected1));
                put("length2",String.valueOf(expected2));
            }})
            .setActual(new HashMap<>(){{
                put("length1",String.valueOf(actual1));
                put("length2",String.valueOf(actual2));
            }})
            .setIsSuccess(isSuccess);
    }

    private void one(CaseLogger logger) {
        logger.addFlowStep("Calculator calculator = new Calculator();");
        var calculator = new Calculator();

        logger.addFlowStep("calculator.addPoint(new Point(10,10));");
        calculator.addPoint(new Point(10, 10));

        logger.addFlowStep("calculator.addPoint(new Point(10,20));");
        calculator.addPoint(new Point(10, 20));

        logger.addFlowStep("double length = calculator.calculateLength();");
        var actual = calculator.calculateLength();

        logResult(logger, actual, 10.0);
    }

    private void three(CaseLogger logger) {
        logger.addFlowStep("Calculator calculator = new Calculator();");
        var calculator = new Calculator();

        logger.addFlowStep("calculator.addPoint(new Point(10,10));");
        calculator.addPoint(new Point(10, 10));

        logger.addFlowStep("calculator.addPoint(new Point(10,20));");
        calculator.addPoint(new Point(10, 20));

        logger.addFlowStep("calculator.addPoint(new Point(20,20));");
        calculator.addPoint(new Point(20, 20));

        logger.addFlowStep("calculator.addPoint(new Point(20,30));");
        calculator.addPoint(new Point(20, 30));

        logger.addFlowStep("double length = calculator.calculateLength();");
        var actual = calculator.calculateLength();

        logResult(logger, actual, 30.0);
    }

    private void four(CaseLogger logger) {
        logger.addFlowStep("Calculator calculator = new Calculator();");
        var calculator = new Calculator();

        logger.addFlowStep("calculator.addPoint(new Point(10,10));");
        calculator.addPoint(new Point(10, 10));

        logger.addFlowStep("calculator.addPoint(new Point(20,20));");
        calculator.addPoint(new Point(20, 20));

        logger.addFlowStep("calculator.addPoint(new Point(10,30));");
        calculator.addPoint(new Point(10, 30));

        logger.addFlowStep("calculator.addPoint(new Point(20,40));");
        calculator.addPoint(new Point(20, 40));

        logger.addFlowStep("calculator.addPoint(new Point(10,50));");
        calculator.addPoint(new Point(10, 50));

        logger.addFlowStep("double length = calculator.calculateLength();");
        var actual = calculator.calculateLength();

        logResult(logger, actual, 56.56856);
    }

    private void onePoint(CaseLogger logger) {
        logger.addFlowStep("Calculator calculator = new Calculator();");
        var calculator = new Calculator();

        logger.addFlowStep("calculator.addPoint(new Point(10,10));");
        calculator.addPoint(new Point(10, 10));

        logger.addFlowStep("double length = calculator.calculateLength();");
        var actual = calculator.calculateLength();

        logResult(logger, actual, 0.0);
    }

    private void noPoint(CaseLogger logger) {
        logger.addFlowStep("Calculator calculator = new Calculator();");
        var calculator = new Calculator();

        logger.addFlowStep("double length = calculator.calculateLength();");
        var actual = calculator.calculateLength();

        logResult(logger, actual, 0.0);
    }

    private void logResult(CaseLogger logger, double actual, double expected) {
        DecimalFormat formatter = new DecimalFormat("#.###");

        var isSuccess = Math.abs(Math.abs(expected) - Math.abs(actual)) < PRECIOUS;

        logger
            .setExpected(formatter.format(expected))
            .setActual(formatter.format(actual))
            .setIsSuccess(isSuccess);
    }
}
