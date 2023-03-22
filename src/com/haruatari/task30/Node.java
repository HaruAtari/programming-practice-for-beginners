package com.haruatari.task30;

final public class Node {
    public final int number;
    public final String name;
    public final boolean isActive;

    public Node(int number, String name, boolean isActive) {
        this.number = number;
        this.name = name;
        this.isActive = isActive;
    }

    @Override
    public String toString() {
        return "Node(number: " + number + "; name: " + name + "; isActive: " + isActive + ")";
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Node other)) {
            return false;
        }

        return name.equals(other.name) && number == other.number && isActive == other.isActive;
    }
}
