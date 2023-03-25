package com.haruatari.task30.tests;

import com.haruatari._src.loggers.CaseLogger;
import com.haruatari._src.tests.CasesBatchTest;
import com.haruatari.task30.Factory;
import com.haruatari.task30.Node;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.Consumer;

final class Factory_Class extends CasesBatchTest {
    public static void main(String[] args) {
        new Factory_Class().run();
    }

    @Override
    protected String getCasesBatchName() {
        return "Factory";
    }

    @Override
    protected CaseLogger.Type getCaseLoggerType() {
        return CaseLogger.Type.CLASS;
    }

    @Override
    protected Map<String, Consumer<CaseLogger>> getCases() {
        return new HashMap<>() {{
            put("All fields are configured", l -> all(l));
            put("Only one field is configured (default values should be used for others)", l -> one(l));
            put("No fields are configured (default values should be used)", l -> no(l));
            put("Several calling of the build() method", l -> severalBuild(l));
            put("Several factories working parallel", l -> parallel(l));
        }};
    }

    private void all(CaseLogger logger) {
        logger.addFlowStep("Factory factory = new Factory();");
        var factory = new Factory();

        logger.addFlowStep("factory.setIsActive(false);");
        factory.setIsActive(false);

        logger.addFlowStep("factory.setName(\"My name\");");
        factory.setName("My name");

        logger.addFlowStep("factory.setNumber(101);");
        factory.setNumber(101);

        logger.addFlowStep("Node node = factory.build();");
        var actual = factory.build();

        var expected = new Node(101, "My name", false);

        logger
            .setExpected(String.valueOf(expected))
            .setActual(String.valueOf(actual))
            .setIsSuccess(Objects.equals(expected, actual));
    }

    private void severalBuild(CaseLogger logger) {
        logger.addFlowStep("Factory factory = new Factory();");
        var factory = new Factory();

        logger.addFlowStep("factory.setIsActive(false);");
        factory.setIsActive(false);

        logger.addFlowStep("factory.setName(\"Name 1\");");
        factory.setName("Name 1");

        logger.addFlowStep("factory.setNumber(50);");
        factory.setNumber(50);

        logger.addFlowStep("Node node1 = factory.build();");
        var actual1 = factory.build();

        logger.addFlowStep("factory.setIsActive(true);");
        factory.setIsActive(true);

        logger.addFlowStep("factory.setName(\"Name 2\");");
        factory.setName("Name 2");

        logger.addFlowStep("Node node2 = factory.build();");
        var actual2 = factory.build();

        var expected1 = new Node(50, "Name 1", false);
        var expected2 = new Node(50, "Name 2", true);

        logger
            .setExpected(new HashMap<>(){{
                put("node1",String.valueOf(expected1));
                put("node2",String.valueOf(expected2));
            }})
            .setActual(new HashMap<>(){{
                put("node1",String.valueOf(actual1));
                put("node2",String.valueOf(actual2));
            }})
            .setIsSuccess(Objects.equals(expected1, actual1) && Objects.equals(expected2, actual2))
            .hint("Calling of the build() method should not reset the factory state");
    }

    private void no(CaseLogger logger) {
        logger.addFlowStep("Factory factory = new Factory();");
        var factory = new Factory();

        logger.addFlowStep("Node node = factory.build();");
        var actual = factory.build();

        var expected = new Node(100, "Test", true);

        logger
            .setExpected(String.valueOf(expected))
            .setActual(String.valueOf(actual))
            .setIsSuccess(Objects.equals(expected, actual))
            .hint("If the appropriate configuration method wasn't called the default values should be used");
    }

    private void one(CaseLogger logger) {
        logger.addFlowStep("Factory factory = new Factory();");
        var factory = new Factory();

        logger.addFlowStep("factory.setNumber(-1);");
        factory.setNumber(-1);

        logger.addFlowStep("Node node = factory.build();");
        var actual = factory.build();

        var expected = new Node(-1, "Test", true);

        logger
            .setExpected(String.valueOf(expected))
            .setActual(String.valueOf(actual))
            .setIsSuccess(Objects.equals(expected, actual))
            .hint("If the appropriate configuration method wasn't called the default values should be used");
    }

    private void parallel(CaseLogger logger) {
        logger.addFlowStep("Factory factory1 = new Factory();");
        var factory1 = new Factory();

        logger.addFlowStep("Factory factory2 = new Factory();");
        var factory2 = new Factory();

        logger.addFlowStep("factory1.setIsActive(false);");
        factory1.setIsActive(false);

        logger.addFlowStep("factory2.setIsActive(true);");
        factory2.setIsActive(true);

        logger.addFlowStep("factory1.setName(\"Name 1\");");
        factory1.setName("Name 1");

        logger.addFlowStep("factory2.setName(\"Name 2\");");
        factory2.setName("Name 2");

        logger.addFlowStep("factory1.setNumber(0);");
        factory1.setNumber(0);

        logger.addFlowStep("factory2.setNumber(10);");
        factory2.setNumber(10);

        logger.addFlowStep("Node node1 = factory1.build();");
        var actual1 = factory1.build();

        logger.addFlowStep("Node node2 = factory2.build();");
        var actual2 = factory2.build();

        var expected1 = new Node(0, "Name 1", false);
        var expected2 = new Node(10, "Name 2", true);

        logger
            .setExpected(new HashMap<>(){{
                put("node1",String.valueOf(expected1));
                put("node2",String.valueOf(expected2));
            }})
            .setActual(new HashMap<>(){{
                put("node1",String.valueOf(actual1));
                put("node2",String.valueOf(actual2));
            }})
            .setIsSuccess(Objects.equals(expected1, actual1) && Objects.equals(expected2, actual2))
            .hint("Each instance of the Factory should store its own values");
    }
}
