package com.example.demo.dao;

import java.util.List;

import com.example.demo.entity.Users;

public interface UserServiceDao {

	List<Users> getUsers();

	Users getUser(int id);

	Users saveUsers(Users user);

	void deleteUser(int id);

}
