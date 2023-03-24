package com.haruatari.task33.tests;

import com.haruatari._src.Helper;
import com.haruatari._src.loggers.CaseLogger;
import com.haruatari._src.tests.CasesBatchTest;
import com.haruatari.task33.Messenger;
import com.haruatari.task33.User;

import java.util.*;
import java.util.function.Consumer;

public class SendingMessages_Flow extends CasesBatchTest {
    private Map<TestUser, String> receivers = new HashMap<>();

    public static void main(String[] args) {
        new SendingMessages_Flow().run();
    }

    @Override
    protected String getCasesBatchName() {
        return "Sending messages";
    }

    @Override
    protected CaseLogger.Type getCaseLoggerType() {
        return CaseLogger.Type.CLASS;
    }


    @Override
    protected Map<String, Consumer<CaseLogger>> getCases() {
        return new HashMap<>() {{
            put("Send to all users", l -> all(l));
            put("Send to online users only", l -> online(l));
            put("Send to the single existing user", l -> singleExisting(l));
            put("Send to the single not existing user", l -> singleNotExisting(l));
        }};
    }

    private void all(CaseLogger logger) {
        receivers.clear();

        logger.addFlowStep("Messenger messenger = new Messenger();");
        var messenger = new Messenger();

        logger.addFlowStep("User marine = new User(\"Marina\");");
        var marina = new TestUser("Marina");

        logger.addFlowStep("User viktor = new User(\"Viktor\");");
        var viktor = new TestUser("Viktor");

        logger.addFlowStep("User bob = new User(\"Bob\");");
        var bob = new TestUser("Bob");

        logger.addFlowStep("messenger.addUser(marina);");
        messenger.addUser(marina);

        logger.addFlowStep("messenger.addUser(viktor);");
        messenger.addUser(viktor);

        logger.addFlowStep("messenger.addUser(bob);");
        messenger.addUser(bob);

        logger.addFlowStep("messenger.setUserOffline(bob);");
        messenger.setUserOffline(bob);

        logger.addFlowStep("messenger.sendMessageToAllUsers(\"Hello, world!\");");
        messenger.sendMessageToAllUsers("Hello, world!");

        var actual = new ArrayList<TestUser>();
        for (var entry : receivers.entrySet()) {
            if (entry.getValue().equals("Hello, world!")) {
                actual.add(entry.getKey());
            }
        }

        var expected = List.of(marina, viktor, bob);

        logger
            .setExpected(Helper.alignList(expected))
            .setActual(Helper.alignList(actual))
            .setIsSuccess(Helper.compareListsIgnoringOrder(actual, expected));
    }

    private void online(CaseLogger logger) {
        receivers.clear();

        logger.addFlowStep("Messenger messenger = new Messenger();");
        var messenger = new Messenger();

        logger.addFlowStep("User marine = new User(\"Marina\");");
        var marina = new TestUser("Marina");

        logger.addFlowStep("User viktor = new User(\"Viktor\");");
        var viktor = new TestUser("Viktor");

        logger.addFlowStep("User bob = new User(\"Bob\");");
        var bob = new TestUser("Bob");

        logger.addFlowStep("messenger.addUser(marina);");
        messenger.addUser(marina);

        logger.addFlowStep("messenger.addUser(viktor);");
        messenger.addUser(viktor);

        logger.addFlowStep("messenger.addUser(bob);");
        messenger.addUser(bob);

        logger.addFlowStep("messenger.setUserOffline(bob);");
        messenger.setUserOffline(bob);

        logger.addFlowStep("messenger.sendMessageToAllUsers(\"Hello, world!\");");
        messenger.sendMessageToOnlineUsers("Hello, world!");

        var actual = new ArrayList<TestUser>();
        for (var entry : receivers.entrySet()) {
            if (entry.getValue().equals("Hello, world!")) {
                actual.add(entry.getKey());
            }
        }

        var expected = List.of(marina, viktor);

        logger
            .setExpected(Helper.alignList(expected))
            .setActual(Helper.alignList(actual))
            .setIsSuccess(Helper.compareListsIgnoringOrder(actual, expected));
    }

    private void singleExisting(CaseLogger logger) {
        receivers.clear();

        logger.addFlowStep("Messenger messenger = new Messenger();");
        var messenger = new Messenger();

        logger.addFlowStep("User marine = new User(\"Marina\");");
        var marina = new TestUser("Marina");

        logger.addFlowStep("User viktor = new User(\"Viktor\");");
        var viktor = new TestUser("Viktor");

        logger.addFlowStep("messenger.addUser(marina);");
        messenger.addUser(marina);

        logger.addFlowStep("messenger.setUserOffline(marina);");
        messenger.setUserOffline(marina);

        logger.addFlowStep("messenger.addUser(viktor);");
        messenger.addUser(viktor);

        logger.addFlowStep("messenger.sendMessageToUser(\"Hello, world!\", marina);");
        messenger.sendMessageToUser("Hello, world!", marina);

        var actual = new ArrayList<TestUser>();
        for (var entry : receivers.entrySet()) {
            if (entry.getValue().equals("Hello, world!")) {
                actual.add(entry.getKey());
            }
        }

        var expected = List.of(marina);

        logger
            .setExpected(Helper.alignList(expected))
            .setActual(Helper.alignList(actual))
            .setIsSuccess(Helper.compareListsIgnoringOrder(actual, expected));
    }

    private void singleNotExisting(CaseLogger logger) {
        receivers.clear();

        logger.addFlowStep("Messenger messenger = new Messenger();");
        var messenger = new Messenger();

        logger.addFlowStep("User marine = new User(\"Marina\");");
        var marina = new TestUser("Marina");

        logger.addFlowStep("User viktor = new User(\"Viktor\");");
        var viktor = new TestUser("Viktor");

        logger.addFlowStep("messenger.addUser(marina);");
        messenger.addUser(marina);

        logger.addFlowStep("messenger.addUser(viktor);");
        messenger.addUser(viktor);

        logger.addFlowStep("messenger.sendMessageToUser(\"Hello, world!\", viktor);");
        messenger.sendMessageToUser("Hello, world!", viktor);

        var actual = new ArrayList<TestUser>();
        for (var entry : receivers.entrySet()) {
            if (entry.getValue().equals("Hello, world!")) {
                actual.add(entry.getKey());
            }
        }

        List<TestUser> expected = Collections.emptyList();

        logger
            .setExpected(Helper.alignList(expected))
            .setActual(Helper.alignList(actual))
            .setIsSuccess(Helper.compareListsIgnoringOrder(actual, expected));
    }

    private class TestUser extends User {
        public TestUser(String name) {
            super(name);
        }

        @Override
        public void receiveMessage(String message) {
            receivers.put(this, message);
        }
    }
}
