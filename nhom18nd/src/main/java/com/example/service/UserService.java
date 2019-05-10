package com.example.service;

import com.example.model.User;

public interface UserService {
	Iterable<User> findAll();
	
	User findOne(Integer id);
	
	User login(String gmail, String pwd);
	
	void saveUser(User u);
	
	void deleteUser(Integer id);
}
