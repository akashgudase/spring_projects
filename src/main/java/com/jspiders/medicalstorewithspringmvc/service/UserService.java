package com.jspiders.medicalstorewithspringmvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jspiders.medicalstorewithspringmvc.dao.UserDao;
import com.jspiders.medicalstorewithspringmvc.dto.User;

@Component
public class UserService {

	@Autowired
	private UserDao userDao;

	public boolean saveUser(User user) {
		try {
			userDao.saveUser(user);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean updateUser(User user) {
		try {
			userDao.updateUser(user);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean deleteUser(User user) {
		try {
			userDao.deleteUser(user);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public User getUser(int id) {
		try {
			return userDao.getUser(id);
		} catch (Exception e) {
			return null;
		}
	}

	public User findUser(String email, String password) {
		try {
			return userDao.findUser(email, password);
		} catch (Exception e) {
			return null;
		}
	}
}
