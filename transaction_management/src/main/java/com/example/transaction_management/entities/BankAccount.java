package com.example.transaction_management.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity @Table(name = "bankaccount")
public class BankAccount {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int accno;
	private String firstname;
	private String lastname;
	private int bal;
	@Override
	public String toString() {
		return "BankAccount [accno=" + accno + ", firstname=" + firstname + ", lastname=" + lastname + ", bal=" + bal
				+ "]";
	}
	
}
