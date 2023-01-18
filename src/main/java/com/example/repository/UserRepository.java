package com.example.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.models.User;

//Spring Data JPA pretty much implements all of the basic CRUD operations for you, all you have to
//do is create an interface, mark it as repository with @Repository and implement the JpaRepository interface 
public interface UserRepository extends JpaRepository<User, Integer>{

	//If you wanted to add additional queries outside of CRUD, spring data has a magical parser than reads
	//method stubs, and generates queries for you, or you can use @Query, and include a JQL query and Spring will
	//also generate the code for that for you as well
	//We can let Spring data generate us a sql query to select a user by their email
	Optional<User> findByEmail(String email);
	
}
