package com.haruatari;

import java.util.Arrays;
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
}
