package com.example.clinicals.controller;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.clinicals.models.ClinincalData;
import com.example.clinicals.models.Patient;
import com.example.clinicals.repositories.PatientRepository;

@RestController
@RequestMapping("/api")
public class PatientController {
	
	@Autowired
	private PatientRepository repo;
	
	@GetMapping("/patients")
	public List<Patient> getPatients() {
		return repo.findAll();
	}
	
	@GetMapping("/patients/{id}")
	public Patient getPatient(@PathVariable("id") int id) {
		return repo.findById(id).get();
	}
	
	@PostMapping("/patients")
	public Patient savePatient(@RequestBody Patient patient) {
		return repo.save(patient);
	}
}
