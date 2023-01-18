package com.example.controllers;

import java.util.LinkedHashMap;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.models.AccountTransaction;
import com.example.service.TransactionService;

@RestController
@RequestMapping("/transaction")
@CrossOrigin("*")
public class TransactionController {
	
	@Autowired
	private TransactionService ts;
	
	@PostMapping("/deposit")
	public AccountTransaction deposit(@RequestBody LinkedHashMap<String, String> body) {
		long accountNum = Long.parseLong(body.get("accNum"));
		double amount = Double.parseDouble(body.get("amount"));
		
		return ts.deposit(accountNum, amount);
	}
	
	@PostMapping("/withdraw")
	public AccountTransaction withdraw(@RequestBody LinkedHashMap<String, String> body) {
		long accountNum = Long.parseLong(body.get("accNum"));
		double amount = Double.parseDouble(body.get("amount"));
		
		return ts.withdraw(accountNum, amount);
	}
	
	@PostMapping("/transfer")
	public AccountTransaction transfer(@RequestBody LinkedHashMap<String, String> body) {
		long toNum = Long.parseLong(body.get("toNum"));
		long fromNum = Long.parseLong(body.get("fromNum"));
		double amount = Double.parseDouble(body.get("amount"));
		
		return ts.transfer(toNum, fromNum, amount);
	}
	
	@GetMapping("/account/{id}")
	public Set<AccountTransaction> getAllTransactions(@PathVariable("id")long id){
		return ts.getTransactionsForAccount(id);
	}

}
