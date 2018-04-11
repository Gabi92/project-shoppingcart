package com.schoolproject.shoppingcart.nackademinshoppingcart.callbackhandler;

import com.schoolproject.shoppingcart.nackademinshoppingcart.callbackhandler.callbackinput.VerifyUserInput;

public class PiqTxHandler {

	
	
	public String verifyUserHandler(VerifyUserInput indata) {

		String response;
	
		if (indata.getUserId().equals("1") && indata.getSessionId().equals("123")) {
			
			response = "SUCCESS";
			
			return response;
			
		} else {
			
			response = "FAILED";
			
			return response;
			
		}
	}
}
