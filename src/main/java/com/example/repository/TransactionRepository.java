package com.example.repository;

import java.util.Optional;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.models.Account;
import com.example.models.AccountTransaction;

@Repository
public interface TransactionRepository extends JpaRepository<AccountTransaction, Integer>{

	//Whenever I call this method, I will just pass the same account in parameters
	Optional<Set<AccountTransaction>> findByToOrFrom(Account a1, Account a2);
	
}
