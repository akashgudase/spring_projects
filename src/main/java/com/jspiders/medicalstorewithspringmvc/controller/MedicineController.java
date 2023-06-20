package com.jspiders.medicalstorewithspringmvc.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.jspiders.medicalstorewithspringmvc.dto.Medicine;
import com.jspiders.medicalstorewithspringmvc.dto.User;
import com.jspiders.medicalstorewithspringmvc.service.MedicineService;
import com.jspiders.medicalstorewithspringmvc.service.UserService;

@Controller
public class MedicineController {

	private User user;
	@Autowired
	private MedicineService medicineService;
	@Autowired
	private UserService userService;

	@RequestMapping("/addMedicine")
	public ModelAndView addMedicine() {
		ModelAndView modelAndView = new ModelAndView("AddMedicine.jsp");
		modelAndView.addObject("medicine", new Medicine());
		return modelAndView;
	}

	@RequestMapping("/saveMedicine")
	public ModelAndView saveMedicine(Medicine medicine, HttpServletRequest req) {
		HttpSession httpSession = req.getSession();
		user = (User) httpSession.getAttribute("user");
		if (medicineService.saveMedicine(medicine)) {
			medicineService.updateMedicine(medicine);
			List<Medicine> medicines;
			medicines = user.getMedicines();
			if (medicines != null) {
				medicines.add(medicine);
			} else {
				medicines = new ArrayList<Medicine>();
				medicines.add(medicine);
			}
			medicine.setUser(user);
			medicineService.updateMedicine(medicine);
			user.setMedicines(medicines);
			userService.updateUser(user);
			ModelAndView modelAndView = new ModelAndView("DashBoard2.jsp");
			modelAndView.addObject("message", "Medicine saved.");
			return modelAndView;
		} else {
			ModelAndView modelAndView = new ModelAndView("DashBoard2.jsp");
			modelAndView.addObject("message", "Medicine not saved.");
			return modelAndView;
		}
	}

	@RequestMapping("/editMedicine")
	public ModelAndView editMedicine(int id) {
		ModelAndView modelAndView = new ModelAndView("EditMedicine.jsp");
		modelAndView.addObject("medicine", medicineService.getMedicine(id));
		return modelAndView;
	}

	@RequestMapping("/updateMedicine")
	public ModelAndView updateMedicine(Medicine medicine, HttpServletRequest req) {
		User user = (User) req.getSession().getAttribute("user");
		medicine.setUser(user);
		if (medicineService.updateMedicine(medicine)) {
			ModelAndView modelAndView = new ModelAndView("DashBoard2.jsp");
			modelAndView.addObject("message", "Medicine updated.");
			return modelAndView;
		} else {
			ModelAndView modelAndView = new ModelAndView("DashBoard2.jsp");
			modelAndView.addObject("message", "Medicine not updated.");
			return modelAndView;
		}
	}

	@RequestMapping("/deleteMedicine")
	public ModelAndView deleteMedicine(int id, HttpServletRequest req) {
		user = (User) req.getSession().getAttribute("user");
		List<Medicine> medicines = user.getMedicines();
		medicines.remove(medicineService.getMedicine(id));
		user.setMedicines(medicines);
		userService.updateUser(user);
		if (medicineService.deleteMedicine(medicineService.getMedicine(id))) {
			ModelAndView modelAndView = new ModelAndView("DashBoard2.jsp");
			modelAndView.addObject("message", "Medicine deleted.");
			return modelAndView;
		} else {
			ModelAndView modelAndView = new ModelAndView("DashBoard2.jsp");
			modelAndView.addObject("message", "Medicine not deleted.");
			return modelAndView;
		}

	}

}
