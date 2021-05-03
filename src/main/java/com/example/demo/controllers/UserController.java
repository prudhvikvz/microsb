package com.example.demo.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.demo.dao.UserServiceDao;
import com.example.demo.entity.Users;

@RestController
public class UserController {

	@Autowired
	private UserServiceDao userServiceDao;

	@GetMapping(path = "/users")
	public List<Users> getUsers() {

		return userServiceDao.getUsers();

	}

	@GetMapping(path = "/users/{id}")
	public Users getUser(@PathVariable int id) {
		
		Users user = userServiceDao.getUser(id);
		
		Resource<Users> user = new Resource<Users>(user);
		return 
	}

	@PostMapping(path = "/users")
	public ResponseEntity<Object> saveUsers(@RequestBody Users user) {

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(userServiceDao.saveUsers(user).getId()).toUri();
		return ResponseEntity.created(location).build();

	}
	@DeleteMapping(path = "/users/{id}")
	public void deleteUser(@PathVariable int id) {
		userServiceDao.deleteUser(id);
		
	}

}
