package org.haruatari.task3;

import org.haruatari.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class TaskTest extends BaseTest {
    @DisplayName("merge()")
    @ParameterizedTest(name = "merge( {0}, {1} )")
    @MethodSource("mergeProvider")
    public void merge(int[] x, int[] y, int[] expected) {
        var actual = new Task().merge(x,y);
        assertArrayEquals(expected, actual, errorMessage(Arrays.toString(expected),Arrays.toString(actual)));
    }

    private static Stream<Arguments> mergeProvider() {
        return Stream.of(
                Arguments.of(new int[]{10, 20}, new int[]{30, 40}, new int[]{10, 20, 30, 40}),
                Arguments.of(new int[]{30, 40}, new int[]{10, 20}, new int[]{30, 40, 10, 20}),
                Arguments.of(new int[]{10}, new int[]{10}, new int[]{10, 10}),
                Arguments.of(new int[]{}, new int[]{10}, new int[]{10}),
                Arguments.of(new int[]{10}, new int[]{}, new int[]{10}),
                Arguments.of(new int[]{}, new int[]{}, new int[]{})
        );
    }
}
