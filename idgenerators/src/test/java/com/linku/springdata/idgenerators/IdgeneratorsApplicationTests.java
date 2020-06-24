package com.linku.springdata.idgenerators;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class IdgeneratorsApplicationTests {

	@Test
	void contextLoads() {
	}
	
	@Autowired
	private EmployeeRepository er;
	
	@Test
	void testCreateEmployee() {
		Emplyoee emp = new Emplyoee();
//		emp.setId(123l);
		emp.setName("Dibyajyoti2");
		er.save(emp);
	}
}
