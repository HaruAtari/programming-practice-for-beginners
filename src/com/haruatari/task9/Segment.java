package com.haruatari.task9;

final public class Segment {
    public final Point beginning;
    public final Point end;

    public Segment(Point beginning, Point end) {
        this.beginning = beginning;
        this.end = end;
    }

    @Override
    public String toString() {
        return "Segment(beginning: " + beginning + " end: " + end + ")";
    }
}
