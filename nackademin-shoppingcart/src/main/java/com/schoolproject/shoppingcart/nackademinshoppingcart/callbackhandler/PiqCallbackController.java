package com.schoolproject.shoppingcart.nackademinshoppingcart.callbackhandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import com.schoolproject.shoppingcart.nackademinshoppingcart.callbackhandler.callbackinput.VerifyUserInput;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value="/paymentiq")
public class PiqCallbackController {

	@Autowired
	private PiqTxHandler piqTxHandler;
	
	@RequestMapping(value="/verifyuser", method = RequestMethod.POST)
	public void verifyUserRequest(@RequestBody String indata, HttpServletRequest request, HttpServletResponse response) {
		
		try {
			VerifyUserInput verifyUserInput = new VerifyUserInput(indata);
			String verifyUserResponse = piqTxHandler.verifyUserHandler(verifyUserInput);
			
			response.setContentType("application/json");
			response.setStatus(HttpServletResponse.SC_OK);
			response.getWriter().write(verifyUserResponse);
			
			return;
		
		} catch (Exception e) {
			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			e.printStackTrace();
			return;
		}
	}

	@RequestMapping(value="/authorize", method = RequestMethod.POST)
	@ResponseBody
	public void authorizeTx(@RequestBody String indata, HttpServletRequest request, HttpServletResponse response) {

		try {
			AuthorizeTxInput authorizeTxInput = new AuthorizeTxInput(indata);
			String authorizeTxResponse = piqTxHandler.authorizeTxHandler(authorizeTxInput);

			response.setContentType("application/json");
			response.setStatus(HttpServletResponse.SC_OK);
			response.getWriter().write(authorizeTxResponse);

			return;

		} catch(Exception e){
			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			e.printStackTrace();
			return;
		}
	}
}


