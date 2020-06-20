package com.pradeep.service;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.powermock.api.mockito.PowerMockito;

import com.pradeep.dao.UserDao;
import com.pradeep.service.UserServiceImpl;

public class UserServiceTest {
@Test
	public void testGetNameByUserId() {
		UserDao mockDao=PowerMockito.mock(UserDao.class);
		PowerMockito.when(mockDao.findNameById(101)).thenReturn("Shikher");
	
		UserServiceImpl service =new UserServiceImpl(mockDao);
		String name=service.getNameByUserId(101);
		System.out.println(name);
		assertEquals("Shikher", name);
	}
@Test
public void testGetEmailUserId() {
	
	UserDao mockDao=PowerMockito.mock(UserDao.class);
	PowerMockito.when(mockDao.findEmailById(101)).thenReturn("microjavapk@gmail.com");
	UserServiceImpl service=new UserServiceImpl(mockDao);
	String email=service.getEmailByUserId(101);
	System.out.println(email);
	assertEquals("microjavapk@gmail.com", email);
}
}
