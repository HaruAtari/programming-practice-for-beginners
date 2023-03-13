package com.haruatari.task16;

import com.haruatari.BaseTest;
import com.haruatari.Helper;
import com.haruatari.TaskNumber;

import java.util.HashMap;

final public class Test extends BaseTest {
    public static void main(String[] args) {
        new Test().run();
    }

    @Override
    public TaskNumber getNumber() {
        return TaskNumber.TASK_16;
    }

    @Override
    public void run() {
        testCase(
                new Post[]{
                        new Post(100, 10, new User("Viktor", 18, true)),
                        new Post(150, 11, new User("Jorge", 17, true)),
                        new Post(200, 11, new User("Kate", 18, false)),
                        new Post(50, 100, new User("Bob", 30, true)),
                        new Post(75, 100, new User("Marina", 23, true)),
                        new Post(60, 100, new User("Alice", 25, true)),
                },
                new User("Marina", 23, true)
        );
        testCase(
                new Post[]{
                        new Post(10, 20, new User("Viktor", 31, true)),
                        new Post(10, 21, new User("Marina", 23, true)),
                        new Post(10, 22, new User("Alice", 10, false)),
                },
                new User("Marina", 23, true)
        );
        testCase(
                new Post[]{new Post(100, 10, new User("Viktor", 18, true))},
                null
        );
        testCase(
                new Post[]{},
                null
        );

        showTotalResult();
    }

    private void testCase(Post[] posts, User expected) {
        var actual = new Task().findWinner(posts);
        var isSuccess = actual == expected;

        logCase(
                "User findWinner(Post[] posts)",
                new HashMap<>() {{
                    put("posts", Helper.alignArray(posts));
                }},
                String.valueOf(expected),
                String.valueOf(actual),
                isSuccess
        );
    }
}
