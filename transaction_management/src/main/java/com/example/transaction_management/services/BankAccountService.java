package com.example.transaction_management.services;

import org.springframework.stereotype.Service;

public interface BankAccountService {
	void transfer(int amount);
}
