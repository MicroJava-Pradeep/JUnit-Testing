package com.pradeep.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyString;

import java.lang.reflect.Method;

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
 @Test
 public void testdoProcess() {
	
	UserServiceImpl mockService = PowerMockito.mock(UserServiceImpl.class);
	try {
		PowerMockito.doNothing().when(mockService, "pushMsgTokafkaTopic", "msg");
		mockService.doProcess();	
	}catch (Exception e) {
		e.printStackTrace();
	}
  }

	
	/*
	 * @Test public void testFormatMsag() throws Exception {
	 * PowerMockito.spy(UserServiceImpl.class);
	 * PowerMockito.when(UserServiceImpl.class, "formatMsg", anyString() )
	 * .thenReturn("TEST MSG FORMATTED"); }
	 */
  @Test
  public void testFormatMsg() throws Exception {
		Class<?> clz=Class.forName("com.pradeep.service.UserServiceImpl");
		Object obj=clz.newInstance();
		Method method=clz.getDeclaredMethod("formatMsg", String.class);
		method.setAccessible(true);// making method visible
		Object returnVal=method.invoke(obj, "test msg");
		String expected="TEST MSG";
		assertEquals(expected, returnVal);
	}
}


