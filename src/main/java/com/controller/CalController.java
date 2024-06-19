package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.bean.CalcBean;

@Controller
public class CalController 
{
	@GetMapping("/Calculate")
	public String Calculate()
	{
		return "Calculate";
	}
	@PostMapping("/add")
	public String add(CalcBean calcbean,Model model)
	{
		int result;
		result=calcbean.getNo1()+calcbean.getNo2();
		model.addAttribute("cal",calcbean);
		model.addAttribute("result",result);
		return "AddAns";
	}
}
