package com.example.mongodb_connect.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.mongodb_connect.models.Product;

public interface ProductRepository extends MongoRepository<Product, String>{

}
