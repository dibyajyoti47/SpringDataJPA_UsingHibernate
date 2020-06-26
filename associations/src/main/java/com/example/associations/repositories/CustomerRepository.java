package com.example.associations.repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.associations.entities.onetomany.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long>{

}
