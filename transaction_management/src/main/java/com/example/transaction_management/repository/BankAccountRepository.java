package com.example.transaction_management.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.transaction_management.entities.BankAccount;

public interface BankAccountRepository extends CrudRepository<BankAccount, Integer>{

}
