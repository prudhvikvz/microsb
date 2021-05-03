package com.example.demo.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

import com.example.demo.entity.Users;

@Component
public class UserServiceImpl implements UserServiceDao{

	
	public static ArrayList<Users> users = new ArrayList<Users>();
	public static int userCount =3;
	
	static {
		users.add(new Users(1,"Raju",new Date()));
		users.add(new Users(2,"Prudhvi",new Date()));
		users.add(new Users(3,"Captain",new Date()));
	}
	@Override
	public List<Users> getUsers() {
		
		return users;
	}
	@Override
	public Users getUser(int id) {
		for(Users u:users) {
			if(id == u.getId()) {
				return u;
			}
		}
		return null;
		
	}
	@Override
	public Users saveUsers(Users user) {
		if(user.getId() == null) {
			user.setId(++userCount);
		}

		users.add(user);
		return user;
	}
	@Override
	public void deleteUser(int id) {
		Iterator<Users> i = users.iterator();
		while(i.hasNext()) {
			Users u = i.next();
			if(u.getId() == id) {
				i.remove();
			}
		}
		System.out.println(users);
	}
	
	
}
