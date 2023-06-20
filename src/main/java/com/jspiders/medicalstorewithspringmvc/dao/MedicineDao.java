package com.jspiders.medicalstorewithspringmvc.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jspiders.medicalstorewithspringmvc.dto.Medicine;

@Component
public class MedicineDao {

	@Autowired
	private EntityManager entityManager;

	private EntityTransaction getEntityTransaction() {
		return entityManager.getTransaction();
	}

	public void saveMedicine(Medicine medicine) {
		getEntityTransaction().begin();
		entityManager.persist(medicine);
		getEntityTransaction().commit();
	}

	public void updateMedicine(Medicine medicine) {
		getEntityTransaction().begin();
		entityManager.merge(medicine);
		getEntityTransaction().commit();
	}

	public void deleteMedicine(Medicine medicine) {
		getEntityTransaction().begin();
		entityManager.remove(medicine);
		getEntityTransaction().commit();
	}

	public Medicine getMedicine(int id) {
		return entityManager.find(Medicine.class, id);
	}

	public List<Medicine> getMedicinesByUserId(int id) {
		Query query = entityManager.createQuery("SELECT medicine From Medicine medicine WHERE medicine.user.id = ?1");
		query.setParameter(1, id);
		@SuppressWarnings("unchecked")
		List<Medicine> medicines = query.getResultList();
		return medicines;
	}

}
