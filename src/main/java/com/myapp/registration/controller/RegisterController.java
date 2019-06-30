package com.myapp.registration.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.myapp.login.pojo.LoginForm;
import com.myapp.registration.pojo.RegistrationForm;
import com.myapp.registration.service.RegistrationService;

@Controller
public class RegisterController {

	@Autowired
	private RegistrationService registrationService;
	
	@GetMapping("/register")
	public String registrationPageController(Model model){
		model.addAttribute("registrationForm", new RegistrationForm());
		return "Register";
	}
	
	@PostMapping("/register")
	public String getNextListPage(Model model, @Valid RegistrationForm registrationForm, BindingResult bindingResult){
		if(null != registrationForm){
			if(!validateUniqueUserName(registrationForm)){
				ObjectError error = new ObjectError("message", "UserName is not unique");
				bindingResult.addError(error);
			}else{
				doRegistrationOfNewUser(registrationForm);
				//doPopulateLoginDetailsTable(registrationForm.getUserName(), registrationForm.getPassword());
			}
			if(bindingResult.hasErrors()){
				if(bindingResult.getAllErrors().get(0).getDefaultMessage().contains("UserName is not unique"))
					model.addAttribute("message", "UserName is not unique");
				return "Register";
			}
		}
		model.addAttribute("firstName",registrationForm.getFirstName());
		model.addAttribute("lastName",registrationForm.getLastName());
		model.addAttribute("emai",registrationForm.getEmail());
		model.addAttribute("phoneNumber",registrationForm.getPhoneNumber());
		model.addAttribute("userName",registrationForm.getUserName());
		model.addAttribute("password",registrationForm.getPassword());
		model.addAttribute("dateOfBirth",registrationForm.getDateOfBirth());
		model.addAttribute("address",registrationForm.getAddress());
		model.addAttribute("loginForm", new LoginForm());
		return "Login";
	}

	private void doRegistrationOfNewUser(@Valid RegistrationForm registrationForm) {
		registrationService.doRegistrationOfNewUser(registrationForm);
	}

	private boolean validateUniqueUserName(@Valid RegistrationForm registrationForm) {
		return registrationService.isUniqueUserName(registrationForm.getUserName());		
	}

	public RegistrationService getRegistrationService() {
		return registrationService;
	}

	public void setRegistrationService(RegistrationService registrationService) {
		this.registrationService = registrationService;
	}
}
