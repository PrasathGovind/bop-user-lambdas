package com.bop.configs;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.bop.utils.StringUtils;



public class DynamoDBConfig {
	
	private String aKey = StringUtils.getDynamoDBaKey();
	
	private String sKey = StringUtils.getDynamoDBsKey();
	
	private String awsRegion = StringUtils.getDynamoDBRegion();
	
	private String awsDynamoDbEndpoint = StringUtils.getDynamoDBEndpoint();
	
	public DynamoDB getDynamoDB() {
		return new DynamoDB(getAmazonDynamoDB());
	}
	
	public DynamoDBMapper getDynamoDBMapper() {
		return new DynamoDBMapper(getAmazonDynamoDB());		
	}
	
	private AmazonDynamoDB getAmazonDynamoDB() {
		
		AmazonDynamoDB amazonDynamoDB = AmazonDynamoDBClientBuilder.standard()
			.withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration(awsDynamoDbEndpoint, awsRegion))
			.withCredentials(new AWSStaticCredentialsProvider(new BasicAWSCredentials(aKey, sKey)))
			.build();
		
		return amazonDynamoDB;
	}

	@Override
	public String toString() {
		return "DynamoDBConfig [aKey=" + aKey + ", sKey=" + sKey + ", awsRegion="
				+ awsRegion + ", awsDynamoDbEndpoint=" + awsDynamoDbEndpoint + "]";
	}
	
}
