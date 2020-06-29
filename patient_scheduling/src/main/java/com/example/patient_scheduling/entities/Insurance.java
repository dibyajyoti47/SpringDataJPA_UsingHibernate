package com.example.patient_scheduling.entities;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Embeddable
public class Insurance {
	@Column(name = "provider_name")
	private String providerName;
	private double copay;
	@Override
	public String toString() {
		return "Insurance [providerName=" + providerName + ", copay=" + copay + "]";
	}
}
