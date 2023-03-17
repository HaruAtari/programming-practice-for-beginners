package com.haruatari._src.loader;

import com.haruatari._src.tests.ClassTest;

public class Task {
    public final ClassTest test;
    public final String name;
    public final int order;

    public Task(ClassTest test, String name, int order) {
        this.test = test;
        this.name = name;
        this.order = order;
    }
}
