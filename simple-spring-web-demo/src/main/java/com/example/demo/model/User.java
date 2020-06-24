package com.example.demo.model;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {
	private long userId;
	private String userName;
	private int age;
	private double salary;
	private String city;
	private int pincode;
	private String company;
}
