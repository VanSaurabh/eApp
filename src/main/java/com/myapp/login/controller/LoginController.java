package com.myapp.login.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.myapp.login.pojo.LoginForm;
import com.myapp.login.service.LoginService;

@Controller
public class LoginController {
	
	@Autowired
	private LoginService loginService;
	
	@GetMapping("/login")
	public String loginPageRedirectionController(Model model){
		model.addAttribute("loginForm", new LoginForm());
		return "login";
	}

	@PostMapping("/login")
	public String mainListPageRedirectionController(Model model, @Valid LoginForm loginForm, BindingResult bindingResult){
		if(!validateLogin(loginForm)){
			ObjectError error = new ObjectError("message", "UserName and Password does not match");
			bindingResult.addError(error);
		}
		if(bindingResult.hasErrors()){
			model.addAttribute("message", "UserName and Password does not match");
			return "login";
		}
		model.addAttribute("loginForm", loginForm);
		model.addAttribute("userName", loginForm.getUserName());
		model.addAttribute("password", loginForm.getPassword());
		return "MainListPage";
	}

	private boolean validateLogin(LoginForm loginForm) {
		return loginService.validatelogin(loginForm);
	}
	
	public LoginService getLoginService() {
		return loginService;
	}

	public void setLoginService(LoginService loginService) {
		this.loginService = loginService;
	}
}
