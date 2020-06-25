package com.example.jpql_nativesql.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "student")
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name="fname")
	private String firstName;
	@Column(name="lname")
	private String lastName;
	private int score;
	
	@Override
	public String toString() {
		return "[" + id +"_"+ firstName +"_"+ lastName +"_"+ score + "]";
	}
}
