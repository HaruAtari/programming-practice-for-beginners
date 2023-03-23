# Calculating the total length of the broken line on the coordinate plane

You have the `Calculator` class which should provide two methods for calculating the total length of the broken line.
The class has two methods:

* `void Calculator.addPoint(Point point)` which take the next point of the line.
* `double Calculator.calculateLength()` which calculate the total length of the line and return it.

The line starts from the first taken point, follow the second point, ... to the next taken point. The class should
calculate the total length of all segments and return their sum.

* If less than two points were provided, the `calculateLength` methods should return `0`.
* Each point is an instance of the `Point` class which has the `int x` and `int y` fields.
* The result is checked to 3 decimal digit.
* Each instance of the `Calculator` class should store and change its own values and don't share it with other
  instances (do not use static properties).