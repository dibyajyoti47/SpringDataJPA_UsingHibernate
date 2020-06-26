package com.example.associations;

import java.util.HashSet;
import java.util.Set;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.associations.entities.manytomany.Programmer;
import com.example.associations.entities.manytomany.Project;
import com.example.associations.entities.onetomany.Customer;
import com.example.associations.entities.onetomany.PhoneNumber;
import com.example.associations.repositories.CustomerRepository;
import com.example.associations.repositories.ProgrammerRepository;

@SpringBootTest
class AssociationsApplicationTests {
	
	@Autowired
	private CustomerRepository repo;
	
	@Autowired
	private ProgrammerRepository prepo;
	
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
	
	@Test
	void testm2mCreateProgrammer () {
		Programmer pg1 = new Programmer();
		pg1.setName("Dibyajyoti"); pg1.setSal(12000);
		
		Programmer pg2 = new Programmer();
		pg2.setName("Swati"); pg2.setSal(13000);
		
		
		Project pj1 = new Project();
		pj1.setName("Pde");
		
		Project pj2 = new Project();
		pj2.setName("Sizer");
		
		Set<Project> projects = new HashSet<Project>();
		projects.add(pj1); projects.add(pj2);
		
		pg1.setProjects(projects);
		prepo.save(pg1);
	}
	
	@Test
	@Transactional //in case of lazy loading
	void testm2mFindProgrammer () {
		Programmer pr = prepo.findById(2).get();
		System.out.println(pr);
		pr.getProjects().forEach(System.out::println);
	}
}
