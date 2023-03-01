package com.haruatari.task5;

final public class Node {
    public final int number;
    public final int id;

    public Node(int id, int number) {
        this.id = id;
        this.number = number;
    }

    @Override
    public String toString() {
        return "Node(id: " + id + "; number: " + number + ")";
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Node && this.id == ((Node) obj).id;
    }
}
