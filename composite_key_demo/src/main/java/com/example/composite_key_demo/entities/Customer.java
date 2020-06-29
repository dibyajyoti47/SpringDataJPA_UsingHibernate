package com.example.composite_key_demo.entities;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import com.example.composite_key_demo.keys.CustomerId;

import lombok.Getter;
import lombok.Setter;

@Getter  @Setter
@Entity @Table(name= "customer2")
public class Customer {
	@EmbeddedId
	private CustomerId custId;
	private String name;
}
