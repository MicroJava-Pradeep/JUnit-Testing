package com.pradeep.dao;

public class UserDaoImpl implements UserDao {
	

	public String findNameById(Integer id) {
		System.out.println("findNameById() method is called");
		return "Pradeep";
	}

	public String findEmailById(Integer id) {
		System.out.println("findEmailById() method is called ");
		return "pradeep.k@gmail.com";
	}

}
