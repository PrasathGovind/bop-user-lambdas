package com.bop.user.DAO;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.amazonaws.services.dynamodbv2.document.spec.GetItemSpec;
import com.bop.configs.DynamoDBConfig;
import com.bop.user.beans.UserDTO;

public class UserDAO {
	
	
	private DynamoDBConfig dynamoDBConfig;
	
	
	private DynamoDBMapper dynamoDBMapper;
	
	
	private DynamoDB dynamoDB;

	
	public UserDAO() {
		
		dynamoDBConfig = new DynamoDBConfig();
		
		dynamoDBMapper = dynamoDBConfig.getDynamoDBMapper();
		
		dynamoDB = dynamoDBConfig.getDynamoDB();
		
	}
	
	public void registerUser(UserDTO userDTO) {
		
		dynamoDBMapper.save(userDTO);
		
		System.out.println("dynamoDBConfig : "+dynamoDBConfig);
		
	}
	
	/*
	public Item getUser(String mobileNumber){
		
		Table table = dynamoDB.getTable("user");
		
		Item item = table.getItem(new GetItemSpec().withPrimaryKey("mobileNumber",mobileNumber));
		
		return item;
	}
	*/
	

}
