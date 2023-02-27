package org.haruatari.task4;

import org.haruatari.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

final public class TaskTest extends BaseTest {
    @DisplayName("sort()")
    @ParameterizedTest(name = "sort( {0} )")
    @MethodSource("sortProvider")
    public void sort(int[] list, int[] expected) {
        new Task().sort(list);
        assertArrayEquals(expected, list, equalityErrorMessage(Arrays.toString(expected), Arrays.toString(list)));
    }

    private static Stream<Arguments> sortProvider() {
        return Stream.of(
                Arguments.of(new int[]{10, 20, 30}, new int[]{10, 20, 30}),
                Arguments.of(new int[]{30, 20, 10}, new int[]{10, 20, 30}),
                Arguments.of(new int[]{10, 20, 10}, new int[]{10, 10, 20}),
                Arguments.of(new int[]{10, 10, 10}, new int[]{10, 10, 10}),
                Arguments.of(new int[]{10}, new int[]{10}),
                Arguments.of(new int[]{}, new int[]{})
        );
    }
}
