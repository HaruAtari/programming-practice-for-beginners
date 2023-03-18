package com.haruatari.task15;

final public class Discount {
    public final int discount;
    public final String productName;

    public Discount(String productName, int discount) {
        this.productName = productName;
        this.discount = discount;
    }

    @Override
    public String toString() {
        return "Discount(productName: " + productName + "; discount: " + discount + ")";
    }
}
