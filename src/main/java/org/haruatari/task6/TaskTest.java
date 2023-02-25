package org.haruatari.task6;

import org.haruatari.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

final public class TaskTest extends BaseTest {
    @DisplayName("fold()")
    @ParameterizedTest(name = "fold( {0} )")
    @MethodSource("foldProvider")
    public void merge(int[] list, int expected) {
        var actual = new Task().fold(list);
        assertEquals(expected, actual, equalityErrorMessage(String.valueOf(expected), String.valueOf(actual)));
    }

    private static Stream<Arguments> foldProvider() {
        return Stream.of(
                Arguments.of(new int[]{10, 20, 30}, 60),
                Arguments.of(new int[]{-10, -20, -30}, -60),
                Arguments.of(new int[]{10}, 10),
                Arguments.of(new int[]{}, 0)
        );
    }
}
