package com.example.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.models.Account;
import com.example.models.AccountTransaction;
import com.example.models.TransactionType;
import com.example.repository.TransactionRepository;

@Service
@Transactional
public class TransactionService {
	
	@Autowired
	private TransactionRepository tr;
	
	@Autowired
	private AccountService as;
	
	//To get all transactions for a specified account, withdraw, deposit, transfer money

	public AccountTransaction deposit(long accNum, double amount) {
		Account a = as.getAccountByNumber(accNum);
		
		AccountTransaction transaction = new AccountTransaction(0, TransactionType.DEPOSIT, a, null, amount);
		
		//In the real world, we would probably want to do some checks to make sure the user did not specify a
		//negative number to deposit, or some other funny business
		as.updateAccountBalance(accNum, amount);
		
		return tr.save(transaction);
		
	}
	
	public AccountTransaction withdraw(long accNum, double amount) {
		Account a = as.getAccountByNumber(accNum);
		
		AccountTransaction transaction = new AccountTransaction(0, TransactionType.WITHDRAW, null, a, amount);
		
		as.updateAccountBalance(accNum, -amount);
		
		return tr.save(transaction);
	}
	
	public AccountTransaction transfer(long toAccNum, long fromAccNum, double amount) {
		Account to = as.getAccountByNumber(toAccNum);
		Account from = as.getAccountByNumber(fromAccNum);
		
		AccountTransaction transaction = new AccountTransaction(0, TransactionType.TRANSFER, to, from, amount);
		
		as.updateAccountBalance(toAccNum, amount);
		as.updateAccountBalance(fromAccNum, -amount);
		
		return tr.save(transaction);
	}
	
	public Set<AccountTransaction> getTransactionsForAccount(long accNum){
		Account a = as.getAccountByNumber(accNum);
		return tr.findByToOrFrom(a, a).orElse(new HashSet<AccountTransaction>());
	}
}
