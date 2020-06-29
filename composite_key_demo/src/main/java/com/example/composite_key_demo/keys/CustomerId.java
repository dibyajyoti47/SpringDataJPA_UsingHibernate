package com.example.composite_key_demo.keys;

import java.io.Serializable;

import javax.persistence.Embeddable;

import lombok.Getter;
import lombok.Setter;

@Getter  @Setter
@Embeddable
public class CustomerId implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String email;
}
