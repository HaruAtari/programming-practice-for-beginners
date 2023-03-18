package com.haruatari._src.loader;

import com.haruatari._src.tests.ClassTest;

public class Task {
    public final ClassTest test;
    public final int number;

    public Task(ClassTest test, int number) {
        this.test = test;
        this.number = number;
    }

    public String getName() {
        return "Task " + number;
    }
}
