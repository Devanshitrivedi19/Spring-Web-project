package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.bean.eProductBean;
import com.dao.EProductDao;

@Controller
public class EProductController {

    @Autowired
    EProductDao productDao;

    @GetMapping("/newProduct")
    public String newProduct() {
        return "NewProduct";
    }

    @PostMapping("/saveProduct")
    public String saveProduct(@ModelAttribute("productbean") eProductBean productbean) {
        productDao.addProduct(productbean);
        return "redirect:/products";
    }

    @GetMapping("/products")
    public String listProducts(Model model) {
        List<eProductBean> products = productDao.getAllProducts();
        model.addAttribute("products", products);
        return "EcomListProducts";
    }

    @GetMapping("/deleteProduct")
    public String deleteProduct(@RequestParam("ProductId") Integer ProductId) {
        System.out.println("deleteProduct()==>" + ProductId);
        productDao.deleteProduct(ProductId);
        return "redirect:/products";
    }
    @GetMapping("/searchProductByName") 
	public String searchProductByName() 
    {
		return "DeleteProductByName";
	}
    @PostMapping("/deleteProductByName")
    public String deleteProductByName(@RequestParam("productName") String productName) {
        System.out.println("deleteProductByName() ==> " + productName);
        productDao.deleteProductByName(productName);
        return "redirect:/products";
    }
    }
