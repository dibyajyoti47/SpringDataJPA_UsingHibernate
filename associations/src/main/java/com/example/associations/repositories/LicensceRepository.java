package com.example.associations.repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.associations.entities.onetoeone.License;

public interface LicensceRepository extends CrudRepository<License, Long> {
	
}
