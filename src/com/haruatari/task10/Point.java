package com.haruatari.task10;

final public class Point {
    public final int x;
    public final int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "Point(x: " + x + "; y: " + y + ")";
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Point)) {
            return false;
        }
        var other = (Point) obj;

        return this.x == other.x && this.y == other.y;
    }
}
