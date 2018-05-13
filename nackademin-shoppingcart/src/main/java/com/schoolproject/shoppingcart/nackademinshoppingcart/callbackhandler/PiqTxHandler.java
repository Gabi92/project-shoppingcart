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
	private PiqJsonResponseHandler piqJsonResponse = new PiqJsonResponseHandler();
	
	//Handles the verifyUserRequest sent by PaymentIQ by calling the validator and response creator and returning the response
	//to the controller.
	
	public String verifyUserHandler(VerifyUserInput indata) {

		
		SiteUser user= siteUserService.findByUserId(Long.parseLong(indata.getUserId()));
		
		String response;
	
		if (callbackValid.validateVerifyUserRequest(user, indata, pvo).isSuccess()) {
			
			response = piqJsonResponse.verifyUserSuccess(user);
			
			return response;
			
		} else {
			
			response = piqJsonResponse.verifyUserFailed(user, indata, pvo);
			
			return response;
			
		}
	}

	
	//Handles the authorizeTxRequest sent by PaymentIQ by calling the validator and response creator and returning the response
	//to the controller.
	
	public String authorizeTxHandler(AuthorizeTxInput indata) {

		
		SiteUser user= siteUserService.findByUserId(Long.parseLong(indata.getUserId()));
		
		String response;
		
		if (callbackValid.validateAutorizeTxRequest(user, indata, pvo).isSuccess()) {

			response = piqJsonResponse.authorizeTxSuccess(user);
			
			return response;
		} else {

			response = piqJsonResponse.authorizeTxFailed(user, pvo);

			return response;
		}
	}
	
	//Handles the transferTxRequest sent by PaymentIQ by calling the validator and response creator and returning the response
	//to the controller.
	
	public String transferTxHandler(TransferTxInput indata) {
		
		SiteUser user= siteUserService.findByUserId(Long.parseLong(indata.getUserId()));
		
		String response;
		Double balanceAfterTx;

		if (callbackValid.validateTransferTxRequest(user, indata, pvo).isSuccess()) {

			
			balanceAfterTx = user.getBalance() + indata.getTxAmount();
			user.setBalance(balanceAfterTx);
			response = piqJsonResponse.transferTxSucess(user, indata);
			

			return response;

		} else {

			response = piqJsonResponse.transferTxFailed(user, indata, pvo);
			
			return response;

		}

	}
	
	//Handles the cancelTxRequest sent by PaymentIQ by calling the validator and response creator and returning the response
	//to the controller.
	
	public String cancelTxHandler(CancelTxInput indata) {
		
		SiteUser user= siteUserService.findByUserId(Long.parseLong(indata.getUserId()));

		String response;

		if (callbackValid.validateCancelTxRequest(user, indata, pvo).isSuccess()) {

			response = piqJsonResponse.cancelTxSuccess(user);
			
			return response;

		} else {
			
			response = piqJsonResponse.cancelTxFailed(user, pvo);
			
			return response;
		}

	}
}
