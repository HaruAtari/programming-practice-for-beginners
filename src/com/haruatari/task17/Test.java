package com.haruatari.task17;

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
        testCase(
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
        testCase(
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

        showTotalResult();
    }

    private void testCase(Post[] posts, User[] expected) {
        var actual = new Task().findWinner(posts);
        var isSuccess = actual == expected;

        logCase(
                "User[] findWinner(Post[] posts)",
                new HashMap<>() {{
                    put("posts", Helper.alignArray(posts));
                }},
                Helper.alignArray(expected),
                Helper.alignArray(actual),
                isSuccess
        );
    }
}
