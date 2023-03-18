package com.haruatari.task9.tests;

import com.haruatari._src.loggers.CaseLogger;
import com.haruatari._src.tests.MethodTest;
import com.haruatari.task9.Point;
import com.haruatari.task9.Segment;
import com.haruatari.task9.Task;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.Consumer;

final class Move_Test extends MethodTest {
    public static void main(String[] args) {
        new Move_Test().run();
    }

    @Override
    protected String getMethodName() {
        return "Point findMiddlePoint(Segment segment)";
    }

    @Override
    protected Map<String, Consumer<CaseLogger>> getCases() {
        return new HashMap<>() {{
            put("A vertical segment", l -> runCase(l, new Segment(new Point(10, 20), new Point(10, 10)), new Point(10, 15)));
            put("A horizontal segment", l -> runCase(l, new Segment(new Point(10, 10), new Point(20, 10)), new Point(15, 10)));
            put("A vertical segment with the negative X", l -> runCase(l, new Segment(new Point(-10, -20), new Point(-10, -10)), new Point(-10, -15)));
            put("A horizontal segment with the negative Y", l -> runCase(l, new Segment(new Point(-10, -10), new Point(-20, -10)), new Point(-15, -10)));
            put("A diagonal segment", l -> runCase(l, new Segment(new Point(-10, 10), new Point(10, -10)), new Point(0, 0)));
            put("A segment with the zero length", l -> runCase(l, new Segment(new Point(0, 0), new Point(0, 0)), new Point(0, 0)));
        }};
    }

    private void runCase(CaseLogger logger, Segment segment, com.haruatari.task9.Point expected) {
        var actual = new Task().findMiddlePoint(segment);
        logger
            .setArguments(new HashMap<>() {{
                put("segment", String.valueOf(segment));
            }})
            .setExpected(String.valueOf(expected))
            .setActual(String.valueOf(actual))
            .setIsSuccess(Objects.equals(actual, expected));
    }
}
