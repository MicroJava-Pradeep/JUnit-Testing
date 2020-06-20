package com.pradeep.service;

import com.pradeep.dao.UserDao;

public class UserServiceImpl {

	private UserDao dao;
	public UserServiceImpl(UserDao dao) {
		this.dao=dao;
	}
	
	public UserServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	public String getNameByUserId(Integer id) {
	 String name= dao.findNameById(id);
	
	return name;

	}
	public String getEmailByUserId(Integer id) {
		String email=dao.findEmailById(id);
		return email;	
	}
	
	
}
