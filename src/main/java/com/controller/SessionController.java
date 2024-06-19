package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.bean.UserBean;

@Controller
public class SessionController {

	@GetMapping("/login")
	public String Login()
	{
		return "Login";
	}
	@GetMapping("/signup")
	public String SignUp()
	{
		return "SignUp";
	}
	@GetMapping("/fp")
	public String forgetPwd()
	{
		return "forgetPassword";
	}
	@PostMapping("/SaveUser")
	public String SaveUser(UserBean userbean, Model model)
	{
//		System.out.println("Username: "+userbean.getUsername());
//		System.out.println("Email: "+userbean.getEmail());
//		System.out.println("Password: "+userbean.getPwd());
		
		model.addAttribute("user",userbean);
		return "Home";
	}
}
