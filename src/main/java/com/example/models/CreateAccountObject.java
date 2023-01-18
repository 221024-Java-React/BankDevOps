package com.example.models;

public class CreateAccountObject {
	
	private int ownerId;
	private AccountType type;
	
	public CreateAccountObject() {
		super();
	}
	
	public CreateAccountObject(int ownerId, AccountType type) {
		super();
		this.ownerId = ownerId;
		this.type = type;
	}
	
	public int getOwnerId() {
		return ownerId;
	}
	
	public void setOwnerId(int ownerId) {
		this.ownerId = ownerId;
	}
	
	public AccountType getType() {
		return type;
	}
	
	public void setType(AccountType type) {
		this.type = type;
	}
	
	@Override
	public String toString() {
		return "CreateAccountObject [ownerId=" + ownerId + ", type=" + type + "]";
	}
	
	

}
