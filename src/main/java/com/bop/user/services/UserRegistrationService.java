package com.bop.user.services;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.bop.user.DAO.UserDAO;
import com.bop.user.beans.User;
import com.bop.user.beans.UserDTO;
import com.bop.user.exceptions.APIException;
import com.bop.user.exceptions.ErrorConstants;
import com.bop.utils.EmailUtils;

public class UserRegistrationService {
	
	UserDAO userDAO = new UserDAO();
	
	EmailUtils emailUtils = new EmailUtils();
		
	public Context registerUser(User user, Context context){
		
		LambdaLogger logger = context.getLogger();
		
		logger.log("Inside UserRegistrationService ...");
		
		if(user==null) {
			throw new APIException(ErrorConstants.REQUEST_JSON_VALIDATION_FAILURE, "The request Json is Empty!");
		}
		
		if(user!=null && (user.getMobileNumber()==null || user.getMobileNumber().isEmpty() || user.getEmailId().isEmpty() || user.getEmailId()==null)) {
			throw new APIException(ErrorConstants.USER_REGISTRATION_REJECTED,"Mobile Number are Email Id are mandatory!");
		}
		
		UserDTO userDTO = new UserDTO();
		
		userDTO.setUserName(user.getUserName());
		
		userDTO.setEmailId(user.getEmailId());
		
		userDTO.setMobileNumber(user.getMobileNumber());
		
		userDAO.registerUser(userDTO);
		
		logger.log("Exit UserRegistrationService.");
		
		emailUtils.sendEmail(user.getEmailId());
		
		return context;
		
	}
	

}
