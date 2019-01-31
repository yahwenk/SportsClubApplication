package nus.iss.team2.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import nus.iss.team2.model.User;
import nus.iss.team2.service.UserService;
import nus.iss.team2.validator.UserValidator;

@Controller
@RequestMapping(value = "/")
public class RegisterController {

	@Autowired
	private UserService userService;

	@Autowired
	private UserValidator userValidator;
 	
 	@InitBinder("registerCommand")
	private void initUserBinder(WebDataBinder binder) {
		binder.addValidators(userValidator);
	}
	
	@RequestMapping(value = "register", method = RequestMethod.GET)
	public String showRegister(Model model) {
		User user = new User();
		model.addAttribute("registerCommand", user);
		return "register";
	}

	@RequestMapping(value = "registerProcess", method = RequestMethod.POST)
	public String registerUser(@ModelAttribute("registerCommand")@Valid User user, BindingResult br, Model model) {
//		user.setRole(userService.ROLE_USER);
//		user.setStatus(userService.LOGIN_STATUS_ACTIVE);
		try {
		    //userValidator.validate(user, br);  //If uncomment, it will validate twice.
		    if(br.hasErrors()) {
		    	System.out.println(br.getFieldError().getDefaultMessage());
//		    	if(br.getFieldValue("age").getClass()==String.class) {
//			    	br.rejectValue("age", "error.user.age.invalid", "Age Error");
//			    	
//			    	//model.addAttribute("ageErr", br.getFieldError("age"));
//		    	}
		    	return "register";
		    }
			if (!ifregister(user)) {
				userService.register(user);
				return "redirect:index?act=reg";
			}else {
				model.addAttribute("err", "UserID is already registered. Please selecte another UserID.");
				return "register";
			}
//		} catch(NumberFormatException nfe) {
//			return "register";
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("err", "There is something wrong. Sorry.");
			return "register";
		}
	}

	public boolean ifregister(User user) {
		List<User> users = userService.getUserList();
		for(User u:users) {
			if(u.equals(user)) {
				return true;//if the userID has already been used
			}
		}
		return false;//if the userID is new which can be used.
	}

	@RequestMapping(value = "registerProcess", method = RequestMethod.GET)
	public String showRegisterProcess(Model model) {
		// Register register = new Register();
		User user = new User();
		model.addAttribute("register", user);
		return "registerProcess";
	}

}