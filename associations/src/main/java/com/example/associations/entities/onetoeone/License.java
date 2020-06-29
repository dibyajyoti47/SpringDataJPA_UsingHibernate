package com.example.associations.entities.onetoeone;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.Setter;

@Getter  @Setter
@Entity @Table(name = "license")
public class License {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String type;
	
	@Column(name = "valid_from") 
	@Temporal(TemporalType.DATE)
	private Date validFrom;
	
	@Column(name = "valid_to")
	@Temporal(TemporalType.DATE)
	private Date validTo;
	
	@OneToOne(cascade = CascadeType.ALL) @JoinColumn(name = "person_id")
	private Person person;
	
	@Override
	public String toString() {
		return "License [id=" + id + ", type=" + type + ", validFrom=" + validFrom + ", validTo=" + validTo + "]";
	}	
}
