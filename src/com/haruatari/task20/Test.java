package com.haruatari.task20;

import com.haruatari.BaseTest;
import com.haruatari.Helper;
import com.haruatari.TaskNumber;

import java.util.ArrayList;
import java.util.HashMap;

final public class Test extends BaseTest {
    public static void main(String[] args) {
        new Test().run();
    }

    @Override
    public TaskNumber getNumber() {
        return TaskNumber.TASK_20;
    }

    @Override
    public void run() {
        testInsertFirstCase(
                "Inserting in the not empty list",
                new Node("Dog", new Node("Cat")),
                "Rat",
                new Node("Rat", new Node("Dog", new Node("Cat")))
        );
        testInsertFirstCase(
                "Inserting in the one-element list",
                new Node("Cat"),
                "Dog",
                new Node("Dog", new Node("Cat"))
        );
        testInsertFirstCase(
                "Inserting in the empty list",
                null,
                "Cat",
                new Node("Cat")
        );

        testInsertLastCase(
                "Inserting in the not empty list",
                new Node("Cat", new Node("Dog")),
                "Rat",
                new Node("Cat", new Node("Dog", new Node("Rat")))
        );
        testInsertLastCase(
                "Inserting in the one-element list",
                new Node("Cat"),
                "Dog",
                new Node("Cat", new Node("Dog"))
        );
        testInsertLastCase(
                "Inserting in the empty list",
                null,
                "Cat",
                new Node("Cat")
        );

        {
            var node = new Node("Dog");
            testInsertAfterCase(
                    "Inserting after the last node",
                    new Node("Cat", node),
                    "Rat",
                    node,
                    new Node("Cat", new Node("Dog", new Node("Rat")))
            );
        }
        {
            var node = new Node("Dog", new Node("Bird"));
            testInsertAfterCase(
                    "Inserting after the middle node",
                    new Node("Cat", node),
                    "Rat",
                    node,
                    new Node("Cat", new Node("Dog", new Node("Rat", new Node("Bird"))))
            );
        }
        {
            var node = new Node("Cat", new Node("Rat"));
            testInsertAfterCase(
                    "Inserting after the first node",
                    node,
                    "Dog",
                    node,
                    new Node("Cat", new Node("Dog", new Node("Rat")))
            );
        }

        {
            var node = new Node("Rat");
            testInsertBeforeCase(
                    "Inserting before the last node",
                    new Node("Cat", node),
                    "Dog",
                    node,
                    new Node("Cat", new Node("Dog", new Node("Rat")))
            );
        }
        {
            var node = new Node("Rat", new Node("Bird"));
            testInsertBeforeCase(
                    "Inserting before the middle node",
                    new Node("Cat", node),
                    "Dog",
                    node,
                    new Node("Cat", new Node("Dog", new Node("Rat", new Node("Bird"))))
            );
        }
        {
            var node = new Node("Dog", new Node("Rat"));
            testInsertAfterCase(
                    "Inserting before the first node",
                    node,
                    "Cat",
                    node,
                    new Node("Cat", new Node("Dog", new Node("Rat")))
            );
        }

        showTotalResult();
    }

    private void testInsertFirstCase(String caseName, Node firstNode, String value, Node expectedFirstNode) {
        var task = new Task(firstNode);
        task.insertFirst(value);
        var isSuccess = isFirstNodesEquals(task.firstNode, expectedFirstNode);

        logCase(
                "void insertFirst(String value)",
                caseName,
                new HashMap<>() {{
                    put("list's nodes", nodeToString(firstNode));
                    put("value", String.valueOf(value));
                }},
                nodeToString(expectedFirstNode),
                nodeToString(task.firstNode),
                isSuccess
        );
    }

    private void testInsertLastCase(String caseName, Node firstNode, String value, Node expectedFirstNode) {
        var task = new Task(firstNode);
        task.insertLast(value);
        var isSuccess = isFirstNodesEquals(task.firstNode, expectedFirstNode);

        logCase(
                "void insertLast(String value)",
                caseName,
                new HashMap<>() {{
                    put("list's nodes", nodeToString(firstNode));
                    put("value", String.valueOf(value));
                }},
                nodeToString(expectedFirstNode),
                nodeToString(task.firstNode),
                isSuccess
        );
    }

    private void testInsertAfterCase(String caseName, Node firstNode, String value, Node prevNode, Node expectedFirstNode) {
        var task = new Task(firstNode);
        task.insertAfter(value, prevNode);
        var isSuccess = isFirstNodesEquals(task.firstNode, expectedFirstNode);

        logCase(
                "void insertAfter(String value, Node previousNode)",
                caseName,
                new HashMap<>() {{
                    put("list's nodes", nodeToString(firstNode));
                    put("value", String.valueOf(value));
                    put("previousNode", String.valueOf(prevNode));
                }},
                nodeToString(expectedFirstNode),
                nodeToString(task.firstNode),
                isSuccess
        );
    }

    private void testInsertBeforeCase(String caseName, Node firstNode, String value, Node nextNode, Node expectedFirstNode) {
        var task = new Task(firstNode);
        task.insertBefore(value, nextNode);
        var isSuccess = isFirstNodesEquals(task.firstNode, expectedFirstNode);

        logCase(
                "void insertBefore(String value, Node nextNode)",
                caseName,
                new HashMap<>() {{
                    put("list's nodes", nodeToString(firstNode));
                    put("value", String.valueOf(value));
                    put("nextNode", String.valueOf(nextNode));
                }},
                nodeToString(expectedFirstNode),
                nodeToString(task.firstNode),
                isSuccess
        );
    }

    private boolean isFirstNodesEquals(Node a, Node b) {
        if (a == null && b == null) {
            return true;
        }
        if (a == null && b != null) {
            return false;
        }
        if (a != null && b == null) {
            return false;
        }

        var currentA = a;
        var currentB = b;
        while (currentA != null) {
            if (!currentA.equals(currentB)) {
                return false;
            }

            currentA = currentA.next;
            currentB = currentB.next;
        }

        return currentB == null;
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
