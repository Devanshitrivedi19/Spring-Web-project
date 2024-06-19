package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.bean.eProductBean;
import com.dao.EProductDao;

@Controller
public class EProductController {
	
	@Autowired
	EProductDao productDao;
	
	@GetMapping("/newProduct")
	public String newProduct()
	{
		return "NewProduct";
	}
	
	@PostMapping("/saveProduct")
	public String SaveProduct(eProductBean productbean)
	{
		
			productDao.addProduct(productbean);
			return "Welcome";
	}
}
