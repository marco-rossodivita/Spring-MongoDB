package com.example.mongodb.controller;

import com.example.mongodb.model.Product;
import com.example.mongodb.repository.ProductRepository;
import com.example.mongodb.resource.ProductRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ProductController {

    private final ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping("/product")
    public ResponseEntity<List<Product>> getAllProducts(){
        return ResponseEntity.ok(this.productRepository.findAll());
    } //it returns all the products

    @PostMapping("/product")
    public ResponseEntity<Product> createProduct(@RequestBody ProductRequest productRequest){
        Product product = new Product();
        product.setName(productRequest.getName());
        product.setDescription(productRequest.getDescription());
        /**
         * we're creating a new product, we're setting the name to the one
         * from the request, same for the description;
         * we're saving this product to the DB and returning it back to the user
         */
        return ResponseEntity.status(201).body(this.productRepository.save(product));
        /**
         * So it's gonna call the save method, it's gonna save
         * this product that we sended in the request body
         * and it's gonna return the save product in response
         */
    }
    /**
     * It creates a product.
     * We probabably wanna send it in a POST request;
     * so we probably wanna ssend it in the request body
     * of the HTTP message;
     * I'm going to be recieving a product.
     *
     * FOR POST WE'RE GONNA CHOSE RAW AND JSON ON POSTMAN
     */


    @GetMapping("/product/{id}") //path variable
    public ResponseEntity getAllProductById(@PathVariable String id){

        Optional<Product> product = this.productRepository.findById(id);
        if(product.isPresent()){
            return ResponseEntity.ok(product.get());
        } else{
            return ResponseEntity.ok("The product with id: " + id + " was not found.");
        }

    }

    @DeleteMapping("/product/{id}")
    public ResponseEntity deleteProductById(@PathVariable String id){

        Optional<Product> product = this.productRepository.findById(id);

        if(product.isPresent()){
            this.productRepository.deleteById(id);
            return ResponseEntity.ok("Successfully deleted.");
        } else {
            return ResponseEntity.ok("The product with id: " + id + " was not found.");
        }

        /**
         * This is gonna check if the project is in the DB; if it is in the DB,
         * it will delete it; if it's not in the DB, it will print out that
         * it was not found
         */

    }
}

/**
 * @RestCOntroller, we're creating the rest api right now
 *
 * Let's start with the first GetMapping that is probably gonna return
 * all the products of the DB
 *
 * So let's create the method getAllProducts(), a ResponseEntity
 * Let's implement this function:
 * Before we implement tho, we have to INJECT our REPOSITORY
 *
 * private final...
 * IntelliJ will help us to get it as a CONSTRUCTOR PARAMETER,
 * so it's gonna INJECT THIS DEPENDENCY RIGHT HERE,
 * so it's gonna inject the bean of this dependency so we can use it
 * right HERE
 *
 * ResponseEntity.ok()<- status ok
 *
 * findAll() is a method of MONGOREPOSITORY, ESTESO DA PRODUCTREPOSITORY
 *
 */
