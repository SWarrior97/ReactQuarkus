package org.acme.model;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String name;
    private List<ShoppingList> shoppingLists;
    private String email;
    private String password;
    private String role;


    public User(int id, String name, String email, String password,String role) {
        this.name = name;
        this.email = email;
        //this.password = password;
        this.shoppingLists = new ArrayList<>();
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public void addShoppingList(ShoppingList sl){
        shoppingLists.add(sl);
    }
    public void removeShoppingList(ShoppingList sl){
        shoppingLists.remove(sl);
    }

    public List<ShoppingList> getShoppingLists() {
        return shoppingLists;
    }

    public String getRole() {
        return role;
    }

    public void updateRole(String role){
        this.role = role;
    }
}
