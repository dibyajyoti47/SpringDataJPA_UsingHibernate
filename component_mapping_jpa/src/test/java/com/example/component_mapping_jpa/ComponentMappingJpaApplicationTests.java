package com.example.component_mapping_jpa;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.component_mapping_jpa.entities.Address;
import com.example.component_mapping_jpa.entities.Employee;
import com.example.component_mapping_jpa.repository.EmployeeRepository;

@SpringBootTest
class ComponentMappingJpaApplicationTests {
	
	@Autowired
	private EmployeeRepository repo;
	
	@Test
	void testcreateEmployee() {
		Address address = new Address();
		address.setCity("Bangalore");
		address.setCountry("India");
		address.setState("Karnataka");
		address.setStreetaddress("Kaikondrahalli");
		address.setZipcode("560035");
		Employee e = new Employee();
		e.setName("Dibyajyoti");
		e.setAddress(address);
		repo.save(e);
	}

}
