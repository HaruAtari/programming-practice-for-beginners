# Summation of values from an array of integers by indexes from another array

You should implement the `Task.calcilate()` method which takes the next arguments: `int[] values` and `int[] indexes`.
The method should summarize all values from the `values` array which indexes are in the `indexes` array and return the
result.

Pay attention: The `indexes` array can contain indexes not existing in hte `values` array. They should be ignored.

For example, the method takes the next values: `int[] {10, 20, 30}` and `int[] {0, 1, 1, 5}`. So the result will be `50`
because of `values[0] + values[1] + values[1]` and the `values[5]` element doesn't exist, so it's ignored.