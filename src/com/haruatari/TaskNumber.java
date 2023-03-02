package com.haruatari;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public enum TaskNumber {
    TASK_1("task1") {
        @Override
        public BaseTest getTest() {
            return new com.haruatari.task1.Test();
        }
    },
    TASK_2("task2") {
        @Override
        public BaseTest getTest() {
            return new com.haruatari.task2.Test();
        }
    },
    TASK_3("task3") {
        @Override
        public BaseTest getTest() {
            return new com.haruatari.task3.Test();
        }
    },
    TASK_4("task4") {
        @Override
        public BaseTest getTest() {
            return new com.haruatari.task4.Test();
        }
    },
    TASK_5("task5") {
        @Override
        public BaseTest getTest() {
            return new com.haruatari.task5.Test();
        }
    },
    TASK_6("task6") {
        @Override
        public BaseTest getTest() {
            return new com.haruatari.task6.Test();
        }
    },
    TASK_7("task7") {
        @Override
        public BaseTest getTest() {
            return new com.haruatari.task7.Test();
        }
    },
    TASK_8("task8") {
        @Override
        public BaseTest getTest() {
            return new com.haruatari.task8.Test();
        }
    },
    TASK_9("task9") {
        @Override
        public BaseTest getTest() {
            return new com.haruatari.task9.Test();
        }
    };

    private static final Map<String, TaskNumber> MAP;
    private final String name;

    static {
        var map = new HashMap<String, TaskNumber>();
        for (var instance : TaskNumber.values()) {
            map.put(instance.toString().toLowerCase(), instance);
        }
        MAP = Collections.unmodifiableMap(map);
    }

    public static TaskNumber get(String name) {
        return MAP.get(name.toLowerCase());
    }

    TaskNumber(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    public abstract BaseTest getTest();
}
