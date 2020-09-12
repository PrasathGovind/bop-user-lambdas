package com.bop;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Greetings implements RequestHandler<Object, String> {
	
	Gson gson = new GsonBuilder().setPrettyPrinting().create();

	// com.bop.Greetings::handleRequest
	public String handleRequest(Object input, Context context) {
		
		LambdaLogger logger = context.getLogger();
		
        context.getLogger().log("User : " + input);
        
        logger.log("ENVIRONMENT VARIABLES: " + gson.toJson(System.getenv()));
        logger.log("CONTEXT: " + gson.toJson(context));
        
        return "Welcome to Bank of Prazy, " + input;	
	}
	
}
