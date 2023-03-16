package com.haruatari.task17.tests;

import com.haruatari.Helper;
import com.haruatari._src.loggers.CaseLogger;
import com.haruatari._src.tests.MethodTest;
import com.haruatari.task17.Post;
import com.haruatari.task17.Task;
import com.haruatari.task17.User;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

final class FindWinners_Test extends MethodTest {
    public static void main(String[] args) {
        new FindWinners_Test().run();
    }

    @Override
    protected String getMethodName() {
        return "User[] findWinners(Post[] posts)";
    }

    @Override
    protected Map<String, Consumer<CaseLogger>> getCases() {
        var instance = this;

        return new HashMap<>() {{
            put("All users are acceptable", instance::all);
            put("Unacceptable users has more likes than acceptable", instance::unacceptableMoreThanAcceptable);
            put("Unacceptable users has less likes than acceptable", instance::unacceptableLessThanAcceptable);
        }};
    }

    private void all(CaseLogger logger) {
        runCase(
                logger,
                new Post[]{
                        new Post(50, new User("Bob", 30, true)),
                        new Post(75, new User("Marina", 23, true)),
                        new Post(60, new User("Alice", 25, true)),
                },
                new User[]{
                        new User("Marina", 23, true),
                        new User("Alice", 25, true),
                        new User("Bob", 30, true)
                }
        );
    }

    private void unacceptableMoreThanAcceptable(CaseLogger logger) {
        runCase(
                logger,
                new Post[]{
                        new Post(100, new User("Viktor", 17, true)),
                        new Post(200, new User("Kate", 18, false)),
                        new Post(25, new User("Jorge", 30, true)),
                        new Post(50, new User("Bob", 30, true)),
                        new Post(75, new User("Marina", 23, true)),
                        new Post(60, new User("Alice", 25, true)),
                },
                new User[]{
                        new User("Marina", 23, true),
                        new User("Alice", 25, true),
                        new User("Bob", 30, true)
                }
        );
    }

    private void unacceptableLessThanAcceptable(CaseLogger logger) {
        runCase(
                logger,
                new Post[]{
                        new Post(10, new User("Viktor", 31, true)),
                        new Post(15, new User("Kate", 18, true)),
                        new Post(25, new User("Jorge", 30, true)),
                        new Post(50, new User("Bob", 30, true)),
                        new Post(75, new User("Marina", 23, true)),
                        new Post(60, new User("Alice", 25, true)),
                },
                new User[]{
                        new User("Marina", 23, true),
                        new User("Alice", 25, true),
                        new User("Bob", 30, true)
                }
        );
    }

    private void runCase(CaseLogger logger, Post[] posts, User[] expected) {
        var actual = new Task().findWinners(posts);
        logger
                .setArguments(new HashMap<>() {{
                    put("posts", Helper.alignArray(posts));
                }})
                .setExpected(Helper.alignArray(expected))
                .setActual(Helper.alignArray(actual))
                .setIsSuccess(Arrays.equals(actual, expected));
    }
}
