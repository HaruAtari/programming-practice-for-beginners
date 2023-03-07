package com.haruatari.task14;

final class Product {
    public final int amount;
    public final int price;
    public final String name;

    public Product(String name, int price, int amount) {
        this.name = name;
        this.price = price;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Product(name: " + name + "; price: " + price + "; amount: " + amount + ")";
    }
}
