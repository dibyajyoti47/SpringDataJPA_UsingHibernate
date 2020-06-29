package com.example.transaction_management.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.transaction_management.entities.BankAccount;
import com.example.transaction_management.repository.BankAccountRepository;

@Service
public class BankAccountServiceImpl implements BankAccountService{
	
	@Autowired
	private BankAccountRepository bankAccountRepository;
	
	@Transactional
	public void transfer(int amount) {
		BankAccount obamaAcc = bankAccountRepository.findById(1).get();
		obamaAcc.setBal(obamaAcc.getBal() - amount);
		bankAccountRepository.save(obamaAcc);
		
		if(true)
			throw new RuntimeException("");
		
		BankAccount trumpAcc = bankAccountRepository.findById(2).get();
		trumpAcc.setBal(trumpAcc.getBal() + amount);
		bankAccountRepository.save(trumpAcc);
		
	}
}
