package org.haruatari.task5;

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
    public void sort(Node[] list, Node[] expected) {
        var initList = list.clone();
        var actual = new Task().sort(list);
        assertArrayEquals(expected, actual, equalityErrorMessage(Arrays.toString(expected), Arrays.toString(actual)));
        assertArrayEquals(initList, list, errorMessage("The input array was changed"));
    }

    private static Stream<Arguments> sortProvider() {
        return Stream.of(
                Arguments.of(
                        new Node[]{new Node(1, 10), new Node(2, 20)},
                        new Node[]{new Node(1, 10), new Node(2, 20)}
                ),
                Arguments.of(
                        new Node[]{new Node(1, 20), new Node(2, 10)},
                        new Node[]{new Node(1, 10), new Node(2, 20)}
                ),
                Arguments.of(
                        new Node[]{new Node(1, 10), new Node(2, 10)},
                        new Node[]{new Node(1, 10), new Node(2, 10)}
                ),
                Arguments.of(
                        new Node[]{new Node(2, 10), new Node(1, 10)},
                        new Node[]{new Node(2, 10), new Node(1, 10)}
                ),
                Arguments.of(
                        new Node[]{new Node(1, 10)},
                        new Node[]{new Node(1, 10)}
                ),
                Arguments.of(
                        new Node[]{},
                        new Node[]{}
                )
        );
    }
}