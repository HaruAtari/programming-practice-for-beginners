package org.haruatari.task5;

import org.haruatari.BaseTest;

import java.util.Arrays;
import java.util.HashMap;

final public class Test extends BaseTest {
    public static void main(String[] args) {
        new Test().run();
    }

    @Override
    public void run() {
        testSortCase(
                new Node[]{new Node(1, 10), new Node(2, 20), new Node(3, 30)},
                new Node[]{new Node(1, 10), new Node(2, 20), new Node(3, 30)}
        );
        testSortCase(
                new Node[]{new Node(3, 30), new Node(2, 20), new Node(1, 10)},
                new Node[]{new Node(1, 10), new Node(2, 20), new Node(3, 30)}
        );
        testSortCase(
                new Node[]{new Node(1, 20), new Node(2, 20), new Node(3, 10)},
                new Node[]{new Node(3, 10), new Node(1, 10), new Node(2, 10)}
        );
        testSortCase(
                new Node[]{new Node(3, 10), new Node(1, 10), new Node(2, 10)},
                new Node[]{new Node(3, 10), new Node(1, 10), new Node(2, 10)}
        );
        testSortCase(
                new Node[]{new Node(1, 10)},
                new Node[]{new Node(1, 10)}
        );
        testSortCase(
                new Node[]{},
                new Node[]{}
        );
        logTotalResult();
    }

    public void testSortCase(Node[] list, Node[] expected) {
        logMethodName("void sort(Node[] list)");
        logMethodArguments(new HashMap<>() {{
            put("list", Arrays.toString(list));
        }});

        new Task().sort(list);
        var isSuccess = Arrays.equals(list, expected);

        logMethodResults(Arrays.toString(expected), Arrays.toString(list), isSuccess);
        increaseCasesCounter(isSuccess);
    }
}
