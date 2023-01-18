package com.example.controllers;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.models.Account;
import com.example.models.CreateAccountObject;
import com.example.service.AccountService;

@RestController
@RequestMapping("/account")
@CrossOrigin("*")
public class AccountController {
	
	@Autowired
	AccountService as;
	
	@PostMapping("/create")
	Account createAccount(@RequestBody CreateAccountObject cao) {
		return as.createAccount(cao.getOwnerId(), cao.getType());
	}
	
	@GetMapping("/user/{id}")
	Set<Account> getUsersAccounts(@PathVariable("id")int id){
		return as.getUsersAccounts(id);
	}

}
