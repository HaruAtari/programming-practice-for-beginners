package com.haruatari._src.loader;

import com.haruatari._src.tests.ClassTest;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class TasksLoader {

    public List<Task> loadTasks() {
        return findAllTasks();
    }

    private List<Task> findAllTasks() {
        var result = new ArrayList<Task>();

        var number = 1;
        while (true) {
            var classes = findClassesInPackage("com.haruatari.task" + (number++) + ".tests");
            if (classes == null) {
                if (number <= 20) {
                    continue;
                }
                break;
            }

            for (var classItem : classes) {
                TaskTest annotation = (TaskTest) classItem.getAnnotation(TaskTest.class);

                if (annotation != null) {
                    try {
                        result.add(new Task(
                            (ClassTest) classItem.getDeclaredConstructor().newInstance(),
                            annotation.value()
                        ));
                    } catch (InstantiationException e) {
                        throw new RuntimeException(e);
                    } catch (IllegalAccessException e) {
                        throw new RuntimeException(e);
                    } catch (InvocationTargetException e) {
                        throw new RuntimeException(e);
                    } catch (NoSuchMethodException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }

        return result;
    }

    private Set<Class> findClassesInPackage(String packageName) {
        InputStream stream = ClassLoader
            .getSystemClassLoader()
            .getResourceAsStream(packageName.replaceAll("[.]", "/"));

        if (stream == null) {
            return null;
        }

        BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
        return reader.lines()
            .filter(line -> line.endsWith(".class"))
            .map(line -> getClass(line, packageName))
            .collect(Collectors.toSet());
    }

    private Class getClass(String className, String packageName) {
        try {
            return Class.forName(packageName + "." + className.substring(0, className.lastIndexOf('.')));
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
