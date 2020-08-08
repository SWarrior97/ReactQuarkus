package org.acme.model;

public class Product {
    private int id;
    private String name;
    private float price;
    private int quantity;


    public Product(int id, String name,float price,int quantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity= quantity;
    }


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "{id:"+id+",name:"+name+"}";
    }

    public float getPrice() {
        return price;
    }
}
