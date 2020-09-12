package com.bop;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.bop.user.beans.User;
import com.bop.user.services.UserRegistrationService;
import com.google.gson.Gson;

// com.bop.UserRegistrationLambda::handleRequest

public class UserRegistrationLambda implements RequestHandler<User, Context> {
	
	Gson gson = new Gson();
	
	UserRegistrationService userRegistrationService = new UserRegistrationService();
	
	public Context handleRequest(User user, Context context) {
		
		LambdaLogger logger = context.getLogger();
		
		logger.log("Inside UserRegistrationLambda....");
		
		logger.log("Request received, user : "+user);
				
		context = userRegistrationService.registerUser(user, context);
		
		String msg = "User Registration initiated successfully!";
		
		String jsonResponse = "{ \"msg\":\""+msg+"\" }";
		
		logger.log("jsonResponse : "+jsonResponse);
		
		logger.log("Exit UserRegistrationLambda.");

		return context;
	}


}
