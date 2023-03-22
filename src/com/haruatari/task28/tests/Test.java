package com.haruatari.task28.tests;

import com.haruatari._src.tests.CasesBatchTest;
import com.haruatari._src.tests.TaskTest;

import java.util.ArrayList;
import java.util.List;

@com.haruatari._src.loader.TaskTest(28)
public final class Test extends TaskTest {
    public static void main(String[] args) {
        new Test().run();
    }

    @Override
    protected List<CasesBatchTest> getMethodTests() {
        return new ArrayList<>() {{
            add(new Pivot_Test());
        }};
    }
}
