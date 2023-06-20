package com.jspiders.medicalstorewithspringmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jspiders.medicalstorewithspringmvc.dao.MedicineDao;
import com.jspiders.medicalstorewithspringmvc.dto.Medicine;

@Component
public class MedicineService {

	@Autowired
	private MedicineDao medicineDao;

	public boolean saveMedicine(Medicine medicine) {
		try {
			medicineDao.saveMedicine(medicine);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean updateMedicine(Medicine medicine) {
		try {
			medicineDao.updateMedicine(medicine);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean deleteMedicine(Medicine medicine) {
		try {
			medicineDao.deleteMedicine(medicine);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public Medicine getMedicine(int id) {
		try {
			return medicineDao.getMedicine(id);
		} catch (Exception e) {
			return null;
		}
	}

	public List<Medicine> getMedicinesByUserId(int id) {
		List<Medicine> medicines = medicineDao.getMedicinesByUserId(id);
		if (medicines != null && medicines.size() > 0) {
			return medicines;
		} else {
			return null;
		}
	}

}
