package com.haruatari._src.tests;

import com.haruatari._src.loggers.TaskLogger;

import java.util.List;

abstract public class TaskTest extends Test {
    abstract protected List<CasesBatchTest> getMethodTests();

    final public void run() {
        run(false, false);
    }

    final public TaskLogger runPartially() {
        return run(true, false);
    }

    final public TaskLogger runSilently() {
        return run(true, true);
    }

    final public TaskLogger run(boolean partially, boolean silently) {
        var logger = new TaskLogger();
        for (var methodTest : getMethodTests()) {
            if (silently) {
                logger.addMethodLogger(methodTest.runSilently());
            } else {
                logger.addMethodLogger(methodTest.runPartially());
            }
        }

        if (!partially) {
            System.out.println(logger);
        }

        return logger;
    }
}
