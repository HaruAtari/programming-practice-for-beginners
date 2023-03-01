package com.haruatari;

public class Main {
    public static void main(String[] args) {
        if (args.length > 2 && args[0].equals("test")) {
            runTest(args[1]);
            return;
        }

        System.out.println("See a README.md file in the root of the repository for a list of tasks and an instruction");
    }

    private static void runTest(String taskName) {
        switch (taskName) {
            case "task1" -> new com.haruatari.task1.Test().run();
            case "task2" -> new com.haruatari.task2.Test().run();
            case "task3" -> new com.haruatari.task3.Test().run();
            case "task4" -> new com.haruatari.task4.Test().run();
            case "task5" -> new com.haruatari.task5.Test().run();
            case "task6" -> new com.haruatari.task6.Test().run();
            case "task7" -> new com.haruatari.task7.Test().run();
            default -> System.out.println("Undefined task!");
        }
    }
}