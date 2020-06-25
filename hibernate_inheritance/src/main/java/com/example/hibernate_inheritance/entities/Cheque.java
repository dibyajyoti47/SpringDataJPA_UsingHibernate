package com.example.hibernate_inheritance.entities;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "bankcheck")
public class Cheque extends Payment {
	@Column(name = "checknumber")
	private String chequeNumber;
}
