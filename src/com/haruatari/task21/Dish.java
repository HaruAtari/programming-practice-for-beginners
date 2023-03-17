package com.haruatari.task21;

import java.util.Objects;

public final class Dish {
    public final String name;
    public final int price;

    public Dish(String name, int price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Dish(name: " + name + "; price: " + price + ")";
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
