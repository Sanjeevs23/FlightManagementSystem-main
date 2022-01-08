package com.cg.flightmgmt.controller;

import java.math.BigInteger;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.flightmgmt.dao.UserDao;
import com.cg.flightmgmt.dto.User;
import com.cg.flightmgmt.exception.UserNotFoundException;

@RestController
@RequestMapping("/user")
public class UserController {
	Logger logger=org.slf4j.LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private UserDao dao;
	
	//localhost:5010/user/createUser
	@PostMapping(path="/createUser")
	public User createFlight(@Valid @RequestBody User user) {
		logger.info("User created sucessfully");
		return dao.addUser(user);
	}
	
	//localhost:5010/user/users
	@RequestMapping(path="/users")
	public List<User> viewAllUsers(){
		return dao.viewUser();
	}
	
	//localhost:5010/user/users/:id
	@GetMapping(path="/users/{UserId}")
	public User viewUserById(@PathVariable int UserId) throws UserNotFoundException{
		BigInteger userId = BigInteger.valueOf(UserId);
		return dao.viewUser(userId);
	}
	
	//localhost:5010/user/updateUser/:id
	@PutMapping(path="/updateUser")
	public User updateUser(@RequestBody User user) {
		return dao.updateUser(user);
	}
	
	//localhost:5010/user/deleteUser/:id
	@DeleteMapping(path="deleteUser/{Userid}")
	public void deleteUser(@PathVariable int UserId){
		BigInteger userId = BigInteger.valueOf(UserId);
		dao.deleteUser(userId);
	}
}
