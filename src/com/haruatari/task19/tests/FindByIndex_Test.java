package com.haruatari.task19.tests;

import com.haruatari._src.loggers.CaseLogger;
import com.haruatari._src.tests.MethodTest;
import com.haruatari.task19.DoubleLinkedList;
import com.haruatari.task19.Node;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.Consumer;

final class FindByIndex_Test extends MethodTest {
    public static void main(String[] args) {
        new FindByIndex_Test().run();
    }

    @Override
    protected String getMethodName() {
        return "Node finByIndex(int index)";
    }

    @Override
    protected Map<String, Consumer<CaseLogger>> getCases() {
        var instance = this;
        return new HashMap<>() {{
            put("The searched index is the first", instance::firstIndex);
            put("The searched index is the last", instance::lastIndex);
            put("The searched index is in the middle", instance::middleIndex);
            put("The searched index doesn't exist", instance::notExistingIndex);
            put("The searched index is the only existing element in the list", instance::singleElementList);
            put("The searched index doesn't exist in the single-element list", instance::notExistingIndexInSingleElementList);
            put("Searching in the empty list", instance::emptyList);
        }};
    }

    private void firstIndex(CaseLogger logger) {
        var nodes = generateList();
        var list = new DoubleLinkedList(nodes.get("cat"), nodes.get("bird"));
        runCase(logger, list, 0, nodes.get("cat"));
    }

    private void lastIndex(CaseLogger logger) {
        var nodes = generateList();
        var list = new DoubleLinkedList(nodes.get("cat"), nodes.get("bird"));
        runCase(logger, list, 3, nodes.get("bird"));
    }

    private void middleIndex(CaseLogger logger) {
        var nodes = generateList();
        var list = new DoubleLinkedList(nodes.get("cat"), nodes.get("bird"));
        runCase(logger, list, 2, nodes.get("rat"));
    }

    private void notExistingIndex(CaseLogger logger) {
        var nodes = generateList();
        var list = new DoubleLinkedList(nodes.get("cat"), nodes.get("bird"));
        runCase(logger, list, 4, null);
    }

    private void singleElementList(CaseLogger logger) {
        var node = new Node("Cat");
        var list = new DoubleLinkedList(node, node);
        runCase(logger, list, 0, node);
    }

    private void notExistingIndexInSingleElementList(CaseLogger logger) {
        var node = new Node("Cat");
        var list = new DoubleLinkedList(node, node);
        runCase(logger, list, 2, null);
    }

    private void emptyList(CaseLogger logger) {
        var list = new DoubleLinkedList(null, null);
        runCase(logger, list, 1, null);
    }

    private void runCase(CaseLogger logger, DoubleLinkedList list, int index, Node expected) {
        var actual = list.findByIndex(index);
        logger
            .setArguments(new HashMap<>() {{
                put("DoubleLinkedList", String.valueOf(list));
                put("index", String.valueOf(index));
            }})
            .setExpected(String.valueOf(expected))
            .setActual(String.valueOf(actual))
            .setIsSuccess(Objects.equals(expected, actual));
    }

    private Map<String, Node> generateList() {
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

        return new HashMap<>() {{
            put("cat", cat);
            put("dog", dog);
            put("rat", rat);
            put("bird", bird);
        }};
    }
}
