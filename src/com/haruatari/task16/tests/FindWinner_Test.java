package com.haruatari.task16.tests;

import com.haruatari._src.Helper;
import com.haruatari._src.loggers.CaseLogger;
import com.haruatari._src.tests.CasesBatchTest;
import com.haruatari.task16.Post;
import com.haruatari.task16.Task;
import com.haruatari.task16.User;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.Consumer;

final class FindWinner_Test extends CasesBatchTest {
    public static void main(String[] args) {
        new FindWinner_Test().run();
    }

    @Override
    protected String getCasesBatchName() {
        return "User findWinner(Post[] posts)";
    }

    @Override
    protected Map<String, Consumer<CaseLogger>> getCases() {
        var instance = this;

        return new HashMap<>() {{
            put("All users are acceptable", instance::all);
            put("There are several unacceptable users and posts", instance::notAll);
            put("An empty list of posts", instance::empty);
            put("An one-element list which contains an unacceptable post", instance::oneBad);
            put("An one-element list which contains an acceptable post", instance::oneBad);
        }};
    }

    private void all(CaseLogger logger) {
        var posts = new Post[]{
            new Post(100, 15, new User("Viktor", 31, true)),
            new Post(150, 11, new User("Jorge", 22, true)),
            new Post(200, 11, new User("Kate", 18, false)),
            new Post(50, 100, new User("Bob", 30, true)),
            new Post(175, 100, new User("Marina", 23, true)),
            new Post(60, 100, new User("Alice", 25, true)),
        };
        runCase(logger, posts, new User("Marina", 23, true));
    }

    private void notAll(CaseLogger logger) {
        var posts = new Post[]{
            new Post(100, 10, new User("Viktor", 18, true)),
            new Post(150, 11, new User("Jorge", 17, true)),
            new Post(200, 11, new User("Kate", 18, false)),
            new Post(50, 100, new User("Bob", 30, true)),
            new Post(75, 100, new User("Marina", 23, true)),
            new Post(60, 100, new User("Alice", 25, true)),
        };
        runCase(logger, posts, new User("Marina", 23, true));
    }

    private void empty(CaseLogger logger) {
        runCase(logger, new Post[]{}, null);
    }

    private void oneBad(CaseLogger logger) {
        var posts = new Post[]{
            new Post(100, 0, new User("Viktor", 10, false)),
        };
        runCase(logger, posts, null);
    }

    private void oneGood(CaseLogger logger) {
        var posts = new Post[]{
            new Post(100, 100, new User("Viktor", 50, true)),
        };
        runCase(logger, posts, new User("Viktor", 50, true));
    }

    private void runCase(CaseLogger logger, Post[] posts, User expected) {
        var actual = new Task().findWinner(posts);
        logger
            .setArguments(new HashMap<>() {{
                put("posts", Helper.alignArray(posts));
            }})
            .setExpected(String.valueOf(expected))
            .setActual(String.valueOf(actual))
            .setIsSuccess(Objects.equals(actual, expected));
    }
}
