package com.pradeep.service;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.powermock.api.mockito.PowerMockito;

import com.pradeep.dao.UserDao;
import com.pradeep.dao.UserDaoImpl;
import com.pradeep.service.UserServiceImpl;

public class UserServiceTest {
@Test
	public void testGetNameByUserId() {
		UserDaoImpl mockDao=PowerMockito.mock(UserDaoImpl.class);
		PowerMockito.when(mockDao.findNameById(101)).thenReturn("Shikher");
	
		UserServiceImpl service =new UserServiceImpl(mockDao);
		String name=service.getNameByUserId(101);
		System.out.println(name);
		assertEquals("Shikher", name);
	}
@Test
public void testGetEmailUserId() {
	
	UserDaoImpl mockDao=PowerMockito.mock(UserDaoImpl.class);
	PowerMockito.when(mockDao.findEmailById(101)).thenCallRealMethod();
	UserServiceImpl service=new UserServiceImpl(mockDao);
	String email=service.getEmailByUserId(101);
	System.out.println(email);
	assertEquals("pradeep.k@gmail.com", email);
}
}
