package com.bop.user.services;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.bop.user.DAO.UserDAO;
import com.bop.user.beans.User;
import com.bop.user.beans.UserDTO;
import com.bop.utils.EmailUtils;

public class UserRegistrationService {
	
	UserDAO userDAO = new UserDAO();
	
	EmailUtils emailUtils = new EmailUtils();
		
	public Context registerUser(User user, Context context){
		
		LambdaLogger logger = context.getLogger();
		
		logger.log("Inside UserRegistrationService ...");
		
		if(user==null) {
			throw new RuntimeException("[BankOfPrazyException] The request Json is Empty!");
			//throw new APIException(ErrorConstants.REQUEST_JSON_VALIDATION_FAILURE, "The request Json is Empty!");
		}
		
		if(user!=null && (user.getMobileNumber()==null || user.getMobileNumber().isEmpty() || user.getEmailId().isEmpty() || user.getEmailId()==null)) {
			throw new RuntimeException("[BankOfPrazyException] Mobile Number and Email Id are mandatory! One or more of the fields is missing.");
		}
		
		UserDTO userDTO = new UserDTO();
		
		userDTO.setUserName(user.getUserName());
		
		userDTO.setEmailId(user.getEmailId());
		
		userDTO.setMobileNumber(user.getMobileNumber());
		
		userDAO.registerUser(userDTO);
				
		try {
			emailUtils.sendEmail(user.getEmailId());
			emailUtils.postEmailtoSQS();
		}
		catch (Exception ex){
			logger.log("Exception thrown while sending User Registration Email! ex="+ex.getMessage());
		}
		
		logger.log("Exit UserRegistrationService.");
		
		return context;
		
	}
	

}
