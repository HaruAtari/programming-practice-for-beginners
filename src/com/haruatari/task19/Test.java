package com.haruatari.task19;

import com.haruatari.BaseTest;
import com.haruatari.Helper;
import com.haruatari.TaskNumber;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

final public class Test extends BaseTest {
    public static void main(String[] args) {
        new Test().run();
    }

    @Override
    public TaskNumber getNumber() {
        return TaskNumber.TASK_19;
    }

    @Override
    public void run() {
        testFindByIndexCase(
                "Searching for the first index",
                new Task(new Node("Cat", new Node("Dog", new Node("Rat", new Node("Bird"))))),
                0,
                new Node("Cat")
        );
        testFindByIndexCase(
                "Searching for a not edged index",
                new Task(new Node("Cat", new Node("Dog", new Node("Rat", new Node("Bird"))))),
                2,
                new Node("Rat")
        );
        testFindByIndexCase(
                "Searching for the last index",
                new Task(new Node("Cat", new Node("Dog", new Node("Rat", new Node("Bird"))))),
                3,
                new Node("Bird")
        );
        testFindByIndexCase(
                "Searching for a not existing index",
                new Task(new Node("Cat", new Node("Dog", new Node("Rat", new Node("Bird"))))),
                4,
                null
        );
        testFindByIndexCase(
                "Searching for the only existing index",
                new Task(new Node("Cat")),
                0,
                new Node("Cat")
        );
        testFindByIndexCase(
                "Searching for a not existing index in the one-element list",
                new Task(new Node("Cat")),
                1,
                null
        );
        testFindByIndexCase(
                "Searching in the empty list",
                new Task(),
                1,
                null
        );

        testFindByValueCase(
                "Searching for the first value",
                new Task(new Node("Cat", new Node("Dog", new Node("Rat", new Node("Bird"))))),
                "Cat",
                new Node("Cat")
        );
        testFindByValueCase(
                "Searching for a not edged value",
                new Task(new Node("Cat", new Node("Dog", new Node("Rat", new Node("Bird"))))),
                "Rat",
                new Node("Rat")
        );
        testFindByValueCase(
                "Searching for the last value",
                new Task(new Node("Cat", new Node("Dog", new Node("Rat", new Node("Bird"))))),
                "Bird",
                new Node("Bird")
        );
        testFindByValueCase(
                "Searching for a not existing value",
                new Task(new Node("Cat", new Node("Dog", new Node("Rat", new Node("Bird"))))),
                "Nicolas Cage",
                null
        );
        testFindByValueCase(
                "Searching for the only existing value",
                new Task(new Node("Cat")),
                "Cat",
                new Node("Cat")
        );
        testFindByValueCase(
                "Searching for a not existing value in the one-element list",
                new Task(new Node("Cat")),
                "Nicolas Cage",
                null
        );
        testFindByValueCase(
                "Searching in the empty list",
                new Task(),
                "Nicolas Cage",
                null
        );

        showTotalResult();
    }

    private void testFindByIndexCase(String caseName, Task list, int index, Node expected) {
        var actual = list.findByIndex(index);
        var isSuccess = Objects.equals(expected, actual);

        logCase(
                "Node findByIndex(int index)",
                caseName,
                new HashMap<>() {{
                    put("list's nodes", nodeToString(list.firstNode));
                    put("index", String.valueOf(index));
                }},
                String.valueOf(expected),
                String.valueOf(actual),
                isSuccess
        );
    }

    private void testFindByValueCase(String caseName, Task list, String value, Node expected) {
        var actual = list.findByValue(value);
        var isSuccess = Objects.equals(expected, actual);

        logCase(
                "Node findByValue(String value)",
                caseName,
                new HashMap<>() {{
                    put("list's nodes", nodeToString(list.firstNode));
                    put("value", value);
                }},
                String.valueOf(expected),
                String.valueOf(actual),
                isSuccess
        );
    }

    private String nodeToString(Node node) {
        var list = new ArrayList<String>();

        while (node != null) {
            var str = String.valueOf(node);
            if (list.isEmpty()) {
                str += " <-- firstNode";
            }
            list.add(str);
            node = node.next;
        }

        return Helper.alignArray(list.toArray());
    }
}
