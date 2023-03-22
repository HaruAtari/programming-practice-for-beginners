package com.haruatari._src.loader;

import com.haruatari._src.tests.TaskTest;

public class Task {
    public final TaskTest test;
    public final int number;

    public Task(TaskTest test, int number) {
        this.test = test;
        this.number = number;
    }

    public String getName() {
        return "Task " + number;
    }
}
