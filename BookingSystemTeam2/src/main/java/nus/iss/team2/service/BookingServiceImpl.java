package nus.iss.team2.service;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;


import org.springframework.transaction.annotation.Transactional;

import nus.iss.team2.model.Booking;
import nus.iss.team2.repository.BookingRepository;

@Service
public class BookingServiceImpl implements BookingService{

	@Resource
	BookingRepository bookingrepo;

	@Override
	@Transactional
	public ArrayList<Booking> findAllBooking() {
		return (ArrayList<Booking>) bookingrepo.findAll();
	}

	
	@Override
	@Transactional
	public Booking createBooking(Booking s) {
		return bookingrepo.saveAndFlush(s);
	}

	@Override
	@Transactional
	public Booking updateBooking(Booking s) {
		return bookingrepo.saveAndFlush(s);
	}

	@Override
	@Transactional
	public void cancelBooking(Booking s) {
		bookingrepo.delete(s);
		
	}

	@Override
	@Transactional
	public ArrayList<Booking> findBookingByCriteria(Booking booking) {
		return null;
	}


	
	@Override
	@Transactional
	public List<String> getBookedTs(int facid, Date bd) {


		return bookingrepo.getBookedTs(facid, bd);
	}

	@Override
	@Transactional
	public Booking findBookingByID(int id) {
		
		return bookingrepo.findBooking(id);
	}

	@Override
	@Transactional
	public ArrayList<Booking> bookingHistory(String userid) {
		
		return (ArrayList<Booking>) bookingrepo.bookingHistory(userid);
	}

	@Override
	@Transactional
	public ArrayList<Booking> bookingHistoryByFacID(String userid) {
		
		return (ArrayList<Booking>) bookingrepo.bookingHistoryByFacID(userid);
	}
	
	
	

//	@Override
//	public ArrayList<Booking> updateUserID() {
//		// TODO Auto-generated method stub
//		return (ArrayList<Booking>) bookingrepo.updateUserID();
	}






