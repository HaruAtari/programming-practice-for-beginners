package com.haruatari._src;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

abstract public class Helper {

    public static <T> String alignArray(T[] array) {
        return alignArray(array, 0);
    }

    public static <T> String alignArray(T[] array, int level) {
        if (array.length <= 1) {
            return Arrays.deepToString(array);
        }

        return "[\n" + Arrays.stream(array).map(i -> "  ".repeat(level + 1) + i).collect(Collectors.joining(",\n")) + "\n" + " ".repeat(level) + "]";
    }

    public static String alignList(List<?> list) {
        return alignList(list, 0);
    }

    public static String alignList(List<?> list, boolean singleLine) {
        return alignList(list, 0, singleLine);
    }

    public static String alignList(List<?> list, int level) {
        return alignList(list, level, false);
    }

    public static String alignList(List<?> list, int level, boolean singleLine) {
        if (list.size() <= 1 || singleLine) {
            return "List(" +
                list
                    .stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining(", "))
                + ")";
        }

        return "List(\n" +
            list
                .stream()
                .map(i -> "  ".repeat(level + 1) + i)
                .collect(Collectors.joining(",\n"))
            + "\n" + " ".repeat(level) + ")";
    }

    public static String alignMap(Map<?, ?> map) {
        return alignMap(map, 0);
    }

    public static String alignMap(Map<?, ?> map, int level) {
        var result = new StringBuilder("Map(");

        if (map.size() <= 1) {
            for (var item : map.entrySet()) {
                result
                    .append(item.getKey())
                    .append(": ")
                    .append(item.getValue());
            }

            return result
                .append(")")
                .toString();
        }

        for (var item : map.entrySet()) {
            result
                .append("\n")
                .append("  ".repeat(level + 1))
                .append(item.getKey())
                .append(" => ")
                .append(item.getValue());

        }

        return result
            .append("\n)")
            .toString();
    }

    public static <T extends Comparable> boolean compareListsIgnoringOrder(List<T> a, List<T> b) {
        Collections.sort(a);
        Collections.sort(b);

        return a.equals(b);
    }
}
