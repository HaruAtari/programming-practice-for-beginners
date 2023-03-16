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
        var cat = new Node("Cat");
        var dog = new Node("Dog");
        cat.next = dog;
        dog.prev = cat;
        var rat = new Node("Rat");
        dog.next = rat;
        rat.prev = dog;
        var bird = new Node("Bird");
        rat.next = bird;
        bird.prev = rat;

        testFindByIndexCase(
                "Searching for the first index",
                cat,
                bird,
                0,
                cat
        );
        testFindByIndexCase(
                "Searching for a not edged index",
                cat,
                bird,
                2,
                rat
        );
        testFindByIndexCase(
                "Searching for the last index",
                cat,
                bird,
                3,
                bird
        );
        testFindByIndexCase(
                "Searching for a not existing index",
                cat,
                bird,
                4,
                null
        );
        {
            var node = new Node("Cat");
            testFindByIndexCase(
                    "Searching for the only existing index",
                    node,
                    node,
                    0,
                    node
            );
        }
        {
            var node = new Node("Cat");
            testFindByIndexCase(
                    "Searching for a not existing index in the one-element list",
                    node,
                    node,
                    1,
                    null
            );
        }
        testFindByIndexCase(
                "Searching in the empty list",
                null,
                null,
                1,
                null
        );

        testFindByValueCase(
                "Searching for the first value",
                cat,
                bird,
                "Cat",
                cat
        );
        testFindByValueCase(
                "Searching for a not edged value",
                cat,
                bird,
                "Rat",
                rat
        );
        testFindByValueCase(
                "Searching for the last value",
                cat,
                bird,
                "Bird",
                bird
        );
        testFindByValueCase(
                "Searching for a not existing value",
                cat,
                bird,
                "Nicolas Cage",
                null
        );
        {
            var node = new Node("Cat");
            testFindByValueCase(
                    "Searching for the only existing value",
                    node,
                    node,
                    "Cat",
                    node
            );
        }
        {
            var node = new Node("Cat");
            testFindByValueCase(
                    "Searching for the only existing value",
                    node,
                    node,
                    "Nicolas Cage",
                    null
            );
        }
        testFindByValueCase(
                "Searching in the empty list",
                null,
                null,
                "Nicolas Cage",
                null
        );

        showTotalResult();
    }

    private void testFindByIndexCase(String caseName, Node firstNode, Node lastNode, int index, Node expected) {
        var arguments = new HashMap<String, String>() {{
            put("list's nodes", nodeToString(firstNode));
            put("index", String.valueOf(index));
        }};
        var actual = new Task(firstNode, lastNode).findByIndex(index);
        var isSuccess = Objects.equals(expected, actual);

        logCase(
                "Node findByIndex(int index)",
                caseName,
                arguments,
                String.valueOf(expected),
                String.valueOf(actual),
                isSuccess
        );
    }

    private void testFindByValueCase(String caseName, Node firstNode, Node lastNode, String value, Node expected) {
        var arguments = new HashMap<String, String>() {{
            put("list's nodes", nodeToString(firstNode));
            put("value", value);
        }};
        var actual = new Task(firstNode, lastNode).findByValue(value);
        var isSuccess = Objects.equals(expected, actual);

        logCase(
                "Node findByValue(String value)",
                caseName,
                arguments,
                String.valueOf(expected),
                String.valueOf(actual),
                isSuccess
        );
    }

    private String nodeToString(Node node) {
        var list = new ArrayList<String>();

        while (node != null) {
            var str = String.valueOf(node);
            if (node.prev == null) {
                str += " <-- firstNode";
            }
            if (node.next == null) {
                str += " <-- lastNode";
            }
            list.add(str);
            node = node.next;
        }

        return Helper.alignArray(list.toArray());
    }
}
