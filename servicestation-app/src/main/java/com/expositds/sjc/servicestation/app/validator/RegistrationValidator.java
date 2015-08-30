package com.expositds.sjc.servicestation.app.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import com.expositds.sjc.servicestation.domain.model.Logginer;

/**
*
*@author Rybakov Sergey
**/

public class RegistrationValidator implements Validator{
	@Override
	public boolean supports(Class<?> paramClass) {
		return Logginer.class.equals(paramClass);
	}
	@Override
	public void validate(Object obj, Errors errors) {
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "clientName.required");    	
    	ValidationUtils.rejectIfEmptyOrWhitespace(errors, "login", "clientLogin.required");
    	ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "clientPassword.required");
    	
	}
}