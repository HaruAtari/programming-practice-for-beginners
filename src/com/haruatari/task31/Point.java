package com.haruatari.task31;

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
}
