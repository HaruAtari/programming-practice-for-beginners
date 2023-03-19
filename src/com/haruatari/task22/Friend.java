package com.haruatari.task22;

import java.util.Objects;

public final class Friend {

    public final String name;

    public Friend(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Friend(name: " + name + ")";
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Friend && this.name.equals(((Friend) obj).name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
