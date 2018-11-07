package com.phz.dao;

import com.phz.entity.User;

public interface UserDao {
	
	public User queryUser(String username,String pwd);
	
	public User checkName(String username);
	
	public void addUser(User user);
}
