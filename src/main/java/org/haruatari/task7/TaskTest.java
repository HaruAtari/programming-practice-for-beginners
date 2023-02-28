package org.haruatari.task7;

import org.haruatari.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

final public class TaskTest extends BaseTest {
    @DisplayName("zip()")
    @ParameterizedTest(name = "zip( {0} {1})")
    @MethodSource("zipProvider")
    public void merge(int[] x, int[] y, int[][] expected) {
        var actual = new Task().zip(x, y);
        assertArrayEquals(expected, actual, equalityErrorMessage(Arrays.deepToString(expected), Arrays.deepToString(actual)));
    }

    private static Stream<Arguments> zipProvider() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 3}, new int[]{10, 20, 30}, new int[][]{{1, 10}, {2, 20}, {3, 30}}),
                Arguments.of(new int[]{1, 1, 1}, new int[]{1, 1, 1}, new int[][]{{1, 1}, {1, 1}, {1, 1}}),
                Arguments.of(new int[]{1, 2, 3}, new int[]{10, 20}, new int[][]{{1, 10}, {2, 20}, {3, -1}}),
                Arguments.of(new int[]{1, 2}, new int[]{}, new int[][]{{1, -1}, {2, -1}}),
                Arguments.of(new int[]{}, new int[]{10, 20}, new int[][]{{-1, 10}, {-1, 20}}),
                Arguments.of(new int[]{}, new int[]{}, new int[][]{})
        );
    }
}
