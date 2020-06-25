package com.example.hibernate_inheritance.repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.hibernate_inheritance.entities.Payment;

public interface PaymentRepository extends CrudRepository<Payment, Integer> {

}
