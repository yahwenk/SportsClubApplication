package nus.iss.team2.controller;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import nus.iss.team2.exception.FacilityNotFound;
import nus.iss.team2.exception.UserNotFound;
import nus.iss.team2.model.Facility;
import nus.iss.team2.model.User;
import nus.iss.team2.service.FacilityImpl;
import nus.iss.team2.service.FacilityService;
import nus.iss.team2.service.UserService;
import nus.iss.team2.validator.FacilityValidator;


@RequestMapping(value="/admin/Facility")
@Controller
public class AdminFacilityController {


	@Autowired
	private FacilityService fservice;
	
    @RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView facilityListPage() {
		ModelAndView mav = new ModelAndView("faclist");
		List<Facility> facList = fservice.findAllFacility();
		System.out.println(""+facList.size());
		mav.addObject("facList", facList);
		return mav;
	}
	@Autowired
	private FacilityValidator facilityValidator;

	@InitBinder("Facility")
	private void initUserBinder(WebDataBinder binder) 
	{
		binder.addValidators(facilityValidator);
	}


	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public ModelAndView newFacilityPage() {
		ModelAndView mav = new ModelAndView("AddFacility");
		mav.addObject("Facility", new Facility());

		return mav;
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ModelAndView createNewFacility(@ModelAttribute @Valid Facility facility, 
			BindingResult result,
			final RedirectAttributes redirectAttributes) 
	{

		if (result.hasErrors())
			return new ModelAndView("AddFacility");

		ModelAndView mav = new ModelAndView();
		String msg = "New Facility " + facility.getFacilityID() + " was successfully added";

		fservice.createFacility(facility);
		mav.setViewName("redirect:/admin/Facility/list");

		redirectAttributes.addFlashAttribute("message", msg);
		return mav;
	}
    
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public ModelAndView deleteUser(@PathVariable int id, final RedirectAttributes 
			redirectAttributes)
  {
        ModelAndView mav = new ModelAndView("redirect:/admin/Facility/list");
		Facility f = fservice.findFacility(id);
		f.setStatus(Facility.INACTIVE);
		fservice.changeFacility(f);
		String message = "The facility " + f.getFacilityID() + " was successfully deleted.";

		redirectAttributes.addFlashAttribute("message", message);
//		mav.setViewName("redirect:/admin/Facility/list");
		return mav;
	}
	
	
		@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public ModelAndView editFacilityPage(@PathVariable int id)
		{
		ModelAndView mav = new ModelAndView("EditFacility");
		Facility facility = fservice.findFacility(id);
		mav.addObject("facility", facility);
	    //ArrayList<Facility> list = fservice.findAllFacility();
	    //mav.addObject("elist", list);
		return mav;
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
	public ModelAndView editFacility(@ModelAttribute @Valid Facility facility, BindingResult result, @PathVariable int id,
			final RedirectAttributes redirectAttributes) //throws FacilityNotFound{
	{
//		if (result.hasErrors())
//			return new ModelAndView("EditFacility");

		ModelAndView mav = new ModelAndView("redirect:/admin/Facility/list");
		String message = "Facility is successfully updated.";
      
		fservice.changeFacility(facility);

		redirectAttributes.addFlashAttribute("message", message);
		return mav;
	}

}
