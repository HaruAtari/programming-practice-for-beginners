package com.haruatari._src.loggers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CaseLogger extends Loggable {
    private Type type;
    private String name;
    private String description;
    private Map<String, String> arguments = new HashMap();
    private boolean isSuccess = false;
    private String expected = null;
    private String actual = null;
    private String hint = null;
    private List<String> flow = new ArrayList<>();
    private boolean showResultBlock = false;

    public enum Type {
        METHOD,
        STEP,
        CLASS;

        public String getTitle() {
            switch (this) {
                case CLASS -> {
                    return "Class";
                }
                case METHOD -> {
                    return "Method";
                }
                case STEP -> {
                    return "Step";
                }
            }

            return "-";
        }
    }

    public CaseLogger(String methodName, String caseDescription, Type type) {
        this.name = methodName;
        this.description = caseDescription;
        this.type = type;
    }

    @Deprecated
    public CaseLogger(String methodName, String caseDescription) {
        this(methodName, caseDescription, Type.METHOD);
    }

    @Deprecated
    public CaseLogger(String methodName) {
        this(methodName, null, Type.METHOD);
    }

    @Override
    public String toString() {
        return new StringBuilder()
            .append(nameToString())
            .append(descriptionToString())
            .append(argumentsToString())
            .append(flowToString())
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

    public CaseLogger addFlowStep(String step) {
        flow.add(step);

        return this;
    }

    public CaseLogger setIsSuccess(boolean value) {
        isSuccess = value;

        return this;
    }

    public CaseLogger setExpected(String value) {
        expected = value;
        showResultBlock = true;

        return this;
    }

    public CaseLogger setExpected(Map<String, String> value) {
        StringBuilder result = new StringBuilder();
        for (var entry : value.entrySet()) {
            result.append("\n  ").append(entry.getKey()).append(": ").append(entry.getValue());
        }

        return setExpected(result.toString());
    }

    public CaseLogger setActual(String value) {
        actual = value;
        showResultBlock = true;

        return this;
    }

    public CaseLogger setActual(Map<String, String> value) {
        StringBuilder result = new StringBuilder();
        for (var entry : value.entrySet()) {
            result.append("\n  ").append(entry.getKey()).append(": ").append(entry.getValue());
        }

        return setActual(result.toString());
    }

    public CaseLogger hint(String value) {
        hint = value;

        return this;
    }

    public String getName() {
        return name;
    }

    private String nameToString() {
        var sb = new StringBuilder();
        sb.append(separator);
        sb.append(COLOUR_HIGHLIGHT + type.getTitle() + ": " + RESET_STYLE);
        sb.append(name + "\n");
        return sb.toString();
    }

    private String descriptionToString() {
        if (description == null) {
            return "\n";
        }

        var sb = new StringBuilder();
        sb.append(COLOUR_HIGHLIGHT + "Case: " + RESET_STYLE);
        sb.append(description + "\n\n");

        return sb.toString();
    }

    private String argumentsToString() {
        if (arguments.isEmpty()) {
            return "";
        }

        var sb = new StringBuilder();

        sb.append(COLOUR_HIGHLIGHT + "Arguments:" + RESET_STYLE + "\n");
        for (var entity : arguments.entrySet()) {
            sb.append(entity.getKey() + ": " + entity.getValue() + "\n");
        }
        sb.append("\n");

        return sb.toString();
    }

    private String flowToString() {
        if (flow.isEmpty()) {
            return "";
        }
        var sb = new StringBuilder();

        sb.append(COLOUR_HIGHLIGHT + "Flow:" + RESET_STYLE + "\n");
        sb.append(String.join("\n", flow));
        sb.append("\n\n");

        return sb.toString();
    }

    private String resultsToString() {
        var sb = new StringBuilder();
        sb.append(COLOUR_HIGHLIGHT + "Result:" + RESET_STYLE + "\n");
        if (showResultBlock) {
            sb.append("Expected: " + expected + "\n");
            sb.append("Actual: " + actual + "\n");
        }
        sb.append("Summary: ");

        if (isSuccess) {
            sb.append(COLOUR_SUCCESS + "Success" + RESET_STYLE);
        } else {
            sb.append(COLOUR_ERROR + "Failed" + RESET_STYLE);
        }
        if (!isSuccess && hint != null) {
            sb.append(COLOUR_HINT + "\nHint: " + hint + RESET_STYLE);
        }

        return sb.toString();
    }
}
