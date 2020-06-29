package com.example.patient_scheduling;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.patient_scheduling.entities.Appointment;
import com.example.patient_scheduling.entities.Doctor;
import com.example.patient_scheduling.entities.Insurance;
import com.example.patient_scheduling.entities.Patient;
import com.example.patient_scheduling.repositories.AppointmentRepository;
import com.example.patient_scheduling.repositories.DoctorRepository;
import com.example.patient_scheduling.repositories.PatientRepository;

@SpringBootTest
class PatientSchedulingApplicationTests {
	
	@Autowired
	private DoctorRepository docterRepo;
	@Autowired
	private PatientRepository patientRepo;
	@Autowired
	private AppointmentRepository appointmentRepo;
	
	@Test
	void testCreateDocter () {
		Doctor docterEntity = new Doctor();
		docterEntity.setFirstName("Tariq");
		docterEntity.setLastName("Hussain");
		docterRepo.save(docterEntity);
	}
	
	@Test
	void testCreatePatient () {
		Patient patientEntity = new Patient();
		patientEntity.setFirstName("Dibyajyoti");
		patientEntity.setLastName("Behera");
		patientEntity.setPhone("9035238735");
		
		Insurance insurance = new Insurance();
		insurance.setCopay(15d);
		insurance.setProviderName("Applo Munic");
		patientEntity.setInsurance(insurance);
		
		Doctor doctor1 = docterRepo.findById(1l).get();		
		List<Doctor> doctors = new ArrayList<Doctor>();
		doctors.add(doctor1);
		patientEntity.setDoctors(doctors);
		
		patientRepo.save(patientEntity);
	}

	@Test
	void testCreateAppointment () {
		Appointment appointmentEntity = new Appointment();
		
		Timestamp appointmentTime = new Timestamp(new Date().getTime()); 
		appointmentEntity.setAppointmentTime(appointmentTime);
		
		appointmentEntity.setDoctor(docterRepo.findById(1l).get());
		appointmentEntity.setPatient(patientRepo.findById(1l).get());
		appointmentEntity.setReason("stomach ache");
		appointmentEntity.setStarted(true);
		
		appointmentRepo.save(appointmentEntity);
		
	}
}
