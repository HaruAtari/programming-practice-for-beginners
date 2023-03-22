package com.haruatari.task10.tests;

import com.haruatari._src.loggers.CaseLogger;
import com.haruatari._src.tests.CasesBatchTest;
import com.haruatari.task10.Point;
import com.haruatari.task10.Task;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.Consumer;

final class Move_Test extends CasesBatchTest {
    public static void main(String[] args) {
        new Move_Test().run();
    }

    @Override
    protected String getCasesBatchName() {
        return "Point move(Point point, String[] commands)";
    }

    @Override
    protected Map<String, Consumer<CaseLogger>> getCases() {
        return new HashMap<>() {{
            put("The point changes its position", l -> runCase(l, new Point(3, 3), new String[]{"up", "down", "right", "up", "up", "left", "left"}, new Point(2, 5)));
            put("The point returns to the init position", l -> runCase(l, new Point(1, 1), new String[]{"right", "right", "down", "down", "left", "left", "up", "up"}, new Point(1, 1)));
            put("The point moves only once", l -> runCase(l, new Point(0, 0), new String[]{"up"}, new Point(0, 1)));
            put("The point doesn't move", l -> runCase(l, new Point(0, 0), new String[]{}, new Point(0, 0)));
        }};
    }

    private void runCase(CaseLogger logger, Point point, String[] commands, Point expected) {
        var actual = new Task().move(point, commands);
        logger
            .setArguments(new HashMap<>() {{
                put("point", String.valueOf(point));
                put("commands", Arrays.toString(commands));
            }})
            .setExpected(String.valueOf(expected))
            .setActual(String.valueOf(actual))
            .setIsSuccess(Objects.equals(actual, expected));
    }
}
