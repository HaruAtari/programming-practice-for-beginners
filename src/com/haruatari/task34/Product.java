package com.haruatari.task34;

public class Product {
    protected String name;
    protected int price;
    protected int amount;
    private int discount;

    public Product(String name, int price, int discount) {
        this.name = name;
        this.price = price;
        this.discount = discount;
    }

    public String getName() {
        return null;
    }

    public int getPrice() {
        return 0;
    }

    final public int getTotalPrice() {
        int basePrice = getPrice();

        return applyDiscount(basePrice);
    }

    protected int applyDiscount(int basePrice) {
        return basePrice;
    }
}
