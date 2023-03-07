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
    },
    TASK_10("task10") {
        @Override
        public BaseTest getTest() {
            return new com.haruatari.task10.Test();
        }
    },
    TASK_11("task11") {
        @Override
        public BaseTest getTest() {
            return new com.haruatari.task11.Test();
        }
    },
    TASK_12("task12") {
        @Override
        public BaseTest getTest() {
            return new com.haruatari.task12.Test();
        }
    },
    TASK_13("task13") {
        @Override
        public BaseTest getTest() {
            return new com.haruatari.task13.Test();
        }
    },
    TASK_14("task14") {
        @Override
        public BaseTest getTest() {
            return new com.haruatari.task14.Test();
        }
    },
    TASK_15("task15") {
        @Override
        public BaseTest getTest() {
            return new com.haruatari.task15.Test();
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
