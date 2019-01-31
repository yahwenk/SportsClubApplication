package nus.iss.team2.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import nus.iss.team2.model.Booking;
import nus.iss.team2.model.Facility;
import nus.iss.team2.model.timeslot;
import nus.iss.team2.service.BookingService;
import nus.iss.team2.service.FacilityService;
import nus.iss.team2.service.TimeslotService;

@Controller
@RequestMapping(value = "/booking")
public class UserBookingController {

	@Autowired
	private BookingService transService;

	@Autowired
	private TimeslotService timeslotService;

	// @Autowired
	// private TransactionValidator tValidator;

	@Autowired
	private FacilityService facilityService;

	@InitBinder("booking")
	private void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
		// binder.addValidators(tValidator);

	}

	@RequestMapping(value = "/history", method = RequestMethod.GET)
	public ModelAndView BookingHistory(HttpSession session) {
		UserSession us = (UserSession) session.getAttribute("USERSESSION");
		ModelAndView mav = new ModelAndView("booking-history");

		ArrayList<Booking> userbookings = transService.bookingHistory(us.getUser().getUserID());

		mav.addObject("bhistory", userbookings);

		return mav;
	}

	@RequestMapping(value = "/booking", method = RequestMethod.GET)
	public ModelAndView newBookingPage() {
		ModelAndView mav = new ModelAndView("booking");
		mav.addObject("facility", facilityService.findAllFacility());
		mav.addObject("booking", new Booking());

		return mav;

	}

	@RequestMapping(value = "booking/{selfac}/{selected}", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<String> testing(@ModelAttribute Booking trans, @PathVariable("selected") String bd,
			@PathVariable("selfac") String facid, HttpSession session) throws ParseException {

		UserSession us = (UserSession) session.getAttribute("USERSESSION");

		String userid = us.getUser().getUserID();
		us.setFac(facilityService.findFacility(Integer.parseInt(facid)));

		Date date1 = new SimpleDateFormat("dd-MM-yyyy").parse(bd);

		us.setbDate(date1);

		List<String> booked = transService.getBookedTs(Integer.parseInt(facid), date1);

		List<timeslot> allts = timeslotService.findAllTimeSlot();

		List<String> tsName = new ArrayList<String>();

		for (timeslot ts : allts) {

			tsName.add(ts.getTimeSlot());

		}

		List<String> unbookedList = new ArrayList<String>();

		for (String all : tsName) {

			if (booked.contains(all))
				continue;
			else
				unbookedList.add(all);
		}

		return unbookedList;
	}

	@RequestMapping(value = "/booking", method = RequestMethod.POST)
	public ModelAndView createNewBooking(@ModelAttribute @Valid Booking trans,
			final RedirectAttributes redirectAttributes, HttpSession session, BindingResult result)
			throws ParseException {

		if (result.hasErrors())
			return new ModelAndView("booking");

		for (FieldError fieldError : result.getFieldErrors()) {
			System.out.println(fieldError.getField() + ":" + fieldError.getDefaultMessage());
		}

		String message = "New booking " + trans.getBookingID() + " was successfully created.";

		UserSession us = (UserSession) session.getAttribute("USERSESSION");

		trans.setUser(us.getUser());

		trans.setStatus(Booking.APPROVED);

		trans.setBookingDate(us.getbDate());
		trans.setFac(facilityService.findFacility(us.getFac().getFacilityID()));

		// trans.setFacilityID(us.getFac().getFacilityID());

		transService.createBooking(trans);

		redirectAttributes.addFlashAttribute("message", message);

		ModelAndView mav = new ModelAndView("redirect:/booking/history");

		return mav;
	}

	@RequestMapping(value = "edit/{id}", method = RequestMethod.GET)
	public ModelAndView editBooking(@PathVariable int id) {
		ModelAndView mav = new ModelAndView("booking-edit");
		Booking booking = transService.findBookingByID(id);
		mav.addObject("booking", booking);
		ArrayList<Facility> facility = facilityService.findAllFacilityBooking();
		mav.addObject("facility", facility);
		return mav;
	}

	@RequestMapping(value = "edit/{id}", method = RequestMethod.POST)
	public ModelAndView editBookingPage(@ModelAttribute Booking booking, @PathVariable String id, BindingResult result,
			final RedirectAttributes redirectAttributes, HttpSession session) // throws BookingNotFoundException
	{
		ModelAndView mav = new ModelAndView("redirect:/booking/history");
		UserSession us = (UserSession) session.getAttribute("USERSESSION");

		booking.setStatus(Booking.UPDATED);

		transService.updateBooking(booking);

		return mav;
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public ModelAndView deleteCourse(@PathVariable int id, final RedirectAttributes redirectAttributes,
			HttpSession session) // throws BookingNotFoundException
	{

		ModelAndView mav = new ModelAndView("redirect:/booking/history");
		Booking book = transService.findBookingByID(id);
		book.setStatus(Booking.CANCELLED);
		transService.updateBooking(book);
		return mav;
	}

}

//@RequestMapping(value = "edit/{id}/{selfac}/{selected}", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
//public @ResponseBody List<String> editbooking(@ModelAttribute Booking trans, @PathVariable("selected") String bd,
//		@PathVariable("selfac") int facid, HttpSession session) throws ParseException {
//
//	UserSession us = (UserSession) session.getAttribute("USERSESSION");
//
//	String userid = us.getUser().getUserID();
//	us.setFac(facilityService.findFacility(facid));
//
//	Date date1 = new SimpleDateFormat("dd-MM-yyyy").parse(bd);
//
//	us.setbDate(date1);
//
//	List<String> booked = transService.getBookedTs(facid, date1);
//
//	List<timeslot> allts = timeslotService.findAllTimeSlot();
//
//	List<String> tsName = new ArrayList<String>();
//
//	for (timeslot ts : allts) {
//
//		tsName.add(ts.getTimeSlot());
//
//	}
//
//	List<String> unbookedList = new ArrayList<String>();
//
//	for (String all : tsName) {
//
//		if (booked.contains(all))
//			continue;
//		else
//			unbookedList.add(all);
//	}
//
//	return unbookedList;
//}
