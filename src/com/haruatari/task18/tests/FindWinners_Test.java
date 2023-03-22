package com.haruatari.task18.tests;

import com.haruatari._src.Helper;
import com.haruatari._src.loggers.CaseLogger;
import com.haruatari._src.tests.CasesBatchTest;
import com.haruatari.task18.Post;
import com.haruatari.task18.Task;
import com.haruatari.task18.User;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

final class FindWinners_Test extends CasesBatchTest {
    public static void main(String[] args) {
        new FindWinners_Test().run();
    }

    @Override
    protected String getCasesBatchName() {
        return "User[] findWinners(Post[] posts)";
    }

    @Override
    protected Map<String, Consumer<CaseLogger>> getCases() {
        var instance = this;
        return new HashMap<>() {{
            put("All users are followers", instance::all);
            put("Not all users are followers", instance::notAll);
        }};
    }

    private void all(CaseLogger logger) {
        testCase(
            logger,
            new Post[]{
                new Post(50, new User("Bob", 30)),
                new Post(75, new User("Marina", 23)),
                new Post(60, new User("Alice", 25)),
            },
            new User[]{
                new User("Marina", 23),
                new User("Bob", 30),
                new User("Alice", 25)
            },
            new User[]{
                new User("Marina", 23),
                new User("Alice", 25),
                new User("Bob", 30)
            }
        );
    }

    private void notAll(CaseLogger logger) {
        testCase(
            logger,
            new Post[]{
                new Post(150, new User("Karen", 50)),
                new Post(200, new User("Stan", 12)),
                new Post(50, new User("Bob", 30)),
                new Post(75, new User("Marina", 23)),
                new Post(60, new User("Alice", 25)),
            },
            new User[]{
                new User("Marina", 23),
                new User("Bob", 30),
                new User("Alice", 25),
                new User("Stan", 12)
            },
            new User[]{
                new User("Marina", 23),
                new User("Alice", 25),
                new User("Bob", 30)
            }
        );
    }

    private void testCase(CaseLogger logger, Post[] posts, User[] followers, User[] expected) {
        var actual = new Task(followers).findWinners(posts);
        logger
            .setArguments(new HashMap<>() {{
                put("Task.followers", Helper.alignArray(followers));
                put("posts", Helper.alignArray(posts));
            }})
            .setExpected(Helper.alignArray(expected))
            .setActual(Helper.alignArray(actual))
            .setIsSuccess(Arrays.equals(actual, expected));
    }
}
