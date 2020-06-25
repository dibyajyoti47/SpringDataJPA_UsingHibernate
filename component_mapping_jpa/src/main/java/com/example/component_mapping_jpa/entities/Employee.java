package com.example.component_mapping_jpa.entities;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity 
@Table(name = "employee1")
public class Employee {
	@Id
	private int id;
	private String name;
	@Embedded
	private Address address;
}
