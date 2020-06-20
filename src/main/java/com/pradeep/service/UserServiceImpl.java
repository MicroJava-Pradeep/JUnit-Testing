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
	
	public void doProcess() {
		System.out.println("doProcess() method started");
		pushMsgTokafkaTopic("msg");
		System.out.println("doProcess() method stop");
	}
	public void pushMsgTokafkaTopic(String msg) {
		System.out.println("msg pushing to kafka...");
	}
	// private method
	private String formatMsg(String msg) {
		System.out.println("formatMsg() is called");
		return msg.toUpperCase();
	}
	
	
}
