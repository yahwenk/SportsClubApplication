package nus.iss.team2.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import nus.iss.team2.model.Booking;

@Component
public class BookingValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		return Booking.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Booking b = (Booking) target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "bookingID", "error.booking.bookingid.empty ");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "bookingDate", "error.booking.bookingdate.empty ");
		System.out.println(b.toString());
		
	}

}
