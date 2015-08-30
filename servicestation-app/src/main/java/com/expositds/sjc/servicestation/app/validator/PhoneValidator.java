/*package com.expositds.sjc.servicestation.app.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import com.expositds.sjc.servicestation.domain.model.PreOrder;

public class PhoneValidator implements Validator{
	@Override
	public boolean supports(Class<?> paramClass) {
		return PreOrder.class.equals(paramClass);
	}
	@Override
	public void validate(Object obj, Errors errors) {
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "contactData", "clientContactData.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "problemDescription", "clientproblemDescription.required");
    	
	}
}*/