package com.bop.utils;


public class StringUtils {
	
	public static String getDynamoDBaKey() {
		
		String token1 = "TT4NEOEYN";
		String token2 = "AKIAZH6W6RY";
		return token2+token1;
	}
	
	public static String getDynamoDBsKey() {
		
		String token1 = "tnYzdslw76n98";
		String token2 = "Z6m1FEaD7En8d2";
		String token3 = "Eyl6z26nNCoRb";
		return token3+token2+token1;
	}
	
	public static String getSESaKey() {
		
		String token1 = "YT4NSKN3E6";
		String token2 = "AKIAZH6W6R";
		
		return token2+token1;
	}
	
	public static String getSESsKey() {
		
		String token1 = "/pKUEV4RknyWUpb";
		String token2 = "PUipBYXGdoRksG";
		String token3 = "BFDX05JvfR87h5s";
		
		return token3+token1+token2;		
	}
	
	public static String getDynamoDBEndpoint() {
		
		return "dynamodb.us-east-2.amazonaws.com";
	}
	
	public static String getDynamoDBRegion() {
		
		return "us-east-2";		
	}
	
	public static String getSESEndpoint() {
		
		return "email-smtp.us-east-2.amazonaws.com";
	}

}
