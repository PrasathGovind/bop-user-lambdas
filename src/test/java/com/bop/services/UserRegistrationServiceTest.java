package com.bop.services;

import org.junit.Assert;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.bop.user.DAO.UserDAO;
import com.bop.user.beans.User;
import com.bop.user.services.UserRegistrationService;
import com.bop.utils.EmailUtils;

public class UserRegistrationServiceTest {
	
	UserDAO userDAO = new UserDAO();
	
	EmailUtils emailUtils = new EmailUtils();
	
	@Test
	public void registerUser() {
		
		UserRegistrationService userRegistrationService = new UserRegistrationService();
		
		User user = getUser();
		
		Context mockContext = mock(Context.class);
		
		Assert.assertTrue(mockContext!=null);
		
		LambdaLogger mockLambdaLogger = mock(LambdaLogger.class);
		
		Assert.assertTrue(mockLambdaLogger!=null);
		
		when(mockContext.getLogger()).thenReturn(mockLambdaLogger);
		
		Context outputContext = userRegistrationService.registerUser(user, mockContext);
		
		Assert.assertTrue(outputContext!=null);
		
	}
	
	public User getUser() {
		
		User user = new User();
		
		user.setEmailId("testHello@mailinator.com");
		
		user.setMobileNumber("+982321321");
		
		user.setUserName("Test User");
		
		return user;
	}
	
}
