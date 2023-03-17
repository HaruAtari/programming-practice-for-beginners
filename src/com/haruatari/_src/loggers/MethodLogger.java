package com.haruatari._src.loggers;

public class MethodLogger extends Logger {
    private final String methodName;
    private int successCount = 0;
    private int failedCount = 0;

    public MethodLogger(String methodName) {
        this.methodName = methodName;
    }

    public String getMethodName() {
        return methodName;
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
        var successRate = 100 / (failedCount + successCount) * successCount;
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
            .append("  Success percentage: " + successRate + "%  ")
            .append(" ".repeat(longestValueLength - String.valueOf(failedCount).length()) + RESET_STYLE)
            .toString();
    }
}
