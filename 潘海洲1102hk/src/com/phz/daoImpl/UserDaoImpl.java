package com.phz.daoImpl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.springframework.stereotype.Repository;

import com.phz.dao.UserDao;
import com.phz.entity.User;

@Repository

public class UserDaoImpl extends BaseDao implements UserDao {
	
	@Override
	public User queryUser(String username, String pwd) {
		String hql="from User where userName=? and userPwd=?";
		User user=(User)this.getSession().createQuery(hql).setParameter(0, username).setParameter(1, pwd).uniqueResult();
		return user;
	}
	
	@Override
	public User checkName(String username) {
		String hql="from User where userName=?";
		User user=(User)this.getSession().createQuery(hql).setParameter(0, username).uniqueResult();
		return user;
	}
	@Override
	public void addUser(User user) {
		this.getSession().persist(user);
	}

	
	
	


	

}
