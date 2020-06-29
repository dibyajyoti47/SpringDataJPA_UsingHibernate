package com.example.patient_scheduling.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity @Table(name= "patient")
public class Patient {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "first_name")
	private String firstName;
	@Column(name = "last_name")
	private String lastName;
	private String phone;
	@Embedded
	private Insurance insurance;
	@ManyToMany (fetch = FetchType.EAGER)
	@JoinTable(name = "patients_doctors", 
			   joinColumns = @JoinColumn(name="patient_id", referencedColumnName = "id"),
			   inverseJoinColumns = @JoinColumn (name="doctor_id", referencedColumnName = "id")
			  )
	private List<Doctor> doctors;
	
	@OneToMany(mappedBy = "patient", cascade = CascadeType.ALL)
	private List<Appointment> appointments;
	
	@Override
	public String toString() {
		return "Patient [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", phone=" + phone
				+ ", insurance=" + insurance + "]";
	}
}
