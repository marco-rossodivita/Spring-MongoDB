package com.example.mongodb.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("products")
public class Product {

    @Id
    private String id;
    private String name;
    private String description;

    public Product() {
    }

    public Product(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}






/**
 * We can specify how we want the documents to be called
 * in this case, we want the documents to be named "products";
 *
 * now we give some properties to the product: the main important one
 * is the @Id of the product,an annotation on top of the id;
 *
 * we build the constructor (EXCEPT THE ID) and the getters/setters;
 *
 * WE HAVE OUR MODEL NOW! This is going to represent a product in the db
 *
 * The next thing is to create a REPOSITORY that is going to work with this model
 */