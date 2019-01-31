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


import nus.iss.team2.exception.UserNotFound;
//import edu.iss.cats.exception.UserNotFound;
import nus.iss.team2.model.User;
import nus.iss.team2.service.UserService;
import nus.iss.team2.validator.UserValidator;


@RequestMapping(value="/admin/user")
@Controller
public class AdminUserController {

	@Autowired
	private UserService uService;
	
	@Autowired
	private UserValidator uValidator;
	
	@InitBinder("user")
	private void initUserBinder(WebDataBinder binder) {
		binder.addValidators(uValidator);
	}
	
	

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView userListPage() {
		System.out.println("******************************************");
		ModelAndView mav = new ModelAndView("user-list");
		List<User> userList = uService.findAllUsers();
		System.out.println("list"+userList.size());
		mav.addObject("userList", userList);
		return mav;
	}
	
	
	
	/*@Autowired
	private UserValidator uValidator;

	@InitBinder("user")
	private void initUserBinder(WebDataBinder binder) {
		binder.addValidators(uValidator);
	}*/

	/**
	 * USER CRUD OPERATIONS
	 * 
	 * @return
	 */

	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public ModelAndView newUserPage() {
		ModelAndView mav = new ModelAndView("user-new", "user", new User());
		return mav;
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ModelAndView createNewUser(@ModelAttribute @Valid User user, BindingResult result,
			final RedirectAttributes redirectAttributes) {

		if (result.hasErrors())
			return new ModelAndView("user-new");

		ModelAndView mav = new ModelAndView();
		String message = "New user " + user.getUserID() + " was successfully created.";

		uService.createUser(user);
		mav.setViewName("redirect:/admin/user/list");

		redirectAttributes.addFlashAttribute("message", message);
		return mav;
	}


	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public ModelAndView editUserPage(@PathVariable String id) {
		ModelAndView mav = new ModelAndView("user-edit");
		User user = uService.findUser(id);
		System.out.println("***********************************************************"+user.toString());
		mav.addObject("user", user);
		//ArrayList<String> userList = uService.findAllUserIDs();
		//mav.addObject("userList", userList);
		return mav;
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
	public ModelAndView editUser(@ModelAttribute @Valid User user, BindingResult result, @PathVariable String id,
			final RedirectAttributes redirectAttributes) throws UserNotFound {

		if (result.hasErrors())
			return new ModelAndView("user-edit");

		ModelAndView mav = new ModelAndView("redirect:/admin/user/list");
		String message = "User was successfully updated.";

		uService.changeUser(user);

		redirectAttributes.addFlashAttribute("message", message);
		return mav;
	}
		

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public ModelAndView deleteUser(@PathVariable String id, final RedirectAttributes redirectAttributes)
			throws UserNotFound {

		ModelAndView mav = new ModelAndView("redirect:/admin/user/list");
		User user = uService.findUser(id);
		user.setStatus(uService.LOGIN_STATUS_BLOCKED);
		uService.changeUser(user);
		String message = "The user " + user.getUserID() + " was successfully deleted.";

		redirectAttributes.addFlashAttribute("message", message);
		return mav;
	}

}
