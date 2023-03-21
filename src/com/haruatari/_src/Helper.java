package com.haruatari._src;

import java.util.*;
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

    public static String alignMap(Map<?, ?> map, boolean singleLine) {
        return alignMap(map, 0, singleLine);
    }

    public static String alignMap(Map<?, ?> map, int level) {
        return alignMap(map, level, false);
    }

    public static String alignMap(Map<?, ?> map, int level, boolean singleLine) {

        if (map.size() <= 1 || singleLine) {
            var result = new ArrayList<String>();

            for (var item : map.entrySet()) {
                result.add(item.getKey() + ": " + item.getValue());
            }

            return "Map(" +
                result
                    .stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining("; ")) +
                ")";
        }

        var result = new StringBuilder("Map(");

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
        var mutableA = new ArrayList<>(a);
        var mutableB = new ArrayList<>(b);
        Collections.sort(mutableA);
        Collections.sort(mutableB);

        return mutableA.equals(mutableB);
    }
}
