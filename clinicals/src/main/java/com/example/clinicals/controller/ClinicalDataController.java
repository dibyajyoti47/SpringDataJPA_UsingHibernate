package com.example.clinicals.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.clinicals.dto.ClinicalDataRequest;
import com.example.clinicals.models.ClinincalData;
import com.example.clinicals.models.Patient;
import com.example.clinicals.repositories.ClinicalDataRepository;
import com.example.clinicals.repositories.PatientRepository;

@RestController
@RequestMapping("/api")
public class ClinicalDataController {
	
	@Autowired
	private ClinicalDataRepository clinicalDataRepo;
	
	@Autowired
	private PatientRepository patientRepo;
	
	@PostMapping("clinicals")
	public ClinincalData saveClinicData(@RequestBody ClinicalDataRequest request) {
		Patient patiet = patientRepo.findById(12).get();
		ClinincalData clinincalData = new ClinincalData();
		clinincalData.setComponent_name(request.getComponentName());
		clinincalData.setComponent_value(request.getComponentValue());
		clinincalData.setPatient(patiet);
		return clinicalDataRepo.save(clinincalData);
	}
	
	
}
