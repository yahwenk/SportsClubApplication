package nus.iss.team2.service;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import nus.iss.team2.model.Booking;

public interface BookingService {
	
	ArrayList<Booking> findAllBooking();

	

	Booking createBooking(Booking s);

	Booking updateBooking(Booking s);

	void cancelBooking(Booking s);

	ArrayList<Booking> findBookingByCriteria(Booking booking);
	
	ArrayList<Booking> bookingHistory(String userid);
	
	ArrayList<Booking> bookingHistoryByFacID(String userid);
	
	List<String> getBookedTs(int facid, Date bd);

	Booking findBookingByID(int id);
	
//	ArrayList<Booking> updateUserID();

}
