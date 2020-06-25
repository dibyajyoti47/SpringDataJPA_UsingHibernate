package com.example.hibernate_inheritance;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.hibernate_inheritance.entities.Cheque;
import com.example.hibernate_inheritance.entities.CreditCard;
import com.example.hibernate_inheritance.repositories.PaymentRepository;

@SpringBootTest
class HibernateInheritanceApplicationTests {
	
	@Autowired
	PaymentRepository repo;
	
	@Test
	void createCreditcardPayment () {
		CreditCard cc = new CreditCard();
		cc.setId(123);
		cc.setCardnumber("123456789");
		cc.setAmount(1200.43);
		repo.save(cc);
	}
	
	@Test
	void createChequePayment () {
		Cheque ch = new Cheque();
		ch.setId(124);
		ch.setChequeNumber("123456789");
		ch.setAmount(1200.43);
		repo.save(ch);
	}
}
