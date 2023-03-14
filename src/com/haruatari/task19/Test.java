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
                new Task(new Node("Cat", new Node("Dog", new Node("Rat")))),
                0,
                new Node("Cat")
        );
        testFindByIndexCase(
                new Task(new Node("Cat", new Node("Dog", new Node("Rat")))),
                1,
                new Node("Dog")
        );
        testFindByIndexCase(
                new Task(new Node("Cat", new Node("Dog", new Node("Rat")))),
                2,
                new Node("Rat")
        );
        testFindByIndexCase(
                new Task(new Node("Cat", new Node("Dog", new Node("Rat")))),
                3,
                null
        );
        testFindByIndexCase(new Task(new Node("Cat")), 0, new Node("Cat"));
        testFindByIndexCase(new Task(new Node("Cat")), 1, null);
        testFindByIndexCase(new Task(), 1, null);


        testFindByValueCase(
                new Task(new Node("Cat", new Node("Dog", new Node("Rat")))),
                "Cat",
                new Node("Cat")
        );
        testFindByValueCase(
                new Task(new Node("Cat", new Node("Dog", new Node("Rat")))),
                "Dog",
                new Node("Dog")
        );
        testFindByValueCase(
                new Task(new Node("Cat", new Node("Dog", new Node("Rat")))),
                "Rat",
                new Node("Rat")
        );
        testFindByValueCase(
                new Task(new Node("Cat", new Node("Dog", new Node("Rat")))),
                "Nicolas Cage",
                null
        );
        testFindByValueCase(new Task(new Node("Cat")), "Cat", new Node("Cat"));
        testFindByValueCase(new Task(new Node("Cat")), "Nicolas Cage", null);
        testFindByValueCase(new Task(), "Nicolas Cage", null);

        showTotalResult();
    }

    private void testFindByIndexCase(Task list, int index, Node expected) {
        var actual = list.findByIndex(index);
        var isSuccess = Objects.equals(expected, actual);

        logCase(
                "Node findByIndex(int index)",
                new HashMap<>() {{
                    put("list's nodes", nodeToString(list.firstNode));
                    put("index", String.valueOf(index));
                }},
                String.valueOf(expected),
                String.valueOf(actual),
                isSuccess
        );
    }

    private void testFindByValueCase(Task list, String value, Node expected) {
        var actual = list.findByValue(value);
        var isSuccess = Objects.equals(expected, actual);

        logCase(
                "Node findByValue(String value)",
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
