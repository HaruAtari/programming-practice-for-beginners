package com.haruatari._src.loggers;

import java.util.ArrayList;
import java.util.List;

public class TaskLogger extends Loggable {
    private List<CasesBatchLogger> methodLoggers = new ArrayList<>();
    private int successCount = 0;
    private int failedCount = 0;

    public void addMethodLogger(CasesBatchLogger methodLogger) {
        methodLoggers.add(methodLogger);
        successCount += methodLogger.getSuccessCount();
        failedCount += methodLogger.getFailedCount();
    }

    public int getSuccessCount() {
        return successCount;
    }

    public int getFailedCount() {
        return failedCount;
    }

    @Override
    public String toString() {
        var longestName = 6; // "Method"
        var longestSuccessNumber = 7; // "Success"
        var longestFailedNumber = 6; // "Failed"
        var longestSuccessRate = 18; // "Success percentage"

        var totalSuccess = 0;
        var totalFailed = 0;

        for (var methodLogger : methodLoggers) {
            longestName = Math.max(longestName, methodLogger.getCasesBatchName().length());
            longestSuccessNumber = Math.max(longestSuccessNumber, String.valueOf(methodLogger.getSuccessCount()).length());
            longestFailedNumber = Math.max(longestFailedNumber, String.valueOf(methodLogger.getFailedCount()).length());

            totalSuccess += methodLogger.getSuccessCount();
            totalFailed += methodLogger.getFailedCount();
        }

        var sb = new StringBuilder()
            .append(separator)
            .append("| " + COLOUR_HIGHLIGHT + "Method" + " ".repeat(longestName - 6) + RESET_STYLE + " ")
            .append("| " + COLOUR_HIGHLIGHT + "Success" + " ".repeat(longestSuccessNumber - 7) + RESET_STYLE + " ")
            .append("| " + COLOUR_HIGHLIGHT + "Failed" + " ".repeat(longestFailedNumber - 6) + RESET_STYLE + " ")
            .append("| " + COLOUR_HIGHLIGHT + "Success percentage" + RESET_STYLE + " |")
            .append("\n");

        for (var methodLogger : methodLoggers) {
            var successRate = Math.round(100.0 / (methodLogger.getFailedCount() + methodLogger.getSuccessCount()) * methodLogger.getSuccessCount());

            sb
                .append("| " + methodLogger.getCasesBatchName() + " ".repeat(longestName - methodLogger.getCasesBatchName().length()) + " ")
                .append("| " + COLOUR_SUCCESS + methodLogger.getSuccessCount() + " ".repeat(longestSuccessNumber - String.valueOf(methodLogger.getSuccessCount()).length()) + RESET_STYLE + " ")
                .append("| " + COLOUR_ERROR + methodLogger.getFailedCount() + " ".repeat(longestFailedNumber - String.valueOf(methodLogger.getFailedCount()).length()) + RESET_STYLE + " ")
                .append("| " + successRate + "%" + " ".repeat(longestSuccessRate - String.valueOf(successRate).length() - 1) + " |")
                .append("\n");
        }


        var totalSuccessRate = Math.round(100.0 / (totalFailed + totalSuccess) * totalSuccess);
        sb
            .append("|" + BACKGROUND_WHITE + " Total" + " ".repeat(longestName - 4) + RESET_STYLE)
            .append("|" + BACKGROUND_SUCCESS + " " + totalSuccess + " ".repeat(longestSuccessNumber - String.valueOf(totalSuccess).length() + 1) + RESET_STYLE)
            .append("|" + BACKGROUND_ERROR + " " + totalFailed + " ".repeat(longestFailedNumber - String.valueOf(totalFailed).length() + 1) + RESET_STYLE)
            .append("|" + BACKGROUND_WHITE + " " + totalSuccessRate + "%" + " ".repeat(longestSuccessRate - String.valueOf(totalSuccessRate).length()) + RESET_STYLE + "|");

        return sb.toString();
    }
}
