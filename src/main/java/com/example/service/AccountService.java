package com.example.service;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.exceptions.AccountDoesntExist;
import com.example.models.Account;
import com.example.models.AccountType;
import com.example.models.User;
import com.example.repository.AccountRepository;

@Service
@Transactional
public class AccountService {
	
	@Autowired
	private AccountRepository ar;
	
	//New Account, Delete Account, Get Account, UpdateAccount
	public Account createAccount(int ownerId, AccountType type) {
		
		String startingNum = "10002345";
		
		Random random = new Random();
        int num = random.nextInt(100000);
        
        startingNum += num;
        
        long accNum = Long.parseLong(startingNum);
        User u = new User();
        u.setUserId(ownerId);
        
        Account a = new Account(accNum, u, type, 0.0);
        
        return ar.save(a);
	}
	
	public Account getAccountByNumber(long accountNum) {
		return ar.findById(accountNum).orElseThrow(AccountDoesntExist::new);
	}
	
	public Set<Account> getUsersAccounts(int userId) {
		User u = new User();
		u.setUserId(userId);
		//return the users accounts, or return an empty set
		Set<Account> accounts = ar.findByOwner(u).orElse(new HashSet<Account>());
		
		return accounts;
	}
	
	public Account updateAccountBalance(long accountNum, double balance) {
		Account a = ar.findById(accountNum).orElseThrow(AccountDoesntExist::new);
		a.setBalance(a.getBalance() + balance);
		return ar.save(a);
	}
	
	public void deleteAccount(long accountNum) {
		Account a = new Account();
		a.setAccountNumber(accountNum);
		ar.delete(a);
	}

}
