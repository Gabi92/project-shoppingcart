package com.schoolproject.shoppingcart.nackademinshoppingcart.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.schoolproject.shoppingcart.nackademinshoppingcart.siteuser.SiteUser;
import com.schoolproject.shoppingcart.nackademinshoppingcart.siteuser.service.SiteUserService;


@Controller
public class PiqCashierController {
	
	@Autowired
	SiteUserService siteUserService;
	
	
	@RequestMapping(value="/managefunds", method = RequestMethod.GET)
	public String informationInputMapping(Model model, HttpServletRequest request,HttpServletResponse response) {
		
		
		SiteUser siteUser = siteUserService.getCurrentSiteUser();
		
		String merchantMid = "1992";
		String sessionId = request.getSession().getId();
		
		
		String piqCashierDepositUrl = "https://test-cashier.paymentiq.io:443/#/merchant/"+
								merchantMid+
								"/user/"+ 
								siteUser.getUserId().toString()+
								"/method/"+
								"deposit?selectlastusedtxmethod=false&showconfirmation=false&showmenu=true&locale=en&container=iframe&iframeWidth=400&iframeHeight=700&sessionid="+
								sessionId;
		
		String piqCashierWithdrawUrl = "https://test-cashier.paymentiq.io:443/#/merchant/"+
								merchantMid+
								"/user/"+ 
								siteUser.getUserId().toString()+
								"/method/"+
								"withdrawal?selectlastusedtxmethod=false&showconfirmation=false&showmenu=true&locale=en&container=iframe&iframeWidth=400&iframeHeight=700&sessionid="+
								sessionId;
		
		model.addAttribute("piqwithdrawurl", piqCashierWithdrawUrl);
		model.addAttribute("piqdepositurl", piqCashierDepositUrl);
		
		return "paymentpage";
	}

}
