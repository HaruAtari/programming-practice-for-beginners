package com.haruatari.task22;

import java.util.Objects;

public final class Dish {
    public final String name;

    public Dish(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Dish(name: " + name + ")";
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Dish && this.name.equals(((Dish) obj).name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
