package com.haruatari._src.loggers;

import java.util.ArrayList;
import java.util.List;

public class ClassLogger extends Logger {
    private List<MethodLogger> methodLoggers = new ArrayList<>();
    private String taskName;

    public ClassLogger(String taskName) {
        this.taskName = taskName;
    }

    public void addMethodLogger(MethodLogger methodLogger) {
        methodLoggers.add(methodLogger);
    }

    @Override
    public String toString() {


        var longestName = 6; // "method"
        var longestSuccessNumber = 7; // "Success"
        var longestFailedNumber = 6; // "failed"

        var totalSuccess = 0;
        var totalFailed = 0;

        for (var methodLogger : methodLoggers) {
            longestName = Math.max(longestName, methodLogger.getMethodName().length());
            longestSuccessNumber = Math.max(longestSuccessNumber, String.valueOf(methodLogger.getSuccessCount()).length());
            longestFailedNumber = Math.max(longestFailedNumber, String.valueOf(methodLogger.getFailedCount()).length());

            totalSuccess += methodLogger.getSuccessCount();
            totalFailed += methodLogger.getFailedCount();
        }

        var sb = new StringBuilder()
                .append(separator)
                .append("| " + COLOUR_HIGHLIGHT + "Method" + " ".repeat(longestName - 6) + RESET_STYLE + " ")
                .append("| " + COLOUR_HIGHLIGHT + "Success" + " ".repeat(longestSuccessNumber - 7) + RESET_STYLE + " ")
                .append("| " + COLOUR_HIGHLIGHT + "Failed" + " ".repeat(longestFailedNumber - 6) + RESET_STYLE + " |")
                .append("\n");

        for (var methodLogger : methodLoggers) {
            sb
                    .append("| " + methodLogger.getMethodName() + " ".repeat(longestName - methodLogger.getMethodName().length()) + " ")
                    .append("| " + COLOUR_SUCCESS + methodLogger.getSuccessCount() + " ".repeat(longestSuccessNumber - String.valueOf(methodLogger.getSuccessCount()).length()) + RESET_STYLE + " ")
                    .append("| " + COLOUR_ERROR + methodLogger.getFailedCount() + " ".repeat(longestFailedNumber - String.valueOf(methodLogger.getFailedCount()).length()) + RESET_STYLE + " |")
                    .append("\n");
        }

        sb
                .append("|" + BACKGROUND_WHITE + " Total" + " ".repeat(longestName - 5) + " " + RESET_STYLE)
                .append("|" + BACKGROUND_SUCCESS + " " + totalSuccess + " ".repeat(longestSuccessNumber - String.valueOf(totalSuccess).length()) + " " + RESET_STYLE)
                .append("|" + BACKGROUND_ERROR + " " + totalFailed + " ".repeat(longestFailedNumber - String.valueOf(totalFailed).length()) + " " + RESET_STYLE + "|");

        return sb.toString();
    }
}
