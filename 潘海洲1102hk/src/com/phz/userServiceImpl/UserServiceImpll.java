package com.phz.userServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.phz.dao.UserDao;
import com.phz.entity.User;
import com.phz.service.UserService;

@Service
public class UserServiceImpll implements UserService {
	@Autowired
	private UserDao userDao;
	
	@Override
	public User queryUser(String name, String pwd) {
		return userDao.queryUser(name, pwd);
	}

	@Override
	public void addUser(User user) {
		userDao.addUser(user);
	}

	@Override
	public User checkName(String name) {
		return userDao.checkName(name);
	}
}
