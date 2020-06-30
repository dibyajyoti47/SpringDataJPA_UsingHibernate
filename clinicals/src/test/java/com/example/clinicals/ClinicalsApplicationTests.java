package com.example.clinicals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.clinicals.repositories.PatientRepository;

@SpringBootTest
class ClinicalsApplicationTests {
	@Autowired
	PatientRepository repo;
	
	@Test
	void test() {
		repo.findAll().forEach(p-> {
			p.getClinincalDatas().forEach(System.out::println);
		});
	}

}
