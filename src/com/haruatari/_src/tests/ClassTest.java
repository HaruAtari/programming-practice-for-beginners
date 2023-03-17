package com.haruatari._src.tests;

import com.haruatari._src.loggers.ClassLogger;

import java.util.List;

abstract public class ClassTest extends Test {
    abstract protected List<MethodTest> getMethodTests();

    final protected void run() {
        var logger = new ClassLogger();
        for (var methodTest : getMethodTests()) {
            logger.addMethodLogger(methodTest.runPartially());
        }
        System.out.println(logger);
    }
}
