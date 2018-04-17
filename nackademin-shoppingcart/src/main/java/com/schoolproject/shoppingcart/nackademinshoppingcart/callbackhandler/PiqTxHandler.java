package com.schoolproject.shoppingcart.nackademinshoppingcart.callbackhandler;

import org.springframework.stereotype.Component;

import com.schoolproject.shoppingcart.nackademinshoppingcart.callbackhandler.callbackinput.*;

@Component
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

	
	
	public String authorizeTxHandler(AuthorizeTxInput indata) {


		String response;
		if (indata.getUserId().equals("1")) {

			response = "SUCCESS";

			return response;
		} else {

			response = "FAILED";

			return response;
		}
	}
	
	
	public String transferTxHandler(TransferTxInput indata) {
		
		String response;

		if (indata.getUserId().equals("1")) {

			response = "SUCCESS";
			

			return response;

		} else {

			response = "Failed";
			
			return response;

		}

	}
	
	public String cancelTxHandler(CancelTxInput indata) {

		String response;

		if (indata.getUserId().equals("1")) {

			response = "SUCCESS";
			
			return response;

		} else {
			
			response = "FAILED";
			
			return response;
		}

	}
}
