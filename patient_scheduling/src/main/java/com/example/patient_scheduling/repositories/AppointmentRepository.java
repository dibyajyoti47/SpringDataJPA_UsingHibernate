package com.example.patient_scheduling.repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.patient_scheduling.entities.Appointment;

public interface AppointmentRepository extends CrudRepository<Appointment, Long>{

}
