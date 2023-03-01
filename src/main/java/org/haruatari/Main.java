package org.haruatari;


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
            case "task1" -> new org.haruatari.task1.Test().run();
//            case "task2" -> new org.haruatari.task2.Test().run();
            default -> System.out.println("Undefined task!");
        }
    }
}