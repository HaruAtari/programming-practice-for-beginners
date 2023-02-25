package org.haruatari.task4;

import org.haruatari.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class TaskTest extends BaseTest {
    @DisplayName("sort()")
    @ParameterizedTest(name = "sort( {0} )")
    @MethodSource("sortProvider")
    public void sort(int[] list, int[] expected) {
        var initList = list.clone();
        var actual = new Task().sort(list);
        assertArrayEquals(expected, actual, equalityErrorMessage(Arrays.toString(expected), Arrays.toString(actual)));
        assertArrayEquals(initList, list, errorMessage("The input array was changed"));
    }

    private static Stream<Arguments> sortProvider() {
        return Stream.of(
                Arguments.of(new int[]{10, 20, 30}, new int[]{10, 20, 30}),
                Arguments.of(new int[]{30, 20, 10}, new int[]{30, 20, 10}),
                Arguments.of(new int[]{40, 40, 40}, new int[]{40, 40, 40}),
                Arguments.of(new int[]{10, 20, 10}, new int[]{10, 10, 20}),
                Arguments.of(new int[]{10, 10, 10}, new int[]{10, 10, 10}),
                Arguments.of(new int[]{10}, new int[]{10}),
                Arguments.of(new int[]{}, new int[]{})
        );
    }
}
