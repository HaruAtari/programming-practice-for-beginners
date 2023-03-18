package com.haruatari.task14;

import com.haruatari._src.Helper;

final public class Cart {
    public final Product[] products;

    public Cart(Product[] products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "Cart(\n  products: " + Helper.alignArray(products, 1) + "\n)";
    }
}
