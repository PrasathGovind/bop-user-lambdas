package com.bop;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Assert;
import org.junit.Test;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.bop.user.beans.User;
import com.bop.user.services.UserRegistrationService;
import com.google.gson.Gson;

public class UserRegistrationLambdaTest {
	
	Gson gson = new Gson();
	
	UserRegistrationService userRegistrationService = new UserRegistrationService();
	
	@Test
	public void handleRequest() {
		
		User user = getUser();
		
		Context mockContext = mock(Context.class);
		
		Assert.assertTrue(mockContext!=null);
		
		LambdaLogger mockLambdaLogger = mock(LambdaLogger.class);
		
		Assert.assertTrue(mockLambdaLogger!=null);
		
		when(mockContext.getLogger()).thenReturn(mockLambdaLogger);
		
		UserRegistrationLambda userRegistrationLambda = new UserRegistrationLambda();
		
		Context outputContext = userRegistrationLambda.handleRequest(user, mockContext);
		
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
