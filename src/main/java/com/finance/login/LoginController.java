package com.finance.login;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.finance.common.Constants;
import com.finance.common.session.SessionUser;
import com.finance.common.session.SessionUtils;
import com.finance.service.LoginService;
@Controller
@Scope("prototype")
public class LoginController { 
	
	// Add Init Binder to trim Strings. 
	// If String is all whitespace then it will be set to null with param as true
	@Autowired
	private LoginService loginService;

	public void setLoginService(LoginService loginService) {
		this.loginService = loginService;
	}

	@InitBinder
	public void initBinder(WebDataBinder webDataBinder) {
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		webDataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}
	
	@RequestMapping(value="/login.form",method=RequestMethod.GET)
	public String showLoginPage(Model theModel,HttpServletRequest req) {
		HttpSession session = req.getSession(false);
		if(session!=null){
			session.invalidate();
		}
		theModel.addAttribute("user", new LoginForm());

		return "login";
	}

	@RequestMapping(value="/processLogin.form", method=RequestMethod.POST)
	public String showUserHome(@Valid @ModelAttribute("user") LoginForm form,
								BindingResult bindingResult, HttpServletRequest req) {
		System.out.println(form.toString());
		if(bindingResult.hasErrors()) {
			return "login";
		}else {
			String userId = form.getUserId();
			String userPassword = form.getUserpassword();
			HttpSession session = req.getSession(false);
			if(session!=null){
				session.invalidate();
			}
			SessionUser userInSession = loginService.validateUser(userId, userPassword);
			if(userInSession!=null){
				session = req.getSession(true);
				SessionUtils.setRandomKey(session);
				SessionUtils.setSessionAttribute(session, Constants.SESSION_USER_KEY, userInSession);
				return "userHome";
			}else{
				//bindingResult.addAllErrors(Errors.reject("Invalid Credentials"));
				form.setUserId(null);
				form.setUserpassword(null);
				form.setErrorMessage("Invalid Credentials");
				//bindingResult.rejectValue("errorMessage", "error.authentication", "Invalid Credentials");
				return "login";
			}
		}
	}

	@RequestMapping(value="/logout.form", method=RequestMethod.GET)
	public String logout(Model theModel,HttpServletRequest req){
		HttpSession session = req.getSession(false);
		if(session!=null && SessionUtils.getSessionAttribute(session, Constants.SESSION_USER_KEY)!=null){
			SessionUtils.removeAttribute(session,  Constants.SESSION_USER_KEY);
			session.invalidate();
		}
		theModel.addAttribute("user", new LoginForm());
		return "login";
	}

}
