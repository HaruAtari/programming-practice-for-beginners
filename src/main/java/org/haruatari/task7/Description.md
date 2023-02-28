# Zipping of arrays of integers

You should implement the `Task.zip()` method which takes two arrays of integers: `int[] x` and `int[] y`. It should
return a two-dimensional array of integers which contains merged elements from the input arrays. It means that the
first element in the result should contain the first element from the `x` array and the first element from the `y`
element; the second element in the result should contain the second element from the `x` array and the second element
from the `y` element.  
Pay attention: Input arrays can have different lengths. The result should have the same length as the longest of
them. In this case you should use `-1` instead of not existing elements in the other input array

For example the `x` argument contains the `int[] {1, 2, 3}` array and the `y` argument contains the `int[] {10, 20,
30, 40}` array; So the result will be:

```java
int[][]{
    {1,10}, // x[0] and y[0]
    {2,20}, // x[1] and y[1]
    {3,30}, // x[2] and y[2]
    {-1,40}, // -1 because x[3] doesn't exist and y[3]
}
```
