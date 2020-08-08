package org.acme.model;

import java.util.ArrayList;
import java.util.List;

public class ShoppingList {
    private int id;
    private String name;
    private List<Product> products;
    private int price;

    public ShoppingList(int id, int price,String name) {
        this.id = id;
        this.price = price;
        this.name = name;
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

    public String getName() {
        return name;
    }
}
