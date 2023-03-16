package com.haruatari.task19;

final class Node {
    public final String value;
    public Node next = null;
    public Node prev = null;

    public Node(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Node(value: " + value + ")";
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Node && this.value.equals(((Node) obj).value);
    }
}
