package com.haruatari._src.tests;

import com.haruatari._src.loggers.CaseLogger;
import com.haruatari._src.loggers.CasesBatchLogger;

import java.util.Map;
import java.util.function.Consumer;

abstract public class CasesBatchTest extends Test {
    abstract protected String getCasesBatchName();

    abstract protected Map<String, Consumer<CaseLogger>> getCases();

    final public void run() {
        run(false, false);
    }

    final public CasesBatchLogger runPartially() {
        return run(true, false);
    }

    final public CasesBatchLogger runSilently() {
        return run(true, true);
    }

    protected CaseLogger.Type getCaseLoggerType() {
        return CaseLogger.Type.METHOD;
    }

    private CasesBatchLogger run(boolean partially, boolean silently) {
        var summary = new CasesBatchLogger(getCasesBatchName());

        for (var set : getCases().entrySet()) {
            var logger = set.getKey().chars().allMatch(Character::isDigit)
                ? new CaseLogger(getCasesBatchName())
                : new CaseLogger(getCasesBatchName(), set.getKey(), getCaseLoggerType());

            set.getValue().accept(logger);

            if (!silently) {
                System.out.println(logger);
            }
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
