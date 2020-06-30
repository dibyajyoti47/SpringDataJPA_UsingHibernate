package com.example.clinicals.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.clinicals.models.Patient;

public interface PatientRepository extends JpaRepository<Patient, Integer>{

}
