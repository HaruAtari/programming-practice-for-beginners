package com.haruatari.task31.tests;

import com.haruatari._src.loggers.CaseLogger;
import com.haruatari._src.tests.CasesBatchTest;
import com.haruatari.task31.Calculator;
import com.haruatari.task31.Point;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class CalculateDistance_Method extends CasesBatchTest {
    private static final double PRECIOUS = 0.0001;

    public static void main(String[] args) {
        new CalculateDistance_Method().run();
    }

    @Override
    protected String getCasesBatchName() {
        return "double calculateDistance(Point point1, Point point2)";
    }

    @Override
    protected Map<String, Consumer<CaseLogger>> getCases() {
        return new HashMap<>() {{
            put("Vertical segment", l -> runCase(l, new Point(10, 10), new Point(10, 20), 10.0));
            put("Horizontal segment", l -> runCase(l, new Point(0, 0), new Point(20, 0), 20.0));
            put("Diagonal segment", l -> runCase(l, new Point(20, 20), new Point(30, 30), 14.14214));
            put("Negative coordinates", l -> runCase(l, new Point(-10, 15), new Point(10, -15), 36.0555));
            put("Points with the same coordinates (zero distance)", l -> runCase(l, new Point(10, 10), new Point(10, 10), 0));
        }};
    }

    private void runCase(CaseLogger logger, Point point1, Point point2, double expected) {
        DecimalFormat formatter = new DecimalFormat("#.####");

        var actual = new Calculator().calculateDistance(point1, point2);
        var isSuccess = Math.abs(Math.abs(expected) - Math.abs(actual)) < PRECIOUS;

        logger
            .setArguments(new HashMap<>() {{
                put("point1", String.valueOf(point1));
                put("point2", String.valueOf(point2));
            }})
            .setExpected(formatter.format(expected))
            .setActual(formatter.format(actual))
            .setIsSuccess(isSuccess);
    }
}
