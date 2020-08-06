package org.acme.model;

import java.util.ArrayList;
import java.util.List;

public class ShoppingList {
    private int id;
    private List<Product> products;
    private int price;

    public ShoppingList(int id, int price) {
        this.id = id;
        this.price = price;
        products = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public List<Product> getProducts() {
        return products;
    }

    public int getPrice() {
        return price;
    }
}
