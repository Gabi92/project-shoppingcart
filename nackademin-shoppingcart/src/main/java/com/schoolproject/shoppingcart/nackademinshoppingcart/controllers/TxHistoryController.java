package com.schoolproject.shoppingcart.nackademinshoppingcart.controllers;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.schoolproject.shoppingcart.nackademinshoppingcart.callbackhandler.piqtx.PiqTx;
import com.schoolproject.shoppingcart.nackademinshoppingcart.callbackhandler.piqtx.service.PiqTxService;
import com.schoolproject.shoppingcart.nackademinshoppingcart.siteuser.SiteUser;
import com.schoolproject.shoppingcart.nackademinshoppingcart.siteuser.service.SiteUserService;


@Controller
public class TxHistoryController {
	
	@Autowired
	SiteUserService siteUserService;
	
	@Autowired
	PiqTxService piqTxService;
	
	@RequestMapping(value="/txhistory", method = RequestMethod.GET)
	public String showTxHistory(Model model, HttpServletRequest request,HttpServletResponse response) {
		
		
		SiteUser siteUser = siteUserService.getCurrentSiteUser();
		ArrayList<PiqTx> txHistory = new ArrayList<PiqTx>();
		
		txHistory = piqTxService.getTxHistory(siteUser.getUserId().toString());
		
		model.addAttribute("txHistory", txHistory);
		
		return "txhistory";
	}

}
