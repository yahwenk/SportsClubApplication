package nus.iss.team2.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.NOT_FOUND, reason="No such Booking")

public class BookingNotFoundException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;

}
