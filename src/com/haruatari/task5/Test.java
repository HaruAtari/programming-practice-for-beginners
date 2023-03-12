package com.haruatari.task5;

import com.haruatari.BaseTest;
import com.haruatari.Helper;
import com.haruatari.TaskNumber;

import java.util.Arrays;
import java.util.HashMap;

final public class Test extends BaseTest {
    public static void main(String[] args) {
        new Test().run();
    }

    @Override
    public TaskNumber getNumber() {
        return TaskNumber.TASK_5;
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
        showTotalResult();
    }

    public void testSortCase(Node[] list, Node[] expected) {
        new Task().sort(list);
        var isSuccess = Arrays.equals(list, expected);

        logCase(
                "void sort(Node[] list)",
                new HashMap<>() {{
                    put("list", Helper.alignArray(list));
                }},
                Helper.alignArray(expected),
                Helper.alignArray(list),
                isSuccess
        );
    }
}
