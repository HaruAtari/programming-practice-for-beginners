package com.haruatari.task34.tests;

import com.haruatari._src.tests.CasesBatchTest;
import com.haruatari._src.tests.TaskTest;

import java.util.ArrayList;
import java.util.List;

@com.haruatari._src.loader.TaskTest(34)
public final class Test extends TaskTest {
    public static void main(String[] args) {
        new Test().run();
    }

    @Override
    protected List<CasesBatchTest> getMethodTests() {
        return new ArrayList<>() {{
            add(new Step1_Test());
            add(new Step2_Test());
        }};
    }
}
