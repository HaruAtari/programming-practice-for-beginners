package org.haruatari.task2;

import org.haruatari.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

final public class TaskTest extends BaseTest {
    @DisplayName("findFirst()")
    @ParameterizedTest(name = "findFirst( {0}, {1} )")
    @MethodSource("findFirstProvider")
    public void findFirst(int[] list, int value, int expected) {
        var actual = new Task().findFirst(list, value);
        assertEquals(expected, actual, equalityErrorMessage(String.valueOf(expected), String.valueOf(actual)));
    }

    @DisplayName("findLast()")
    @ParameterizedTest(name = "findLast( {0}, {1} )")
    @MethodSource("findLastProvider")
    public void findLast(int[] list, int value, int expected) {
        var actual = new Task().findLast(list, value);
        assertEquals(expected, actual, equalityErrorMessage(String.valueOf(expected), String.valueOf(actual)));
    }

    private static Stream<Arguments> findFirstProvider() {
        return Stream.of(
                Arguments.of(new int[]{10, 20, 30}, 10, 0),
                Arguments.of(new int[]{10, 20, 30}, 30, 2),
                Arguments.of(new int[]{10, 20, 10}, 10, 0),
                Arguments.of(new int[]{10, 20, 30}, 40, -1),
                Arguments.of(new int[]{}, 10, -1)
        );
    }

    private static Stream<Arguments> findLastProvider() {
        return Stream.of(
                Arguments.of(new int[]{10, 20, 30}, 10, 0),
                Arguments.of(new int[]{10, 20, 30}, 30, 2),
                Arguments.of(new int[]{10, 20, 10}, 10, 2),
                Arguments.of(new int[]{10, 20, 30}, 40, -1),
                Arguments.of(new int[]{}, 10, -1)
        );
    }
}
