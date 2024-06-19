package com.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bean.eProductBean;

@	Repository
public class EProductDao {

	@Autowired
	JdbcTemplate stmt;
	
	public void addProduct(eProductBean productbean)
	{
		stmt.update("insert into products(productName,category,qty,price) values(?,?,?,?)",productbean.getProductName(),productbean.getCategory(),productbean.getQty(),productbean.getPrice());
	}
}
