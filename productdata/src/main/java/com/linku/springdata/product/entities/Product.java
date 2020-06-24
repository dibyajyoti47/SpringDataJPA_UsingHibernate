package com.linku.springdata.product.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table
public class Product {
	
	@Id
	private int id;
	
	private String name;
	
	@Column(name="description")
	private String desc;
	
	private double price;
	
	@Override
	public String toString() {
		return id + "_" + name + "_" + desc + "_" + price;
	}
}
