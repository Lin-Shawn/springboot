package com.myproject.shawn.demo.entity;

import java.io.Serializable;

/** 
 * @author linx
 * @date 2019年4月22日下午5:15:20
 */
public class User implements Serializable{
	
	private static final long serialVersionUID = 6714014585805728867L;
	
	private Long id;
	private String userName;
	private String password;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
