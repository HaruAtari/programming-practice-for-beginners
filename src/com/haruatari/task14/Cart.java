package com.haruatari.task14;

import java.util.Arrays;

final class Cart {
    public final Product[] products;

    public Cart(Product[] products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "Cart(products: " + Arrays.toString(products) + ")";
    }
}
