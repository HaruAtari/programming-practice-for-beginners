package com.haruatari._src.loggers;

import java.util.HashMap;
import java.util.Map;

public class CaseLogger extends Logger {
    private String methodName;
    private String caseDescription;
    private Map<String, String> arguments = new HashMap();
    private boolean isSuccess = false;
    private String expected = null;
    private String actual = null;
    private String hint = null;

    public CaseLogger(String methodName, String caseDescription) {
        this.methodName = methodName;
        this.caseDescription = caseDescription;
    }

    @Override
    public String toString() {
        return new StringBuilder()
                .append(methodNameToString())
                .append(caseDescriptionToString())
                .append(argumentsToString())
                .append(resultsToString())
                .toString();
    }

    public boolean setIsSuccess() {
        return isSuccess;
    }

    public CaseLogger setArguments(Map<String, String> value) {
        arguments = value;

        return this;
    }

    public CaseLogger setIsSuccess(boolean value) {
        isSuccess = value;

        return this;
    }

    public CaseLogger setExpected(String value) {
        expected = value;

        return this;
    }

    public CaseLogger setActual(String value) {
        actual = value;

        return this;
    }

    public CaseLogger hint(String value) {
        hint = value;

        return this;
    }

    public String getMethodName() {
        return methodName;
    }

    private String methodNameToString() {
        var sb = new StringBuilder();
        sb.append(separator);
        sb.append(COLOUR_HIGHLIGHT + "Method: " + RESET_STYLE);
        sb.append(methodName + "\n");
        return sb.toString();
    }

    private String caseDescriptionToString() {
        var sb = new StringBuilder();
        sb.append(COLOUR_HIGHLIGHT + "Case: " + RESET_STYLE);
        sb.append(caseDescription + "\n\n");

        return sb.toString();
    }

    private String argumentsToString() {
        var sb = new StringBuilder();

        sb.append(COLOUR_HIGHLIGHT + "Arguments:" + RESET_STYLE + "\n");
        for (var entity : arguments.entrySet()) {
            sb.append(entity.getKey() + ": " + entity.getValue() + "\n");
        }
        sb.append("\n");

        return sb.toString();
    }

    private String resultsToString() {
        var sb = new StringBuilder();
        sb.append(COLOUR_HIGHLIGHT + "Result:" + RESET_STYLE + "\n");
        sb.append("Expected: " + expected + "\n");
        sb.append("Actual: " + actual + "\n");
        sb.append("Summary: ");

        if (isSuccess) {
            sb.append(COLOUR_SUCCESS + "Success" + RESET_STYLE);
        } else {
            sb.append(COLOUR_ERROR + "Failed" + RESET_STYLE);
        }
        if (!isSuccess && hint != null) {
            sb.append("\nError description: " + hint);
        }

        return sb.toString();
    }
}
