package com.schoolproject.shoppingcart.nackademinshoppingcart.callbackhandler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.schoolproject.shoppingcart.nackademinshoppingcart.callbackhandler.callbackinput.*;
import com.schoolproject.shoppingcart.nackademinshoppingcart.siteuser.SiteUser;
import com.schoolproject.shoppingcart.nackademinshoppingcart.siteuser.service.SiteUserService;

@Component
public class PiqTxHandler {

	
	@Autowired
	SiteUserService siteUserService;

	private PiqCallbackValidator callbackValid = new PiqCallbackValidator();
	private PiqValidateObject pvo = new PiqValidateObject();
	
	public String verifyUserHandler(VerifyUserInput indata) {

		
		SiteUser user= siteUserService.findByUserId(Long.parseLong(indata.getUserId()));
		
		String response;
	
		if (callbackValid.validateVerifyUserRequest(user, indata, pvo).isSuccess()) {
			
			response = "SUCCESS";
			
			return response;
			
		} else {
			
			response = "FAILED";
			
			return response;
			
		}
	}

	
	
	public String authorizeTxHandler(AuthorizeTxInput indata) {

		
		SiteUser user= siteUserService.findByUserId(Long.parseLong(indata.getUserId()));
		
		String response;
		
		if (callbackValid.validateAutorizeTxRequest(user, indata, pvo).isSuccess()) {

			response = "SUCCESS";

			return response;
		} else {

			response = "FAILED";

			return response;
		}
	}
	
	
	public String transferTxHandler(TransferTxInput indata) {
		
		SiteUser user= siteUserService.findByUserId(Long.parseLong(indata.getUserId()));
		
		String response;

		if (callbackValid.validateTransferTxRequest(user, indata, pvo).isSuccess()) {

			response = "SUCCESS";
			

			return response;

		} else {

			response = "Failed";
			
			return response;

		}

	}
	
	public String cancelTxHandler(CancelTxInput indata) {
		
		SiteUser user= siteUserService.findByUserId(Long.parseLong(indata.getUserId()));

		String response;

		if (callbackValid.validateCancelTxRequest(user, indata, pvo).isSuccess()) {

			response = "SUCCESS";
			
			return response;

		} else {
			
			response = "FAILED";
			
			return response;
		}

	}
}
