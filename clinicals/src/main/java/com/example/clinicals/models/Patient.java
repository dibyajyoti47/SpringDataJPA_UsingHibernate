package com.example.clinicals.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity @Table(name="patient")
public class Patient {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String first_name;
	private String last_name;
	private int age;
	
	@JsonBackReference
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "patient")
	private List<ClinincalData> clinincalDatas;

	@Override
	public String toString() {
		return "Patient [id=" + id + ", first_name=" + first_name + ", last_name=" + last_name + ", age=" + age
				+ ", clinincalDatas=" + clinincalDatas + "]";
	}

	
	
	
}
