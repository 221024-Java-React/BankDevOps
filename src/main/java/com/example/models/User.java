package com.example.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

//Whenever we are annotating a class to be mapped to a database we are using JPA annotations
//JPA is Java Persistence API -> Gets implemented by other libraries
//JPA Library/API is the interface which Hibernate implements in Spring Data
//JPA Library/API -> Hibernate -> Spring Data Abstracts Hibernate away even more
//Entity Table Column etc -> JPA Interface/Library
//JQL -> Java Query Language -> HQL -> Hibernate Query Language
	//-> Object Oriented Query that is NONE Database Depenedent Language
	// Why we need the dialect, Spring Data/Hibernate will convert the JQL/HQL to whatever database language you need

@Entity
//Optionally we can use @Table
@Table(name="users")
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="user_id")
	private int userId;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(unique=true)
	private String email;
	
	private String password;
	
	//Map the cardinality
	@OneToMany(mappedBy="owner", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	@JsonIgnore
	private List<Account> accounts;
	
	public User() {
		accounts = new ArrayList<>();
	}
	
	public User(int userId, String firstName, String lastName, String email, String password, List< Account> accounts) {
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.accounts = accounts;
	}
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public List<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", password=" + password + ", accounts=" + accounts + "]";
	}
}
