package com.haruatari.task18;

import com.haruatari.BaseTest;
import com.haruatari.Helper;
import com.haruatari.TaskNumber;

import java.util.Arrays;
import java.util.HashMap;

final public class Test extends BaseTest {
    public static void main(String[] args) {
        new Test().run();
    }

    @Override
    public TaskNumber getNumber() {
        return TaskNumber.TASK_18;
    }

    @Override
    public void run() {
        testCase(
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
        testCase(
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

        showTotalResult();
    }

    private void testCase(Post[] posts, User[] followers, User[] expected) {
        var actual = new Task(followers).findWinners(posts);
        var isSuccess = Arrays.equals(actual, expected);

        logCase(
                "User[] findWinners(Post[] posts)",
                new HashMap<>() {{
                    put("Task.followers", Helper.alignArray(followers));
                    put("posts", Helper.alignArray(posts));
                }},
                Helper.alignArray(expected),
                Helper.alignArray(actual),
                isSuccess
        );
    }
}
