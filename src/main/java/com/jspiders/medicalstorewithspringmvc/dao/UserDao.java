package com.jspiders.medicalstorewithspringmvc.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jspiders.medicalstorewithspringmvc.dto.User;

@Component
public class UserDao {

	@Autowired
	private EntityManager entityManager;

	private EntityTransaction getEntityTransaction() {
		return entityManager.getTransaction();
	}

	public void saveUser(User user) {
		getEntityTransaction().begin();
		entityManager.persist(user);
		getEntityTransaction().commit();
	}

	public void updateUser(User user) {
		getEntityTransaction().begin();
		entityManager.merge(user);
		getEntityTransaction().commit();
	}

	public void deleteUser(User user) {
		getEntityTransaction().begin();
		entityManager.remove(user);
		getEntityTransaction().commit();
	}

	public User getUser(int id) {
		return entityManager.find(User.class, id);
	}

	public User findUser(String email, String password) {
		Query query = entityManager
				.createQuery("SELECT user FROM User user WHERE user.email = ?1 AND user.password = ?2");
		query.setParameter(1, email);
		query.setParameter(2, password);
		return (User) query.getSingleResult();
	}

}
