package com.example.controllers;

import java.util.NoSuchElementException;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.models.LoginObject;
import com.example.models.User;
import com.example.service.UserService;

//Rest controller is a spring MVC stereotype which combines controller and request body, marking our
//class to act as a "route" to a resource on our server
@RestController
//Allows cross origin resource sharing, the bane of every web developers existence
@CrossOrigin("*")
//Sets the URI path of this specific controller
// specifically http://localhost:8080/user/...
@RequestMapping("/user")
public class UserController {

	/*
	 * Spring MVC/WEB
	 * 	- Model View Controller, is an older way to build user interface systems
	 * 	- Spring MVC is a module of spring that allows us to interface with a server using servlets
	 * 	- And generate views/get views based off of requests
	 * 	- Spring MVC uses a design pattern called Front Controller
	 * 		- You have one open port/servlet listenting to incoming requests,
	 * 		- The servlet hands off the request to any proper handler (contollers)
	 * 		- Then the controllers generate a response (whether that be json or html) and pass that back
	 * 			through the central servlet
	 * 	- Spring Boot comes with a built in tomcat server, and Spring web which sets up all the servlets and
	 * 		configurations for said servlets for us
	 * 	- Spring web is more focused on client/server
	 * 	- We use the built Controller and RestController stereo anotation from the Spring MVC framework
	 */
	
	@Autowired
	private UserService us;
	
	//PostMapping is telling spring to create a URI at /user/register which excepts POST requests
	@PostMapping("/register")
	//@RequestBody is telling the server that we except a body of a user type to come with this request
	public User registerUser(@RequestBody User u) {
		return us.createUser(u);
	}
	
	@PostMapping("/login")
	public User loginUser(@RequestBody LoginObject lo ){
		String email = lo.getEmail();
		String password = lo.getPassword();
		
		User u = us.getUserByEmail(email);
		
		if(!u.getPassword().equals(password)) {
			throw new NoSuchElementException();
		}
			
		return u;
	}
	
	@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<String> handleUserDoesntExist(){
		return new ResponseEntity<>("Username or password incorrect", HttpStatus.UNAUTHORIZED);
	}
	
	@GetMapping("/{id}")
	public User getById(@PathVariable("id")int id) {
		return us.getUserById(id);
	}
	
}
