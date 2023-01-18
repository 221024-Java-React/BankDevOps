package com.example.repository;

import java.util.Optional;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.models.Account;
import com.example.models.AccountTransaction;
import com.example.models.User;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long>{

	//Allows us to write a JQL query, this will query against the object NOT the table
	//@Query("FROM AccountTransaction WHERE to = ?1 OR from =?1")
	//Set<AccountTransaction> getTransactionsForAccount(Account a);
	Optional<Set<Account>> findByOwner(User u);
}
