package com.haruatari.task6.tests;

import com.haruatari._src.loader.TaskTest;
import com.haruatari._src.tests.ClassTest;
import com.haruatari._src.tests.MethodTest;

import java.util.ArrayList;
import java.util.List;

@TaskTest(6)
public final class Test extends ClassTest {
    public static void main(String[] args) {
        new Test().run();
    }

    @Override
    protected List<MethodTest> getMethodTests() {
        return new ArrayList<>() {{
            add(new Fold_Test());
        }};
    }
}
