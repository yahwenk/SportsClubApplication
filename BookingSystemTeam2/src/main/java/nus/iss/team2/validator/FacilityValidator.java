   package nus.iss.team2.validator;

	import org.springframework.stereotype.Component;
	import org.springframework.validation.Errors;
	import org.springframework.validation.ValidationUtils;
	import org.springframework.validation.Validator;

import nus.iss.team2.model.Facility;


	@Component
	public class FacilityValidator implements Validator {

		@Override
		public boolean supports(Class<?> clazz) {
			return Facility.class.isAssignableFrom(clazz);
		}

		@Override
		public void validate(Object target, Errors errors) {
			Facility f = (Facility) target;
			ValidationUtils.rejectIfEmpty(errors, "facilityID", "error.Facility.facilityID.empty");
			ValidationUtils.rejectIfEmpty(errors, "facilityName", "error.Facility.facilityName.empty");
			ValidationUtils.rejectIfEmpty(errors, "status", "error.Facility.status.empty");
			System.out.println(f.toString());
		}

	}



