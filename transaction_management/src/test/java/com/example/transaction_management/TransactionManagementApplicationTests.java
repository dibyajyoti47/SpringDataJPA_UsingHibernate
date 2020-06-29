package com.example.transaction_management;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.transaction_management.services.BankAccountService;

@SpringBootTest
class TransactionManagementApplicationTests {

	@Autowired
	private BankAccountService service;
	
	@Test
	void testUpdateBal () {
		service.transfer(500);
	}
	
}
