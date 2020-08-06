package org.acme.model;

import com.mongodb.*;

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
}
