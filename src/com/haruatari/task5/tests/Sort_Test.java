package com.haruatari.task5.tests;

import com.haruatari._src.Helper;
import com.haruatari._src.loggers.CaseLogger;
import com.haruatari._src.tests.CasesBatchTest;
import com.haruatari.task5.Node;
import com.haruatari.task5.Task;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

final class Sort_Test extends CasesBatchTest {
    public static void main(String[] args) {
        new Sort_Test().run();
    }

    @Override
    protected String getCasesBatchName() {
        return "void sort(Node[] list)";
    }

    @Override
    protected Map<String, Consumer<CaseLogger>> getCases() {
        return new HashMap<>() {{
            put("An already sorted array", l -> runCase(l,
                new Node[]{new Node(1, 10), new Node(2, 20), new Node(3, 30), new Node(4, 40), new Node(5, 50), new Node(6, 60)},
                new Node[]{new Node(1, 10), new Node(2, 20), new Node(3, 30), new Node(4, 40), new Node(5, 50), new Node(6, 60)}
            ));
            put("An array in the revert order", l -> runCase(l,
                new Node[]{new Node(6, 60), new Node(5, 50), new Node(4, 40), new Node(3, 30), new Node(2, 20), new Node(1, 10)},
                new Node[]{new Node(1, 10), new Node(2, 20), new Node(3, 30), new Node(4, 40), new Node(5, 50), new Node(6, 60)}
            ));
            put("Nodes have different ids and numbers", l -> runCase(l,
                new Node[]{new Node(1, 20), new Node(2, 20), new Node(3, 10)},
                new Node[]{new Node(3, 10), new Node(1, 10), new Node(2, 10)}
            ));
            put("Nodes have different ids and similar numbers", l -> runCase(l,
                new Node[]{new Node(3, 10), new Node(1, 10), new Node(2, 10)},
                new Node[]{new Node(3, 10), new Node(1, 10), new Node(2, 10)}
            ));
            put("An one-element array", l -> runCase(l, new Node[]{new Node(1, 10)}, new Node[]{new Node(1, 10)}));
            put("An empty array", l -> runCase(l, new Node[]{}, new Node[]{}));
        }};
    }

    private void runCase(CaseLogger logger, Node[] list, Node[] expected) {
        logger
            .setArguments(new HashMap<>() {{
                put("list", Helper.alignArray(list));
            }});

        new Task().sort(list);

        logger
            .setExpected(Helper.alignArray(expected))
            .setActual(Helper.alignArray(list))
            .setIsSuccess(Arrays.equals(list, expected));
    }
}
