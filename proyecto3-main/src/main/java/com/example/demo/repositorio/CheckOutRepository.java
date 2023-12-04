package com.example.demo.repositorio;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.modelo.CheckOut;

public interface CheckOutRepository extends MongoRepository<CheckOut, String> {

}
