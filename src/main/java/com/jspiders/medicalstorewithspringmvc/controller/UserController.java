package com.jspiders.medicalstorewithspringmvc.controller;

import java.util.Arrays;
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
public class UserController {

	@Autowired
	private UserService userService;
	@Autowired
	private MedicineService medicineService;

	@RequestMapping("/signUp")
	public ModelAndView signUp() {
		ModelAndView modelAndView = new ModelAndView("SignUp.jsp");
		modelAndView.addObject("user", new User());
		return modelAndView;
	}

	@RequestMapping("/saveUser")
	public ModelAndView saveUser(User user) {
		if (userService.saveUser(user)) {
			return logIn();
		} else {
			ModelAndView modelAndView = new ModelAndView("DashBoard2.jsp");
			modelAndView.addObject("message", "Sign up failed.");
			return modelAndView;
		}
	}

	@RequestMapping("/editUser")
	public ModelAndView editUser(int id) {
		ModelAndView modelAndView = new ModelAndView("EditUser.jsp");
		modelAndView.addObject("user", userService.getUser(id));
		return modelAndView;
	}

	@RequestMapping("/updateUser")
	public ModelAndView updateMedicine(User user) {
		ModelAndView modelAndView = new ModelAndView("DashBoard2.jsp");
		if (userService.updateUser(user)) {
			modelAndView.addObject("message", "User updated.");
		} else {
			modelAndView.addObject("message", "User not updated.");
		}
		return modelAndView;
	}

	@RequestMapping("/deleteUser")
	public ModelAndView deleteUser(int id) {
		ModelAndView modelAndView = new ModelAndView("DashBoard2.jsp");
		User user = userService.getUser(id);
		user.setMedicines(null);
		userService.updateUser(user);
		if (userService.deleteUser(user)) {
			modelAndView.addObject("message", "User deleted.");
		} else {
			modelAndView.addObject("message", "User not deleted.");
		}
		return modelAndView;
	}

	@RequestMapping("/logIn")
	public ModelAndView logIn() {
		ModelAndView modelAndView = new ModelAndView("LogIn.jsp");
		modelAndView.addObject("user", new User());
		return modelAndView;
	}

	@RequestMapping("/validate")
	public ModelAndView validate(User user2, HttpServletRequest req) {
		User user = userService.findUser(user2.getEmail(), user2.getPassword());
		if (user != null) {
			HttpSession httpSession = req.getSession();
			httpSession.setAttribute("user", user);
			ModelAndView modelAndView = new ModelAndView("Select.jsp");
			return modelAndView;
		} else {
			return logIn();
		}
	}

	@RequestMapping("/showMedicines")
	public ModelAndView showMedicines(HttpServletRequest req) {
		HttpSession httpSession = req.getSession();
		User user = (User) httpSession.getAttribute("user");
		if (user != null) {
			List<Medicine> medicines = medicineService.getMedicinesByUserId(user.getId());
			if (medicines != null && medicines.size() > 0) {
				ModelAndView modelAndView = new ModelAndView("DashBoard.jsp");
				modelAndView.addObject("medicines", medicines);
				return modelAndView;
			} else {
				ModelAndView modelAndView = new ModelAndView("DashBoard2.jsp");
				modelAndView.addObject("message", "Medicines unavailable");
				return modelAndView;
			}
		} else {
			return logIn();
		}

	}

	@RequestMapping("/showUser")
	public ModelAndView showUser(HttpServletRequest req) {
		User user = (User) req.getSession().getAttribute("user");
		if (user != null) {
			ModelAndView modelAndView = new ModelAndView("DashBoard3.jsp");
			modelAndView.addObject("user", Arrays.asList(user));
			return modelAndView;
		} else {
			return logIn();
		}
	}

	@RequestMapping("/logOut")
	public ModelAndView logOut(HttpServletRequest req) {
		req.getSession().invalidate();
		return logIn();
	}

}
