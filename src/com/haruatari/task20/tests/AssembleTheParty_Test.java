package com.haruatari.task20.tests;

import com.haruatari.Helper;
import com.haruatari._src.loggers.CaseLogger;
import com.haruatari._src.tests.MethodTest;
import com.haruatari.task20.Friend;
import com.haruatari.task20.Task;

import java.util.*;
import java.util.function.Consumer;

public class AssembleTheParty_Test extends MethodTest {
    public static void main(String[] args) {
        new AssembleTheParty_Test().run();
    }

    @Override
    protected String getMethodName() {
        return "List<Friend> assembleTheParty(List<Friend> friends, int bookedSeatsNumber)";
    }

    @Override
    protected Map<String, Consumer<CaseLogger>> getCases() {
        var instance = this;

        return new HashMap<>() {{
            put("No busy friends, the number of seats is equals the number of friends", instance::noBusySeatsEquals);
            put("No busy friends, the number of seats is greater than the number of friends", instance::noBusySeatsGreater);
            put("No busy friends, the number of seats is less than the number of friends", instance::noBusySeatsLess);
            put("No seats", instance::noSeats);
            put("Only one seat", instance::oneSeat);
            put("With busy friends, the number of seats is greater than the number of friends", instance::busySeatsGreater);
            put("With busy friends, the number of seats is less than the number of friends", instance::busySeatsLess);
            put("All friends are busy", instance::allBusy);
        }};
    }

    private void noBusySeatsEquals(CaseLogger logger) {
        var friends = new ArrayList<Friend>() {{
            add(new Friend("Viktor", false));
            add(new Friend("Marina", false));
            add(new Friend("Alice", false));
            add(new Friend("Bob", false));
        }};
        runCase(logger, friends, friends.size(), friends.subList(0, friends.size() - 1));
    }

    private void noBusySeatsGreater(CaseLogger logger) {
        var friends = new ArrayList<Friend>() {{
            add(new Friend("Viktor", false));
            add(new Friend("Marina", false));
            add(new Friend("Alice", false));
            add(new Friend("Bob", false));
        }};
        runCase(logger, friends, friends.size() + 10, friends);
    }

    private void busySeatsGreater(CaseLogger logger) {
        var friends = new ArrayList<Friend>() {{
            add(new Friend("Viktor", false));
            add(new Friend("Marina", false));
            add(new Friend("Julia", true));
            add(new Friend("Alice", false));
            add(new Friend("Bob", true));
        }};
        var expected = new ArrayList<Friend>() {{
            add(new Friend("Viktor", false));
            add(new Friend("Marina", false));
            add(new Friend("Alice", false));
        }};
        runCase(logger, friends, friends.size() + 10, expected);
    }

    private void noBusySeatsLess(CaseLogger logger) {
        var friends = new ArrayList<Friend>() {{
            add(new Friend("Viktor", false));
            add(new Friend("Marina", false));
            add(new Friend("Alice", false));
            add(new Friend("Bob", false));
            add(new Friend("Mark", false));
            add(new Friend("Jorge", false));
        }};
        var seats = friends.size() - 3;
        runCase(logger, friends, seats, friends.subList(0, friends.size() - 4));
    }

    private void busySeatsLess(CaseLogger logger) {
        var friends = new ArrayList<Friend>() {{
            add(new Friend("Viktor", true));
            add(new Friend("Marina", false));
            add(new Friend("Alice", true));
            add(new Friend("Bob", false));
            add(new Friend("Mark", true));
            add(new Friend("Jorge", false));
        }};
        var expected = new ArrayList<Friend>() {{
            add(new Friend("Marina", false));
            add(new Friend("Bob", false));

        }};
        runCase(logger, friends, 3, expected);
    }

    private void noSeats(CaseLogger logger) {
        var friends = new ArrayList<Friend>() {{
            add(new Friend("Viktor", false));
            add(new Friend("Marina", false));
        }};
        runCase(logger, friends, 0, Collections.emptyList());
    }

    private void oneSeat(CaseLogger logger) {
        var friends = new ArrayList<Friend>() {{
            add(new Friend("Viktor", false));
            add(new Friend("Marina", false));
        }};
        runCase(logger, friends, 1, Collections.emptyList());
    }

    private void allBusy(CaseLogger logger) {
        var friends = new ArrayList<Friend>() {{
            add(new Friend("Viktor", true));
            add(new Friend("Marina", true));
            add(new Friend("Alice", true));
            add(new Friend("Bob", true));
        }};
        runCase(logger, friends, friends.size() + 10, Collections.emptyList());
    }

    private void runCase(CaseLogger logger, List<Friend> friends, int seatsNumber, List<Friend> expected) {
        logger
            .setArguments(new HashMap<>() {{
                put("friends", Helper.alignList(friends));
                put("bookedSeatsNumber", String.valueOf(seatsNumber));
            }});

        var actual = new Task().assembleTheParty(friends, seatsNumber);

        logger
            .setExpected(Helper.alignList(expected))
            .setActual(Helper.alignList(actual))
            .setIsSuccess(Objects.equals(expected, actual))
            .hint(actual.size() == expected.size() - 1 ? "Maybe you forgot about the seat for yourself?" : null);
    }
}
