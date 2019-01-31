package nus.iss.team2.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import nus.iss.team2.model.User;

@Component
public class UserValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return User.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		User u = (User) target;
		ValidationUtils.rejectIfEmpty(errors, "userID", "error.user.userid.empty");
		ValidationUtils.rejectIfEmpty(errors, "firstName", "error.user.name.empty");
		ValidationUtils.rejectIfEmpty(errors, "lastName", "error.user.name.empty");
		ValidationUtils.rejectIfEmpty(errors, "password", "error.user.password.empty");
		ValidationUtils.rejectIfEmpty(errors, "phone", "error.user.phone.empty");
		ValidationUtils.rejectIfEmpty(errors, "address", "error.user.address.empty");
		ValidationUtils.rejectIfEmpty(errors, "email", "error.user.email.empty");
		ValidationUtils.rejectIfEmpty(errors, "age", "error.user.age.empty");
		ValidationUtils.rejectIfEmpty(errors, "gender", "error.user.gender.empty");
		ValidationUtils.rejectIfEmpty(errors, "memberID", "error.user.memberID.empty");
		
		System.out.println(u.toString());
	}

}
