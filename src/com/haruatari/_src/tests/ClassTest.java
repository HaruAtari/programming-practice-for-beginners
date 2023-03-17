package com.haruatari._src.tests;

import com.haruatari._src.loggers.ClassLogger;

import java.util.List;

abstract public class ClassTest extends Test {
    abstract protected List<MethodTest> getMethodTests();

    final public void run() {
        run(false, false);
    }

    final public ClassLogger runPartially() {
        return run(true, false);
    }

    final public ClassLogger runSilently() {
        return run(true, true);
    }

    final public ClassLogger run(boolean partially, boolean silently) {
        var logger = new ClassLogger();
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
