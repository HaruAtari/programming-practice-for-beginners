# Searching for the center of the segment on the coordinate plane

You should implement the `Task.findMiddlePoint()` method which takes a `Segment segment` argument. This object
represents a segment on the coordinate plane. It has two fields (`beginning` and `end`) that represents coordinates
of the segment's edges. Each coordinate is represented by an object of the `Point` class. These objects contain `x` and
`y` fields with appropriate coordinates. The method should calculate the point which lays in the very middle of the
input segment and return it as a `Point` object.

The formula for finding the middle:  
The segment's edges: `[X1; Y1]` and `[X2; Y2]`  
The middle point: `[(X1 + X2) / 2, (Y1 + Y2) /2]`