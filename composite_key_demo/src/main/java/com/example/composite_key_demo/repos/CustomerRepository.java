package com.example.composite_key_demo.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.example.composite_key_demo.entities.Customer;
import com.example.composite_key_demo.keys.CustomerId;

public interface CustomerRepository extends JpaRepository<Customer, CustomerId>{

}
