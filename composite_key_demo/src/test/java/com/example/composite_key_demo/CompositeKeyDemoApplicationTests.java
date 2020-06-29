package com.example.composite_key_demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.composite_key_demo.entities.Customer;
import com.example.composite_key_demo.keys.CustomerId;
import com.example.composite_key_demo.repos.CustomerRepository;

@SpringBootTest
class CompositeKeyDemoApplicationTests {
	
	@Autowired
	CustomerRepository repo;
	
	
	@Test
	void testSaveCustomer() {
		Customer customer = new Customer();
		CustomerId custId = new CustomerId();
		custId.setEmail("test@test.com");
		custId.setId(1l);
		customer.setCustId(custId);
		customer.setName("Linku");
		repo.save(customer);
	}

}
