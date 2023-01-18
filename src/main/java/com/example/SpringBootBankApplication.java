package com.example;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.models.Account;
import com.example.models.AccountType;
import com.example.models.User;
import com.example.repository.AccountRepository;
import com.example.repository.TransactionRepository;
import com.example.repository.UserRepository;

@SpringBootApplication
public class SpringBootBankApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootBankApplication.class, args);
	}
	
	//CommandLineRunner allows you to run commands at the startup of your server
	/*
	@Bean
	public CommandLineRunner CommandLineRunnerBean(TestService ts) {
		return (args) -> {
			ts.setUpUserAndAccount();
		};
		
	}
	*/
}
