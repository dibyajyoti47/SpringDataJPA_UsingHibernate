package com.example.patient_scheduling.repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.patient_scheduling.entities.Patient;

public interface PatientRepository  extends CrudRepository<Patient, Long>{

}
