package com.haruatari._src.tests;

import com.haruatari._src.loggers.CaseLogger;
import com.haruatari._src.loggers.MethodLogger;

import java.util.Map;
import java.util.function.Consumer;

abstract public class MethodTest extends Test {
    abstract protected String getMethodName();

    abstract protected Map<String, Consumer<CaseLogger>> getCases();

    final public void run() {
        run(false);
    }

    final public MethodLogger runPartially() {
        return run(true);
    }

    private MethodLogger run(boolean partially) {
        var summary = new MethodLogger(getMethodName());

        for (var set : getCases().entrySet()) {
            var logger = new CaseLogger(getMethodName(), set.getKey());

            set.getValue().accept(logger);

            System.out.println(logger);

            if (logger.setIsSuccess()) {
                summary.increaseSuccess();
            } else {
                summary.increaseFailed();
            }
        }

        if (!partially) {
            System.out.println(summary);
        }

        return summary;
    }
}