package com.haruatari.task10;

import com.haruatari.BaseTest;
import com.haruatari.TaskNumber;

import java.util.Arrays;
import java.util.HashMap;

final public class Test extends BaseTest {
    public static void main(String[] args) {
        new Test().run();
    }

    @Override
    public TaskNumber getNumber() {
        return TaskNumber.TASK_10;
    }

    @Override
    public void run() {
        testMoveCase(new Point(3, 3), new String[]{"up", "down", "right", "up", "up", "left", "left"}, new Point(2, 5));
        testMoveCase(new Point(1, 1), new String[]{"right", "right", "down", "down", "left", "left", "up", "up"}, new Point(1, 1));
        testMoveCase(new Point(0, 0), new String[]{"up"}, new Point(0, 1));
        testMoveCase(new Point(0, 0), new String[]{}, new Point(0, 0));
        logTotalResult();
    }

    private void testMoveCase(Point point, String[] commands, Point expected) {
        logMethodName("Point move(Point point, String[] commands)");
        logMethodArguments(new HashMap<>() {{
            put("point", String.valueOf(point));
            put("commands", Arrays.toString(commands));
        }});

        var actual = new Task().move(point, commands);
        var isSuccess = expected.equals(actual);

        logMethodResults(String.valueOf(expected), String.valueOf(actual), isSuccess);
        increaseCasesCounter(isSuccess);
    }
}
