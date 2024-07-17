package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.service.FileUploadService;
import com.bean.eProductBean;
import com.dao.EProductDao;

@Controller
public class EProductController {

	@Autowired
	EProductDao productDao;

	@Autowired
	FileUploadService fileUploadService; 
	
	
	@GetMapping("/newproduct") 
	public String newProduct() {
		return "NewProduct";
	}

	@PostMapping("/saveproduct")
	public String saveProduct(eProductBean productBean, @RequestParam("masterImage") MultipartFile masterImage) {

		fileUploadService.uploadProductImage(masterImage);
		productBean.setProductImagePath("images//products//"+ masterImage.getOriginalFilename());
		productDao.addProduct(productBean);

		return "redirect:/products";

	}

	@GetMapping("/products")
	public String listProducts(Model model) {
		List<eProductBean> products = productDao.getAllProducts();

		model.addAttribute("products", products);

		return "EcomListProducts";
	}

	@GetMapping("/deleteproduct")
	public String deleteProduct(@RequestParam("productId") Integer productId) {

		System.out.println("deleteProduct() => " + productId);

		productDao.deleteProduct(productId);
		return "redirect:/products";// do not open jsp

	}
	@GetMapping("/viewproduct")
	public String viewProduct(@RequestParam("productId") Integer productId, Model model) {

		eProductBean productBean = productDao.getProductById(productId);
		model.addAttribute("product", productBean);

		return "ViewProduct";
	}
}
