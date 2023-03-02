package com.haruatari.task9;

import com.haruatari.BaseTest;
import com.haruatari.TaskNumber;

import java.util.HashMap;

final public class Test extends BaseTest {
    public static void main(String[] args) {
        new Test().run();
    }

    @Override
    public TaskNumber getNumber() {
        return TaskNumber.TASK_9;
    }

    @Override
    public void run() {
        testFindMiddlePointCase(new Segment(new Point(10, 20), new Point(10, 10)), new Point(10, 15));
        testFindMiddlePointCase(new Segment(new Point(10, 10), new Point(20, 10)), new Point(15, 10));
        testFindMiddlePointCase(new Segment(new Point(-10, -20), new Point(-10, -10)), new Point(-10, -15));
        testFindMiddlePointCase(new Segment(new Point(-10, -10), new Point(-20, -10)), new Point(-15, -10));
        testFindMiddlePointCase(new Segment(new Point(-10, 10), new Point(10, -10)), new Point(0, 0));
        testFindMiddlePointCase(new Segment(new Point(0, 0), new Point(0, 0)), new Point(0, 0));

        logTotalResult();
    }

    private void testFindMiddlePointCase(Segment segment, Point expected) {
        logMethodName("Point findMiddlePoint(Segment segment)");
        logMethodArguments(new HashMap<>() {{
            put("segment", String.valueOf(segment));
        }});

        var actual = new Task().findMiddlePoint(segment);
        var isSuccess = expected.equals(actual);

        logMethodResults(String.valueOf(expected), String.valueOf(actual), isSuccess);
        increaseCasesCounter(isSuccess);
    }
}
