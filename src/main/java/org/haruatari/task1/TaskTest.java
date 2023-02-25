package org.haruatari.task1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TaskTest {
    @DisplayName("sum()")
    @ParameterizedTest(name = "{0} + {1} = {2}")
    @MethodSource("sumProvider")
    public void sum(int x, int y, int expected) {
        assertEquals(expected, new Task().sum(x, y));
    }
    @DisplayName("sub()")
    @ParameterizedTest(name = "{0} - {1} = {2}")
    @MethodSource("subProvider")
    public void sub(int x, int y, int expected) {
        assertEquals(expected, new Task().sum(x, y));
    }

    private static Stream<Arguments> sumProvider() {
        return Stream.of(
                Arguments.of(0, 0, 0),
                Arguments.of(1, 2, 3),
                Arguments.of(-1, -2, -3)
        );
    }

    private static Stream<Arguments> subProvider() {
        return Stream.of(
                Arguments.of(0, 0, 0),
                Arguments.of(3,2,1),
                Arguments.of(-3,-2,-1)
        );
    }
}
