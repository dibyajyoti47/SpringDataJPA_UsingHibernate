package com.example.savefile_jpa.repos;

import org.springframework.data.repository.CrudRepository;

import com.example.savefile_jpa.entities.Image;

public interface ImageRepository extends CrudRepository<Image, Long>{
	
}
