package org.haruatari.task5;

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
}
