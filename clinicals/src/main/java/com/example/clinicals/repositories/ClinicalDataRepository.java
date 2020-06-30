package com.example.clinicals.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.clinicals.models.ClinincalData;

public interface ClinicalDataRepository extends JpaRepository<ClinincalData, Integer>{

}
