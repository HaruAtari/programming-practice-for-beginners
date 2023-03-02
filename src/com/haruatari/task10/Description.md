# Moving the point on the coordinate plane

You should implement the `Task.movePoint()` method which takes the next arguments: `Point pont` and `String[] commands`.
The `point` contains the initial coordinates where all transformations should start from. The `commands` array contain a
list of point's coordinates transformations. The method should apply all transformation from the `commands` array to the
`point`'s coordinates.

The `command` array can contain the next values:

* `up` - it means that the point should be moved up by `1` (the `y` coordination should be increased by `1`)
* `right` - it means that the point should be moved right by `1` (the `x` coordination should be increased by `1`)
* `down` - it means that the point should be moved down by `1` (the `y` coordination should be decreased by `1`)
* `left` - it means that the point should be moved left by `1` (the `x` coordination should be decreased by `1`)

Pay attention: The method should return a new point, not modify the input one.

For example, the method takes the next value: `Point(x: 10, y: 10)` and `new String[] {"up", "up", right", "down"}`. So
the result will be `Point(x: 11, y: 11)` because:

* `x: 10, y: 10` the initial values.
* Apply the "up" command and the coordinates become `x: 10, y: 11`.
* Apply the "up" command and the coordinates become `x: 10, y: 12`.
* Apply the "right" command and the coordinates become `x: 11, y: 12`.
* Apply the "down" command and the coordinates become `x: 11, y: 11`.