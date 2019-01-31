package nus.iss.team2.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import nus.iss.team2.exception.BookingNotFoundException;
import nus.iss.team2.model.Booking;
import nus.iss.team2.model.Facility;
import nus.iss.team2.repository.BookingRepository;
import nus.iss.team2.repository.FacilityRepository;
import nus.iss.team2.repository.UserRepository;
import nus.iss.team2.service.BookingService;
import nus.iss.team2.service.FacilityService;
import nus.iss.team2.validator.BookingValidator;

@Controller
@RequestMapping(value = "/booking")

public class BookingController {

	@Autowired
	private BookingService bService;
	@Autowired
	private FacilityService fservice;
	@Autowired
	private BookingValidator bValidator;
	
	@InitBinder("booking")
	private void initBookingBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
		binder.addValidators(bValidator);
	}


	// admin
	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public ModelAndView viewBookingByAdmin(HttpSession session) {
		UserSession us = (UserSession) session.getAttribute("USERSESSION");
		ModelAndView mav = new ModelAndView("booking-admin");
		ArrayList<Booking> adminbooking = bService.findAllBooking();

		mav.addObject("bhistory", adminbooking);

		return mav;
	}

	@RequestMapping(value = "/admin/edit/{id}", method = RequestMethod.GET)
	public ModelAndView admineditBooking(@PathVariable int id) {
		ModelAndView mav = new ModelAndView("booking-edit-admin");
		Booking booking = bService.findBookingByID(id);
		mav.addObject("booking", booking);
		ArrayList<Facility> facility = fservice.findAllFacilityBooking();
		mav.addObject("facility", facility);
		return mav;
	}

	@RequestMapping(value = "/admin/edit/{id}", method = RequestMethod.POST)
	public ModelAndView admineditBookingPage(@ModelAttribute @Valid Booking booking, BindingResult result,
			final RedirectAttributes redirectAttributes) {
		ModelAndView mav = new ModelAndView("redirect:/booking/admin");
		booking.setStatus(Booking.UPDATED);
		bService.updateBooking(booking);
		return mav;
	}

	@RequestMapping(value = "admin/delete/{id}", method = RequestMethod.GET)
	public ModelAndView adminDeleteCourse(@PathVariable int id, final RedirectAttributes redirectAttributes,
			HttpSession session) throws BookingNotFoundException {

		ModelAndView mav = new ModelAndView("redirect:/booking/admin");
		Booking book = bService.findBookingByID(id);
		book.setStatus(Booking.CANCELLED);
		bService.updateBooking(book);
		return mav;
	}

}




//@RequestMapping(value = "/history", method = RequestMethod.GET)
//public ModelAndView BookingHistory(HttpSession session) {
//	UserSession us = (UserSession) session.getAttribute("USERSESSION");
//	ModelAndView mav = new ModelAndView("booking-history");
//	ArrayList<Booking> userbookings = bService.bookingHistory(us.getUser().getUserID());
//	ArrayList<Facility> facs = fservice.findFacilityName("");
//	HashMap<String, String> facilities = new HashMap<String, String>();
//	for (Facility fac : facs) {
//		facilities.put(fac.getFacilityID(), fac.getFacilityName());
//	}
//	mav.addObject("bhistory", userbookings);
//	session.setAttribute("fac", facilities);
//	return mav;
//}
//
//@RequestMapping(value = "/booking", method = RequestMethod.GET)
//public ModelAndView newBookingGet() {
//	ModelAndView mav = new ModelAndView("booking", "booking", new Booking());
//	ArrayList<Facility> facility = fservice.findAllFacilityBooking();
//	mav.addObject("facility", facility);
//	return mav;
//}
//
//@RequestMapping(value = "/make", method = RequestMethod.POST)
//public ModelAndView createNewBooking(@ModelAttribute @Valid Booking booking, BindingResult result,
//		final RedirectAttributes redirectAttributes, HttpSession session, HttpServletRequest req,
//		@RequestParam("facilityID") String facId) {
//
//	ModelAndView mav = new ModelAndView();
//	// ArrayList<Facility> facility=fservice.findFacility(facId);
//	// mav.addObject("fac", facility);
//	UserSession us = (UserSession) session.getAttribute("USERSESSION");
//	booking.setUserID(us.getUser().getUserID());
//	booking.setStatus(Booking.APPROVED);
//	bService.createBooking(booking);
//	mav.setViewName("redirect:/booking/history");
//	return mav;
//}
//
//@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
//public ModelAndView editBooking(@PathVariable String id) {
//	ModelAndView mav = new ModelAndView("booking-edit");
//	Booking booking = bService.findBookingByID(id);
//	mav.addObject("booking", booking);
//	ArrayList<Facility> facility = fservice.findAllFacilityBooking();
//	mav.addObject("facility", facility);
//	return mav;
//}
//
//@RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
//public ModelAndView editEmployee(@ModelAttribute @Valid Booking booking, BindingResult result,
//		@PathVariable String id, final RedirectAttributes redirectAttributes) {
//
//	ModelAndView mav = new ModelAndView("redirect:/booking/history");
//	booking.setStatus(Booking.UPDATED);
//
//	bService.updateBooking(booking);
//	return mav;
//}
//
// @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
// public ModelAndView editBookingPage(@ModelAttribute Booking booking,
// @PathVariable String id, BindingResult result,
// final RedirectAttributes redirectAttributes) throws BookingNotFoundException
// {
// ModelAndView mav = new ModelAndView("redirect:/booking/history");
// booking.setUserID("1");
// booking.setStatus(Booking.UPDATED);
// bService.updateBooking(booking);
//
// return mav;
// }
//
//@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
//public ModelAndView deleteCourse(@PathVariable String id, final RedirectAttributes redirectAttributes,
//		HttpSession session) throws BookingNotFoundException {
//
//	ModelAndView mav = new ModelAndView("redirect:/booking/history");
//	Booking book = bService.findBookingByID(id);
//	book.setStatus(Booking.CANCELLED);
//	bService.updateBooking(book);
//	return mav;
//}