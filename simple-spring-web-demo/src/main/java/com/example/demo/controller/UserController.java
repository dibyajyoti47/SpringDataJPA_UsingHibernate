package com.example.demo.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.database.UserDatabase;
import com.example.demo.model.User;

@RestController
@RequestMapping(path="users")
public class UserController {
	
	@Autowired
	private UserDatabase userDatabase;
	
	@GetMapping("/all")
	public Collection<User> getAllUsers() {
		return userDatabase.getAllUsers(); 
	} 
	
	@GetMapping("{id}")
	public User getUser(@PathVariable("id") Long userId) {
		return userDatabase.getSingleUser(userId); 
	} 
	
	@PostMapping("add")
	public String adduser(@RequestBody User user) {
		return userDatabase.addUser(user);
	}
	
	@DeleteMapping("{id}")
	public String deleteUser(@PathVariable("id") Long userId) {
		return userDatabase.deleteUser(userId); 
	} 
	
	@PutMapping("{id}")
	public String updateUser(@PathVariable("id") Long userId, @RequestBody User user) {
		return userDatabase.updateUser(userId, user); 
	} 
	
}
