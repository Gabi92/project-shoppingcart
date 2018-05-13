package com.schoolproject.shoppingcart.nackademinshoppingcart.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.schoolproject.shoppingcart.nackademinshoppingcart.siteuser.service.SiteUserService;

@Controller
public class ViewController {
	
	@Autowired
	SiteUserService siteUserService;

	//controller for a simple homepage.
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String homePage() {
		
		return "index";
	}
}
