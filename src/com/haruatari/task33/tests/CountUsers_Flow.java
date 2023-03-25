package com.haruatari.task33.tests;

import com.haruatari._src.loggers.CaseLogger;
import com.haruatari._src.tests.CasesBatchTest;
import com.haruatari.task33.Messenger;
import com.haruatari.task33.User;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class CountUsers_Flow extends CasesBatchTest {
    public static void main(String[] args) {
        new CountUsers_Flow().run();
    }

    @Override
    protected String getCasesBatchName() {
        return "Count users";
    }

    @Override
    protected CaseLogger.Type getCaseLoggerType() {
        return CaseLogger.Type.CLASS;
    }


    @Override
    protected Map<String, Consumer<CaseLogger>> getCases() {
        return new HashMap<>() {{
            put("Add/remove the same user several times", l -> addDouble(l));
            put("Set the same user online/offline several times", l -> onlineDefault(l));
            put("An empty list of users", l -> empty(l));
        }};
    }

    private void addDouble(CaseLogger logger) {
        logger.addFlowStep("Messenger messenger = new Messenger();");
        var messenger = new Messenger();

        logger.addFlowStep("User marine = new User(\"Marina\");");
        var marina = new User("Marina");

        logger.addFlowStep("User viktor = new User(\"Viktor\");");
        var viktor = new User("Viktor");

        logger.addFlowStep("User bob = new User(\"Bob\");");
        var bob = new User("Bob");

        logger.addFlowStep("User alice = new User(\"Alice\");");
        var alice = new User("Alice");

        logger.addFlowStep("messenger.addUser(marina);");
        messenger.addUser(marina);

        logger.addFlowStep("messenger.addUser(viktor);");
        messenger.addUser(viktor);

        logger.addFlowStep("messenger.addUser(bob);");
        messenger.addUser(bob);

        logger.addFlowStep("messenger.removeUser(viktor);");
        messenger.removeUser(viktor);

        logger.addFlowStep("messenger.removeUser(viktor);");
        messenger.removeUser(viktor);

        logger.addFlowStep("messenger.addUser(alice);");
        messenger.addUser(alice);

        logger.addFlowStep("messenger.addUser(alice);");
        messenger.addUser(alice);

        logger.addFlowStep("int countAll = messenger.countAllUsers();");
        var actualAll = messenger.countAllUsers();

        logger.addFlowStep("int countOnline = messenger.countOnlineUsers();");
        var actualOnline = messenger.countOnlineUsers();

        var expectedAll = 3;
        var expectedOnline = 3;

        logger
            .setExpected(new HashMap<>(){{
                put("countAll",String.valueOf(expectedAll));
                put("countOnline",String.valueOf(expectedOnline));
            }})
            .setActual(new HashMap<>(){{
                put("countAll",String.valueOf(actualAll));
                put("countOnline",String.valueOf(actualOnline));
            }})
            .setIsSuccess(expectedAll == actualAll && expectedOnline == actualOnline);
    }

    private void onlineDefault(CaseLogger logger) {
        logger.addFlowStep("Messenger messenger = new Messenger();");
        var messenger = new Messenger();

        logger.addFlowStep("User marine = new User(\"Marina\");");
        var marina = new User("Marina");

        logger.addFlowStep("User viktor = new User(\"Viktor\");");
        var viktor = new User("Viktor");

        logger.addFlowStep("User bob = new User(\"Bob\");");
        var bob = new User("Bob");

        logger.addFlowStep("User alice = new User(\"Alice\");");
        var alice = new User("Alice");

        logger.addFlowStep("messenger.addUser(marina);");
        messenger.addUser(marina);

        logger.addFlowStep("messenger.addUser(viktor);");
        messenger.addUser(viktor);

        logger.addFlowStep("messenger.addUser(bob);");
        messenger.addUser(bob);

        logger.addFlowStep("messenger.setUserOffline(marina);");
        messenger.setUserOffline(marina);

        logger.addFlowStep("messenger.setUserOnline(marina);");
        messenger.setUserOnline(marina);

        logger.addFlowStep("messenger.setUserOffline(bob);");
        messenger.setUserOffline(bob);

        logger.addFlowStep("messenger.setUserOnline(alice);");
        messenger.setUserOnline(alice);

        logger.addFlowStep("int countAll = messenger.countAllUsers();");
        var actualAll = messenger.countAllUsers();

        logger.addFlowStep("int countOnline = messenger.countOnlineUsers();");
        var actualOnline = messenger.countOnlineUsers();

        var expectedAll = 3;
        var expectedOnline = 2;

        logger
            .setExpected(new HashMap<>(){{
                put("countAll",String.valueOf(expectedAll));
                put("countOnline",String.valueOf(expectedOnline));
            }})
            .setActual(new HashMap<>(){{
                put("countAll",String.valueOf(actualAll));
                put("countOnline",String.valueOf(actualOnline));
            }})
            .setIsSuccess(expectedAll == actualAll && expectedOnline == actualOnline);
    }

    private void empty(CaseLogger logger) {
        logger.addFlowStep("Messenger messenger = new Messenger();");
        var messenger = new Messenger();

        logger.addFlowStep("int countAll = messenger.countAllUsers();");
        var actualAll = messenger.countAllUsers();

        logger.addFlowStep("int countOnline = messenger.countOnlineUsers();");
        var actualOnline = messenger.countOnlineUsers();

        var expectedAll = 0;
        var expectedOnline = 0;

        logger
            .setExpected(new HashMap<>(){{
                put("countAll",String.valueOf(expectedAll));
                put("countOnline",String.valueOf(expectedOnline));
            }})
            .setActual(new HashMap<>(){{
                put("countAll",String.valueOf(actualAll));
                put("countOnline",String.valueOf(actualOnline));
            }})
            .setIsSuccess(expectedAll == actualAll && expectedOnline == actualOnline);
    }
}
