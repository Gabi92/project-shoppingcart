package com.schoolproject.shoppingcart.nackademinshoppingcart.callbackhandler;

import com.schoolproject.shoppingcart.nackademinshoppingcart.callbackhandler.piqtx.PiqTx;
import com.schoolproject.shoppingcart.nackademinshoppingcart.callbackhandler.piqtx.service.PiqTxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.schoolproject.shoppingcart.nackademinshoppingcart.callbackhandler.callbackinput.*;
import com.schoolproject.shoppingcart.nackademinshoppingcart.siteuser.SiteUser;
import com.schoolproject.shoppingcart.nackademinshoppingcart.siteuser.service.SiteUserService;

@Component
public class PiqTxHandler {

	
	@Autowired
	SiteUserService siteUserService;

	@Autowired
	PiqTxService piqTxService;

	private TxCmdHandler cmdHandler = new TxCmdHandler();
	private PiqCallbackValidator callbackValid = new PiqCallbackValidator();
	private PiqValidateObject pvo = new PiqValidateObject();
	private PiqJsonResponseHandler piqJsonResponse = new PiqJsonResponseHandler();
	
	//Handles the verifyUserRequest sent by PaymentIQ by calling the validator and response creator and returning the response
	//to the controller.
	
	public String verifyUserHandler(VerifyUserInput indata) {

		cmdHandler.addVerifyUserCmd(indata);
		
		SiteUser user= siteUserService.findByUserId(Long.parseLong(indata.getUserId()));
		
		String response;
	
		if (callbackValid.validateVerifyUserRequest(user, indata, pvo).isSuccess()) {
			
			response = piqJsonResponse.verifyUserSuccess(user);
			cmdHandler.addVerifyUserRespCmd(response);
			
			return response;
			
		} else {
			
			response = piqJsonResponse.verifyUserFailed(user, indata, pvo);
			
			return response;
			
		}
	}

	
	//Handles the authorizeTxRequest sent by PaymentIQ by calling the validator and response creator and returning the response
	//to the controller.
	
	public String authorizeTxHandler(AuthorizeTxInput indata) {

		VerifyUserInput latestVUInput = cmdHandler.getLatestVerifyUserCmd();
		String latestVUResponse = cmdHandler.getLatestVerifyUserRespCmd();

		PiqTx piqTx = new PiqTx();
		piqTx.setUserId(latestVUInput.getUserId());
		piqTx.setSessionId(latestVUInput.getSessionId());
		piqTx.setTxAmount(indata.getTxAmount());
		piqTx.setTxAmountCy(indata.getTxAmountCy());
		piqTx.setPiqTxId(indata.getTxId());
		piqTx.setTxTypeId(indata.getTxTypeId());
		piqTx.setTxName(indata.getTxName());
		piqTx.setProvider(indata.getProvider());
		piqTx.setVerifyUserResponse(latestVUResponse);
		piqTxService.saveTx(piqTx);
		
		SiteUser user= siteUserService.findByUserId(Long.parseLong(indata.getUserId()));
		
		String response;
		
		if (callbackValid.validateAutorizeTxRequest(user, indata, pvo).isSuccess()) {

			response = piqJsonResponse.authorizeTxSuccess(user, piqTx);

			piqTx.setAuthorizeTxResponse(response);
			piqTx.setTxSuccess("SUCCESS");
			piqTxService.saveTx(piqTx);
			
			return response;
		} else {

			response = piqJsonResponse.authorizeTxFailed(user, pvo);

			piqTx.setAuthorizeTxResponse(response);
			piqTx.setTxSuccess("FAILED");
			piqTx.setTxMsg(pvo.getResultMessage());
			piqTxService.saveTx(piqTx);

			return response;
		}
	}
	
	//Handles the transferTxRequest sent by PaymentIQ by calling the validator and response creator and returning the response
	//to the controller.
	
	public String transferTxHandler(TransferTxInput indata) {

		PiqTx piqTx = piqTxService.findByPiqTxId(indata.getTxId());

		piqTx.setAuthCode(indata.getAuthCode());
		piqTx.setTxPspAmount(indata.getTxPspAmount());
		piqTx.setTxPspAmountCy(indata.getTxPspAmountCy());
		piqTx.setFee(indata.getFee());
		piqTx.setFeeCy(indata.getFeeCy());
		piqTx.setTxRefId(indata.getTxRefId());
		piqTxService.saveTx(piqTx);
		
		SiteUser user= siteUserService.findByUserId(Long.parseLong(indata.getUserId()));
		
		String response;
		Double balanceAfterTx;

		if (callbackValid.validateTransferTxRequest(user, indata, pvo).isSuccess()) {

			
			balanceAfterTx = user.getBalance() + indata.getTxAmount();
			user.setBalance(balanceAfterTx);
			response = piqJsonResponse.transferTxSucess(user, indata, piqTx);

			piqTx.setTransferTxResponse(response);
			piqTx.setTxSuccess("SUCCESS");
			piqTxService.saveTx(piqTx);
			

			return response;

		} else {

			response = piqJsonResponse.transferTxFailed(user, indata, pvo);

			piqTx.setTransferTxResponse(response);
			piqTx.setTxSuccess("FAILED");
			piqTx.setTxMsg(pvo.getResultMessage());
			piqTxService.saveTx(piqTx);
			
			return response;

		}

	}
	
	//Handles the cancelTxRequest sent by PaymentIQ by calling the validator and response creator and returning the response
	//to the controller.
	
	public String cancelTxHandler(CancelTxInput indata) {

		PiqTx piqTx = piqTxService.findByPiqTxId(indata.getTxId());

		SiteUser user= siteUserService.findByUserId(Long.parseLong(indata.getUserId()));

		String response;

		if (callbackValid.validateCancelTxRequest(user, indata, pvo).isSuccess()) {

			response = piqJsonResponse.cancelTxSuccess(user);

			piqTx.setCancelTxResponse(response);
			piqTxService.saveTx(piqTx);
			
			return response;

		} else {
			
			response = piqJsonResponse.cancelTxFailed(user, pvo);

			piqTx.setTxSuccess("FAILED");
			piqTx.setTxMsg(pvo.getResultMessage());
			piqTx.setCancelTxResponse(response);
			piqTxService.saveTx(piqTx);
			
			return response;
		}

	}
}
