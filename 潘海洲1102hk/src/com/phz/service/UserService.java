package com.phz.service;


import com.phz.entity.User;

public interface UserService {
	
	public User queryUser(String name,String pwd);
	
	public User checkName(String name);
	
	public void addUser(User user);
}
