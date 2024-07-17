package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import com.bean.eUserBean;
import com.dao.EuserDao;
import com.service.FileUploadService;

import jakarta.servlet.http.HttpSession;

@Controller
public class EcomSessionController {

	@Autowired
	EuserDao userDao;

	@Autowired
	FileUploadService fileUploadService;

	@GetMapping(value = { "/", "elogin" })
	public String welcome() {
		return "EcomLogin";
	}

	@PostMapping("/elogin")
	public String eLogin(eUserBean userBean, Model model, HttpSession session) {

		eUserBean dbUser = userDao.authenticate(userBean.getEmail(), userBean.getPassword());
		if (dbUser == null) {
			model.addAttribute("error", "Invalid Credentials");
			return "EcomLogin";
		} else {

			session.setAttribute("user", dbUser);
			model.addAttribute("firstName", dbUser.getFirstName());
			model.addAttribute("profilePicPath", dbUser.getProfilePicPath());
			return "EcomHome";
		}
	}

	@GetMapping("/esignup")
	public String signup() {
		return "EcomSignup";
	}

	@PostMapping("/esignup")
	public String signupPost(eUserBean userBean) {

		fileUploadService.uploadUserImage(userBean.getProfilePic(), userBean.getEmail());
		userBean.setProfilePicPath(
				"images//profilepic//" + userBean.getEmail() + "//" + userBean.getProfilePic().getOriginalFilename());
		userDao.insertUser(userBean);

		return "EcomLogin";
	}

	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/elogin";
	}
}
