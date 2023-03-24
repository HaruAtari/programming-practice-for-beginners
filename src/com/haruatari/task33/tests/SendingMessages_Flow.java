package com.haruatari.task33.tests;

import com.haruatari._src.Helper;
import com.haruatari._src.loggers.CaseLogger;
import com.haruatari._src.tests.CasesBatchTest;
import com.haruatari.task33.Messenger;
import com.haruatari.task33.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
        messenger.sendMessageToAllUsers("Hello, words!");

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

    private class TestUser extends User {
        public TestUser(String name) {
            super(name);
        }

        @Override
        public void receiveMessage(String message) {
            super.receiveMessage(message);
            receivers.put(this, message);
        }
    }
}
