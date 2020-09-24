package com.bop.utils;

import org.junit.Assert;
import org.junit.Test;

public class StringUtilsTest {
	
	
	@Test
	public void getDynamoDBaKey() {
		
		String expectedKey = "AKIAZH6W6RY" + "TT4NEOEYN";
		String actualKey = StringUtils.getDynamoDBaKey();
		
		Assert.assertEquals(expectedKey, actualKey);

	}
	
	@Test
	public void getDynamoDBsKey() {
		
		String expectedKey = "Eyl6z26nNCoRb" + "Z6m1FEaD7En8d2" + "tnYzdslw76n98";
		String actualKey = StringUtils.getDynamoDBsKey();
		
		Assert.assertEquals(expectedKey, actualKey);
	}
	
	@Test
	public void getSESaKey() {
		
		String expectedKey = "AKIAZH6W6R" + "YT4NSKN3E6";
		String actualKey = StringUtils.getSESaKey();
		
		Assert.assertEquals(expectedKey, actualKey);
	}
	
	@Test
	public void getSESsKey() {
		
		String expectedKey = "BFDX05JvfR87h5s" + "/pKUEV4RknyWUpb" + "PUipBYXGdoRksG" ;
		String actualKey = StringUtils.getSESsKey();
		
		Assert.assertEquals(expectedKey, actualKey);		
	}
	
	@Test
	public void  getDynamoDBEndpoint() {
		
		String expectedKey = "dynamodb.us-east-2.amazonaws.com";
		String actualKey = StringUtils.getDynamoDBEndpoint();
		
		Assert.assertEquals(expectedKey, actualKey);
	}
	
	@Test
	public void getDynamoDBRegion() {
		
		String expectedKey = "us-east-2";
		String actualKey = StringUtils.getDynamoDBRegion();
		
		Assert.assertEquals(expectedKey, actualKey);	
	}
	
	@Test
	public void getSESEndpoint() {
		
		String expectedKey = "email-smtp.us-east-2.amazonaws.com";
		String actualKey = StringUtils.getSESEndpoint();
		
		Assert.assertEquals(expectedKey, actualKey);
	}

}
