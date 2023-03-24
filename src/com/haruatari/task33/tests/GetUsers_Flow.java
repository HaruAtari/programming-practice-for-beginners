package com.haruatari.task33.tests;

import com.haruatari._src.Helper;
import com.haruatari._src.loggers.CaseLogger;
import com.haruatari._src.tests.CasesBatchTest;
import com.haruatari.task33.Messenger;
import com.haruatari.task33.User;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

public class GetUsers_Flow extends CasesBatchTest {
    public static void main(String[] args) {
        new GetUsers_Flow().run();
    }

    @Override
    protected String getCasesBatchName() {
        return "Get users";
    }

    @Override
    protected CaseLogger.Type getCaseLoggerType() {
        return CaseLogger.Type.CLASS;
    }


    @Override
    protected Map<String, Consumer<CaseLogger>> getCases() {
        return new HashMap<>() {{
            put("Add/remove the same user several times", l -> addDouble(l));
            put("Empty list of users", l -> empty(l));
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

        logger.addFlowStep("messenger.addUser(alice);");
        messenger.addUser(alice);

        logger.addFlowStep("messenger.addUser(alice);");
        messenger.addUser(alice);

        logger.addFlowStep("messenger.removeUser(viktor);");
        messenger.removeUser(viktor);

        logger.addFlowStep("messenger.removeUser(viktor);");
        messenger.removeUser(viktor);

        logger.addFlowStep("messenger.setUserOffline(marina);");
        messenger.setUserOffline(marina);

        logger.addFlowStep("List<User> onlineUsers = messenger.getOnlineUsers();");
        var actualOnline = messenger.getOnlineUsers();

        logger.addFlowStep("List<User> offlineUsers = messenger.getOfflineUsers();");
        var actualOffline = messenger.getOfflineUsers();

        var expectedOnline = List.of(alice, bob);
        var expectedOffline = List.of(marina);

        logger
            .setExpected("\n  onlineUsers: " + Helper.alignList(expectedOnline, true) + "\n  offlineUsers: " + Helper.alignList(expectedOffline, true))
            .setActual("\n  onlineUsers: " + Helper.alignList(actualOnline, true) + "\n  offlineUsers: " + Helper.alignList(actualOffline, true))
            .setIsSuccess(Helper.compareListsIgnoringOrder(actualOffline, expectedOffline) && Helper.compareListsIgnoringOrder(actualOnline, expectedOnline));
    }

    private void empty(CaseLogger logger) {
        logger.addFlowStep("Messenger messenger = new Messenger();");
        var messenger = new Messenger();

        logger.addFlowStep("List<User> onlineUsers = messenger.getOnlineUsers();");
        var actualOnline = messenger.getOnlineUsers();

        logger.addFlowStep("List<User> offlineUsers = messenger.getOfflineUsers();");
        var actualOffline = messenger.getOfflineUsers();

        List<User> expectedOnline = Collections.emptyList();
        List<User> expectedOffline = Collections.emptyList();

        logger
            .setExpected("\n  onlineUsers: " + Helper.alignList(expectedOnline, true) + "\n  offlineUsers: " + Helper.alignList(expectedOffline, true))
            .setActual("\n  onlineUsers: " + Helper.alignList(actualOnline, true) + "\n  offlineUsers: " + Helper.alignList(actualOffline, true))
            .setIsSuccess(Helper.compareListsIgnoringOrder(actualOffline, expectedOffline) && Helper.compareListsIgnoringOrder(actualOnline, expectedOnline));

    }

}
