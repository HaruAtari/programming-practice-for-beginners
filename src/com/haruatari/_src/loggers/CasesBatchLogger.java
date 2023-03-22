package com.haruatari._src.loggers;

public class CasesBatchLogger extends Loggable {
    private final String casesBatchName;
    private int successCount = 0;
    private int failedCount = 0;

    public CasesBatchLogger(String casesBatchName) {
        this.casesBatchName = casesBatchName;
    }

    public String getCasesBatchName() {
        return casesBatchName;
    }

    public int getSuccessCount() {
        return successCount;
    }

    public int getFailedCount() {
        return failedCount;
    }

    public void increaseSuccess() {
        successCount++;
    }

    public void increaseFailed() {
        failedCount++;
    }

    @Override
    public String toString() {
        var successRate = Math.round(100.0 / (failedCount + successCount) * successCount);
        int longestValueLength = Math.max(
            Math.max(
                String.valueOf(failedCount).length(),
                String.valueOf(successCount).length()
            ),
            (successRate + "%").length()
        );


        return new StringBuilder()
            .append(separator)
            .append(BACKGROUND_SUCCESS + "  Success:            " + successCount + "  ")
            .append(" ".repeat(longestValueLength - String.valueOf(successCount).length()) + RESET_STYLE)
            .append("\n")
            .append(BACKGROUND_ERROR + "  Failed:             " + failedCount + "  ")
            .append(" ".repeat(longestValueLength - String.valueOf(failedCount).length()) + RESET_STYLE)
            .append("\n")
            .append(BACKGROUND_WHITE + "  Success percentage: " + successRate + "%  " + RESET_STYLE)
            .append(" ".repeat(longestValueLength - String.valueOf(failedCount).length()) + RESET_STYLE)
            .toString();
    }
}
