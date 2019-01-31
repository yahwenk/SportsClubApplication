package nus.iss.team2.exception;

public class UserBlockedException extends Exception {

	//create User object without error description
	public UserBlockedException() {

	}
	//create User object with error description
	public UserBlockedException(String errDesc) {
		super(errDesc);
	}
}
