## Files structure

Each task is in the separate package (for example `org.haruatari.task10`) and has next files:

- The `Description.md` markdown file with the information about what you need to do to complete the task.
- Other java classes needed to solve the task. Usually it's a `Task` class, but not always. See the task's
  description for the full information.
- The `tests` package which contains some tests to check your solution.

## Tests

Most tasks expect that you will implement a single method. But there are tasks that need you implementing several
methods or even classes (for example `task 8`). Each of them is covered by tests. Each test checks the implemented
method with several different inputs to make sure that your solution works properly with any input data.

Each test class has the `public static void main(String args)` method. So you can use it as the entrypoint to run only
that test.

### Tests for separate methods

The `tests` package contains a test class for each method you should implement. It has the next name:
`<methodName>_Test` (for example `Sort_Test`). When you run it, it prints the next log:

```
====================================================================================================

Method: Point findMiddlePoint(Segment segment)
Case: A horizontal segment

Arguments:
segment: Segment(beginning: Point(x: 10; y: 10) end: Point(x: 20; y: 10))

Result:
Expected: Point(x: 15; y: 10)
Actual: null
Summary: Failed

====================================================================================================

Method: Point findMiddlePoint(Segment segment)
Case: A segment with the zero length

Arguments:
segment: Segment(beginning: Point(x: 0; y: 0) end: Point(x: 0; y: 0))

Result:
Expected: Point(x: 0; y: 0)
Actual: null
Summary: Failed

====================================================================================================

  Success:            0   
  Failed:             6   
  Success percentage: 0%   
```

It contains all necessary information about each case to catch an error if it exists:

* A description of the testing case
* A list of input data
* An expected result
* An actual result returned by your solution

### Tests for the whole task

Each `tests` package contains the `Test` class. It runs all test in that package to check whe whole task. Its output
is almost the same as method's test's but has another summary information, so you can see which of your methods failed.
It also contains the whole information about tested cases.

```
...
====================================================================================================

| Method              | Success | Failed | Success percentage |
| int min(int[] list) | 0       | 8      | 0%                 |
| int max(int[] list) | 0       | 8      | 0%                 |
| Total               | 0       | 16     | 0%                 |
```

### Full tests

Also, you can run all test for all tasks in a row. To do it you should run the `Main` class in the `com.haruatari`
package. It will not show the detailed output, but only the summary:

```
| Task    | Success | Failed | Success percentage |
...
| Task 20 | 3       | 5      | 38%                |
| Task 21 | 0       | 5      | 0%                 |
| Task 22 | 1       | 4      | 20%                |
| Task 23 | 1       | 5      | 17%                |
| Task 24 | 0       | 4      | 0%                 |
| Task 25 | 0       | 7      | 0%                 |
| Total   | 24      | 135    | 15%                |
```

## A list of tasks sorting by difficulty

| Number                              | Name                                                                         | Tags                        |
|-------------------------------------|------------------------------------------------------------------------------|-----------------------------|
| [Task 1](src/com/haruatari/task1)   | Adding and subtracting of two integers                                       |                             |
| [Task 2](src/com/haruatari/task2)   | Searching by value in an array                                               | arrays                      |
| [Task 13](src/com/haruatari/task13) | Counting of the number of occurrences of a value in an array of integers     | arrays                      |
| [Task 10](src/com/haruatari/task10) | Moving the point on the coordinate plane                                     | arrays                      |
| [Task 8](src/com/haruatari/task8)   | Searching for mix and max in an array of integers                            | arrays                      |
| [Task 3](src/com/haruatari/task3)   | Merging arrays of integers                                                   | arrays                      |
| [Task 6](src/com/haruatari/task6)   | Folding of an array of integers                                              | arrays                      |
| [Task 11](src/com/haruatari/task11) | Folding of a two-dimensional array of integers                               | arrays                      |
| [Task 4](src/com/haruatari/task4)   | Sorting of an array of integers                                              | algorithms, arrays          |
| [Task 5](src/com/haruatari/task5)   | Sorting of an array of objects                                               | algorithms, arrays, objects |
| [Task 12](src/com/haruatari/task12) | Summation of values from an array of integers by indexes from another array  | arrays                      |
| [Task 7](src/com/haruatari/task7)   | Zipping of arrays of integers                                                | arrays                      |
| [Task 9](src/com/haruatari/task9)   | Searching for the middle of the segment on the coordinate plane              | objects                     |
| [Task 14](src/com/haruatari/task14) | Calculating of a total price for the shop cart                               | arrays, objects             |
| [Task 15](src/com/haruatari/task15) | Calculating of a total price for the shop cart taking discounts into account | arrays, objects             |
| [Task 19](src/com/haruatari/task19) | Searching in the Double Linked List                                          | objects                     |
| [Task 16](src/com/haruatari/task16) | Searching for the most popular posts on the social network. Part 1           | arrays, objects             |
| [Task 17](src/com/haruatari/task17) | Searching for the most popular posts on the social network. Part 2           | arrays, objects             |
| [Task 18](src/com/haruatari/task18) | Searching for the most popular posts on the social network. Part 3           | arrays, objects             |
| [Task 23](src/com/haruatari/task23) | Merging lists of integers                                                    | collections                 |
| [Task 24](src/com/haruatari/task24) | Folding of a list of integers                                                | collections                 |
| [Task 25](src/com/haruatari/task25) | Folding of a nested list of integers                                         | collections                 |
| [Task 26](src/com/haruatari/task26) | Searching for the intersection of two lists of integers                      | collections                 |
| [Task 27](src/com/haruatari/task27) | Searching for unique values in the list of integers                          | collections                 |
| [Task 28](src/com/haruatari/task28) | Pivot the map                                                                | collections                 |
| [Task 20](src/com/haruatari/task20) | Visiting a restaurant with friends. Part 1                                   | collections, objects        |
| [Task 21](src/com/haruatari/task21) | Visiting a restaurant with friends. Part 2                                   | collections, objects        |
| [Task 22](src/com/haruatari/task22) | Visiting a restaurant with friends. Part 3                                   | collections, objects        |
| [Task 29](src/com/haruatari/task29) | Summarizing of all integers inputted to the object                           | collections, oop            |
