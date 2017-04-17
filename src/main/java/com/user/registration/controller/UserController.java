package com.user.registration.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.user.registration.exception.UserExceptions;
import com.user.registration.models.Users;
import com.user.registration.services.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(
			value = "/users",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Collection<Users>> getAllUsers() {

		Collection<Users> users = userService.findAll();

		return new ResponseEntity<Collection<Users>>(users,
				HttpStatus.OK);
	}

	@RequestMapping(
			value = "/users/{id}",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Users> getuser(@PathVariable("id") Long id) throws UserExceptions {

		Users user = userService.findOne(id);
		if (user == null) {
			throw new UserExceptions("User doesn´t exist");
		}

		return new ResponseEntity<Users>(user, HttpStatus.OK);
	}

	@RequestMapping(
			value = "/users",
			method = RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Users> createuser(
			@RequestBody Users user) throws UserExceptions {

		Users savedUser = userService.create(user);

		return new ResponseEntity<Users>(savedUser, HttpStatus.CREATED);
	}


	@RequestMapping(
			value = "/users/{id}",
			method = RequestMethod.DELETE)
	public ResponseEntity<String> deleteUser(@PathVariable("id") Long id){
		userService.delete(id);
		return new ResponseEntity<String>("User successfully deleted", HttpStatus.OK);
	}



}
