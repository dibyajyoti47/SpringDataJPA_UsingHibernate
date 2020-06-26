package com.example.associations;

import java.util.HashSet;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.associations.entities.Customer;
import com.example.associations.entities.PhoneNumber;
import com.example.associations.repositories.CustomerRepository;

@SpringBootTest
class AssociationsApplicationTests {
	
	@Autowired
	private CustomerRepository repo;
	
	@Test
	void testcreateCustomer() {
		Customer customer = new Customer();
		customer.setName("Dibyajyoti");
		
		HashSet<PhoneNumber> numbers = new HashSet<PhoneNumber>();
		
		PhoneNumber number1 = new PhoneNumber();
		number1.setNumber("9861314650");
		number1.setType("Work");
		number1.setCustomer(customer);
		numbers.add(number1);
		PhoneNumber number2 = new PhoneNumber();
		number2.setNumber("9035238735");
		number2.setType("Home");
		number2.setCustomer(customer);
		numbers.add(number2);
		
		customer.setPhoneNumbers(numbers);
		repo.save(customer);
	}

	@Test
	void testloadCustomer() {
		Customer c = repo.findById(3l).get();
		System.out.println(c.getName());
		c.getPhoneNumbers().forEach(p -> {
			System.out.println(p.getNumber()+"_"+p.getType());
		});
		
	}
	
	@Test
	void testUpdateCustomer () {
		Customer c = repo.findById(3l).get();
		c.setName("Linku");
		c.getPhoneNumbers().forEach(p -> p.setType("Cell"));
		repo.save(c);
	}
}
