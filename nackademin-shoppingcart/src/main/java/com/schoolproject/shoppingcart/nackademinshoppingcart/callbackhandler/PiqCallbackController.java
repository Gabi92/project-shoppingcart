package com.schoolproject.shoppingcart.nackademinshoppingcart.callbackhandler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/paymentiq")
public class PiqCallbackController {

	
	
	@RequestMapping(value="/verifyuser", method = RequestMethod.POST)
	public void testHomePage() {
	}
	
}
