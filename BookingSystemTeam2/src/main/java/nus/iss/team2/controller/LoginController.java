package nus.iss.team2.controller;

import javax.servlet.http.HttpSession;

import org.hibernate.validator.internal.util.privilegedactions.GetMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import nus.iss.team2.exception.UserBlockedException;
import nus.iss.team2.model.User;
import nus.iss.team2.service.UserService;

@Controller
@RequestMapping(value = "/")
public class LoginController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = { "/", "index" }, method = RequestMethod.GET)
	public String index(Model m) {
		m.addAttribute("loginCommand", new User());
		return "index";
	}

/*	@RequestMapping(value = "login", method = RequestMethod.GET)
	public ModelAndView showLogin(Model m) {
		m.addAttribute("login", new Login());
		ModelAndView mav = new ModelAndView("login");
		mav.addObject("user", new User());
		return mav;
	}*/

	@RequestMapping(value = "login", method = RequestMethod.POST)
	public String login(@ModelAttribute("loginCommand") User user, Model m, HttpSession session) {
		try {
			UserSession us = new UserSession();
			User loggedInUser = userService.login(user.getUserID(), user.getPassword());
			if (loggedInUser == null) {
				// FAILED
				m.addAttribute("err", "Login Failed! Enter Valid Credentials.");
				return "index";
			} else {
				// SUCCESS
				// check the role and redirect to an appropriate welcome page
				if (loggedInUser.getRole().equals(UserService.ROLE_ADMIN)) {
					// add User detail in session(assign session to logged in user)
					addUserInSession(loggedInUser, session,us);
					session.setAttribute("USERSESSION", us);
					return "redirect:adminWelcome";
				} else if (loggedInUser.getRole().equals(UserService.ROLE_USER)) {
					// add User detail in session(assign session to logged in user)
					addUserInSession(loggedInUser, session,us);
					session.setAttribute("USERSESSION", us);
					return "redirect:userWelcome";
				} else {
					// add error message
					m.addAttribute("err", "Invalid User Role");
					return "index";
				}
			}
		} catch (UserBlockedException ex) {
			m.addAttribute("err", ex.getMessage());
			return "index";//Login FORM
		}

	}

	private void addUserInSession(User u, HttpSession session,UserSession usession) {
		usession.setSessionId(session.getId());
		usession.setUser(u);
//		session.setAttribute("user", u);
//		session.setAttribute("userID", u.getUserID());
//		session.setAttribute("role", u.getRole());
	}

	@RequestMapping(value = "logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:index?act=lo";
	}

	@RequestMapping(value = "userWelcome")
	public String userWelcome() {
		return "userWelcome";
	}

	@RequestMapping(value = "adminWelcome")
	public String adminWelcome() {
		return "adminWelcome";
	}

}
