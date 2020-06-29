package com.example.patient_scheduling.repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.patient_scheduling.entities.Appointment;
import com.example.patient_scheduling.entities.Doctor;

public interface DoctorRepository  extends CrudRepository<Doctor, Long>{

}
