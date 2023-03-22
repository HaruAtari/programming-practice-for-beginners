package com.haruatari.task19.tests;

import com.haruatari._src.loggers.CaseLogger;
import com.haruatari._src.tests.CasesBatchTest;
import com.haruatari.task19.DoubleLinkedList;
import com.haruatari.task19.Node;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.Consumer;

final class FindByValue_Test extends CasesBatchTest {
    public static void main(String[] args) {
        new FindByValue_Test().run();
    }

    @Override
    protected String getCasesBatchName() {
        return "Node findByValue(String value)";
    }

    @Override
    protected Map<String, Consumer<CaseLogger>> getCases() {
        var instance = this;
        return new HashMap<>() {{
            put("The searched value is the first", instance::firstValue);
            put("The searched value is the last", instance::lastValue);
            put("The searched value is in the middle", instance::middleValue);
            put("The searched value doesn't exist", instance::notExistingValue);
            put("The searched value is the only existing element in the list", instance::singleElementList);
            put("The searched value doesn't exist in the single-element list", instance::notExistingValueInSingleElementList);
            put("Searching in the empty list", instance::emptyList);
        }};
    }

    private void firstValue(CaseLogger logger) {
        var nodes = generateList();
        var list = new DoubleLinkedList(nodes.get("cat"), nodes.get("bird"));
        runCase(logger, list, "Cat", nodes.get("cat"));
    }

    private void lastValue(CaseLogger logger) {
        var nodes = generateList();
        var list = new DoubleLinkedList(nodes.get("cat"), nodes.get("bird"));
        runCase(logger, list, "Bird", nodes.get("bird"));
    }

    private void middleValue(CaseLogger logger) {
        var nodes = generateList();
        var list = new DoubleLinkedList(nodes.get("cat"), nodes.get("bird"));
        runCase(logger, list, "Rat", nodes.get("rat"));
    }

    private void notExistingValue(CaseLogger logger) {
        var nodes = generateList();
        var list = new DoubleLinkedList(nodes.get("cat"), nodes.get("bird"));
        runCase(logger, list, "Nicolas Cage", null);
    }

    private void singleElementList(CaseLogger logger) {
        var node = new Node("Cat");
        var list = new DoubleLinkedList(node, node);
        runCase(logger, list, "Cat", node);
    }

    private void notExistingValueInSingleElementList(CaseLogger logger) {
        var node = new Node("Cat");
        var list = new DoubleLinkedList(node, node);
        runCase(logger, list, "Nicolas Cage", null);
    }

    private void emptyList(CaseLogger logger) {
        var list = new DoubleLinkedList(null, null);
        runCase(logger, list, "Nicolas Cage", null);
    }

    private void runCase(CaseLogger logger, DoubleLinkedList list, String value, Node expected) {
        var actual = list.findByValue(value);
        logger
            .setArguments(new HashMap<>() {{
                put("DoubleLinkedList", String.valueOf(list));
                put("value", String.valueOf(value));
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
