package com.example.associations.repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.associations.entities.manytomany.Programmer;

public interface ProgrammerRepository extends CrudRepository<Programmer, Integer> {

}
