package com.haruatari._src;

import com.haruatari._src.loader.Task;
import com.haruatari._src.loader.TasksLoader;
import com.haruatari._src.loggers.ClassLogger;
import com.haruatari._src.loggers.Loggable;

import java.util.HashMap;

public class Runner extends Loggable {

    protected void runAllTasks() {
        var tasks = new TasksLoader().loadTasks();
        tasks.sort((a, b) -> a.order > b.order ? 1 : -1);


        var longestName = 4; // "Task"
        var longestSuccessNumber = 7; // "Success"
        var longestFailedNumber = 6; // "Failed"
        var longestSuccessRate = 18; // "Success percentage"

        var totalSuccess = 0;
        var totalFailed = 0;

        var loggers = new HashMap<Task, ClassLogger>();
        for (var task : tasks) {
            var logger = task.test.runSilently();
            loggers.put(task, logger);

            longestName = Math.max(longestName, task.name.length());
            longestSuccessNumber = Math.max(longestSuccessNumber, String.valueOf(logger.getSuccessCount()).length());
            longestFailedNumber = Math.max(longestFailedNumber, String.valueOf(logger.getFailedCount()).length());

            totalSuccess += logger.getSuccessCount();
            totalFailed += logger.getFailedCount();
        }

        var sb = new StringBuilder()
            .append("\n")
            .append("| " + COLOUR_HIGHLIGHT + "Task" + " ".repeat(longestName - 4) + RESET_STYLE + " ")
            .append("| " + COLOUR_HIGHLIGHT + "Success" + " ".repeat(longestSuccessNumber - 7) + RESET_STYLE + " ")
            .append("| " + COLOUR_HIGHLIGHT + "Failed" + " ".repeat(longestFailedNumber - 6) + RESET_STYLE + " ")
            .append("| " + COLOUR_HIGHLIGHT + "Success percentage" + RESET_STYLE + " |")
            .append("\n");

        for (var task : tasks) {
            var logger = loggers.get(task);

            var successRate = 100 / (logger.getFailedCount() + logger.getSuccessCount()) * logger.getSuccessCount();

            sb
                .append("| " + task.name + " ".repeat(longestName - task.name.length()) + " ")
                .append("| " + COLOUR_SUCCESS + logger.getSuccessCount() + " ".repeat(longestSuccessNumber - String.valueOf(logger.getSuccessCount()).length()) + RESET_STYLE + " ")
                .append("| " + COLOUR_ERROR + logger.getFailedCount() + " ".repeat(longestFailedNumber - String.valueOf(logger.getFailedCount()).length()) + RESET_STYLE + " ")
                .append("| " + successRate + "%" + " ".repeat(longestSuccessRate - String.valueOf(successRate).length() - 1) + " |")
                .append("\n");
        }


        var totalSuccessRate = 100 / (totalFailed + totalSuccess) * totalSuccess;
        sb
            .append("|" + BACKGROUND_WHITE + " Total" + " ".repeat(longestName - 4) + RESET_STYLE)
            .append("|" + BACKGROUND_SUCCESS + " " + totalSuccess + " ".repeat(longestSuccessNumber - String.valueOf(totalSuccess).length() + 1) + RESET_STYLE)
            .append("|" + BACKGROUND_ERROR + " " + totalFailed + " ".repeat(longestFailedNumber - String.valueOf(totalFailed).length() + 1) + RESET_STYLE)
            .append("|" + BACKGROUND_WHITE + " " + totalSuccessRate + "%" + " ".repeat(longestSuccessRate - String.valueOf(totalSuccessRate).length()) + RESET_STYLE + "|");

        System.out.println(sb);
    }
}
