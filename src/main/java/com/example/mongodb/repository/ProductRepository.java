package com.example.mongodb.repository;

import com.example.mongodb.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product, String> {

}

/**
 * regular interface ,that will extend MongoRepository<Product, String>
 * (e quindi il modello Product, e il tipo dell'id (una stringa);
 *
 * In questo modo avremo un repository con default methods, tantissimi metodi
 *
 * We can directly inject it as a bean to dependency injection
 * It already comes with predefined methods
 *
 * NOW WE CREATE THE CONTROLLER
 */
