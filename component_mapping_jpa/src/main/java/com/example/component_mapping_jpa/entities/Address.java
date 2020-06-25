package com.example.component_mapping_jpa.entities;

import javax.persistence.Embeddable;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Embeddable
public class Address {
	private String streetaddress;
	private String city;
	private String state;
	private String country;
	private String zipcode;
}
