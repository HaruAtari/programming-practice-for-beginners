package com.haruatari.task20;

final class Node {
    public final String value;
    public Node next = null;

    public Node(String value) {
        this.value = value;
    }

    public Node(String value, Node nextNode) {
        this.value = value;
        this.next = nextNode;
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
