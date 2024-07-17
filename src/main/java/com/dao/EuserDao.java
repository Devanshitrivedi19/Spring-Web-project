package com.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bean.eUserBean;

@Repository
public class EuserDao {

	@Autowired 
	JdbcTemplate stmt; 

	public void insertUser(eUserBean userBean) {
		
		stmt.update("insert into users(firstName,email,password,profilePicpath) values (?,?,?,?) ", userBean.getFirstName(),
				userBean.getEmail(), userBean.getPassword(), userBean.getProfilePicPath());

	}


	public eUserBean authenticate(String email, String password) {
		// select * from users where email = ? and password = ?
		try {
			eUserBean userBean = stmt.queryForObject("select * from users where email = ? and password = ?",
					new BeanPropertyRowMapper<>(eUserBean.class), new Object[] { email, password });

			return userBean;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return null;
	}

}
