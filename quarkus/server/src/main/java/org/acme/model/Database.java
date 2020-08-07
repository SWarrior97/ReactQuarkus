package org.acme.model;

import com.mongodb.*;

import java.util.List;

public class Database {
    private MongoClient mongoClient;
    DB database;


    public Database() {
        mongoClient = new MongoClient(new MongoClientURI("mongodb://localhost:27017"));
        database = mongoClient.getDB("shoppingList");
    }

    public void insertProduct(Product p){
        DBCollection collection = database.getCollection("product");

        DBObject product = new BasicDBObject("_id", p.getId())
                .append("name", p.getName());

        collection.insert(product);
    }

    public Product getProductByID(int id) {
        DBCollection collection = database.getCollection("product");
        DBObject query = new BasicDBObject("_id", id);
        DBCursor cursor = collection.find(query);

        DBObject object = cursor.one();

        Product p = new Product((int)object.get("_id"),(String)object.get("name"));

        return p;
    }

    public User verifyUserExist(String email) {
        DBCollection collection = database.getCollection("user");
        DBObject query = new BasicDBObject("email", email);
        DBCursor cursor = collection.find(query);

        DBObject object = cursor.one();

        if(object == null){
            return null;
        }


        User user = new User((String)object.get("name"),(String)object.get("email"),(String)object.get("password"),(String)object.get("role"));
        user.setShoppingLists((List<ShoppingList>) object.get("shoppingLists"));

        return user;
    }

    public User createUser(String name, String email, String hashPassword, String role) {
        DBCollection collection = database.getCollection("user");

        User user = new User(name,email,hashPassword,role);

        DBObject product = new BasicDBObject("email", user.getEmail())
                .append("name", user.getName())
                .append("password",user.getPassword())
                .append("role",user.getRole())
                .append("shoppingLists",user.getShoppingLists());

        collection.insert(product);

        return user;
    }
}
