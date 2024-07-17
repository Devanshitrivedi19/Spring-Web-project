package com.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bean.eProductBean;

@Repository
public class EProductDao {

	@Autowired
	JdbcTemplate stmt;

	public void addProduct(eProductBean productBean) {
		stmt.update("insert into products (productName,category,price,qty,productImagePath) values (?,?,?,?,?) ",
				productBean.getProductName(), productBean.getCategory(), productBean.getPrice(), productBean.getQty(),productBean.getProductImagePath());
	}

	public List<eProductBean> getAllProducts() {
		List<eProductBean> list = stmt.query("select * from products",
				new BeanPropertyRowMapper<eProductBean>(eProductBean.class));
		return list;
	}

	public void deleteProduct(Integer productId) {
		stmt.update("delete from products where productId = ? ", productId);
	}

	public eProductBean getProductById(Integer productId) {

		eProductBean bean = stmt.queryForObject("select * from products where productId = ? ",
				new BeanPropertyRowMapper<>(eProductBean.class), new Object[] { productId }); // name color
		return bean;
	}
}
