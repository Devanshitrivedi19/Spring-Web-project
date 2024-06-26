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

    public void addProduct(eProductBean productbean) {
        stmt.update("INSERT INTO products (productName, category, qty, price) VALUES (?, ?, ?, ?)",
                productbean.getProductName(), productbean.getCategory(), productbean.getQty(), productbean.getPrice());
    }

    public List<eProductBean> getAllProducts() {
        List<eProductBean> list = stmt.query("SELECT * FROM products", new BeanPropertyRowMapper<>(eProductBean.class));
        return list;
    }

    public void deleteProduct(Integer ProductId) {
        stmt.update("DELETE FROM products WHERE productId = ?", ProductId);
    }

    public void deleteProductByName(String productName) {
        stmt.update("DELETE FROM products WHERE productName = ?", productName);
    }
}
