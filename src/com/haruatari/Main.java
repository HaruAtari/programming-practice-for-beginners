package com.haruatari;

public class Main {
    public static void main(String[] args) {
        if (args.length >= 2 && args[0].equals("test")) {
            runTest(args[1]);
            return;
        }

        System.out.println("See the README.md file in the root of the repository for a list of tasks and other instructions");
    }

    private static void runTest(String name) {
        var taskNumber = TaskNumber.get(name);
        if (taskNumber == null) {
            System.out.println("A task with the specified name wasn't found");
            return;
        }

        taskNumber.getTest().run();
    }
}