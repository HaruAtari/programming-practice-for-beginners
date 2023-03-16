package com.haruatari.task19.tests;

import com.haruatari._src.tests.ClassTest;
import com.haruatari._src.tests.MethodTest;

import java.util.ArrayList;
import java.util.List;

public final class Test extends ClassTest {
    public static void main(String[] args) {
        new Test().run();
    }

    @Override
    protected List<MethodTest> getMethodTests() {
        return new ArrayList<>() {{
            add(new FindByIndex_Test());
            add(new FindByValue_Test());
        }};
    }
}
