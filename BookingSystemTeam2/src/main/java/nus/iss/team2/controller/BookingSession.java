package nus.iss.team2.controller;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import nus.iss.team2.model.Booking;
import nus.iss.team2.model.User;

@Component
@Scope(value="session", proxyMode=ScopedProxyMode.TARGET_CLASS)
public class BookingSession {
	private Booking booking=null;

	public BookingSession(Booking booking) {
		super();
		this.booking = booking;
	}

	public BookingSession() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Booking getBooking() {
		return booking;
	}

	public void setBooking(Booking booking) {
		this.booking = booking;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((booking == null) ? 0 : booking.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BookingSession other = (BookingSession) obj;
		if (booking == null) {
			if (other.booking != null)
				return false;
		} else if (!booking.equals(other.booking))
			return false;
		return true;
	}

	
	

}
