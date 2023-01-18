package com.example.exceptions;

public class AccountDoesntExist extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AccountDoesntExist() {
		super("Account does not exist");
	}
	
}
