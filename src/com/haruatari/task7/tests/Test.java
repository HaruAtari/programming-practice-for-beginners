package com.haruatari.task7.tests;

import com.haruatari._src.tests.CasesBatchTest;
import com.haruatari._src.tests.TaskTest;

import java.util.ArrayList;
import java.util.List;

@com.haruatari._src.loader.TaskTest(7)
public final class Test extends TaskTest {
    public static void main(String[] args) {
        new Test().run();
    }

    @Override
    protected List<CasesBatchTest> getMethodTests() {
        return new ArrayList<>() {{
            add(new Zip_Test());
        }};
    }
}
