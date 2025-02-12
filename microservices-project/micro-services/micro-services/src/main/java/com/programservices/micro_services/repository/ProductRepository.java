package com.programservices.micro_services.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.programservices.micro_services.model.Product;

public interface ProductRepository extends MongoRepository<Product, String>{

}
