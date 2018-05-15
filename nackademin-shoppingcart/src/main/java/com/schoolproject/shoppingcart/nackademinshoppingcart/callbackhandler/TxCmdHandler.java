package com.schoolproject.shoppingcart.nackademinshoppingcart.callbackhandler;

import java.util.ArrayList;

import com.schoolproject.shoppingcart.nackademinshoppingcart.callbackhandler.callbackinput.*;



public class TxCmdHandler {
	
	private ArrayList<VerifyUserInput> verifyUserCmd = new ArrayList<VerifyUserInput>();
	
	private ArrayList<String> verifyUserRespCmd = new ArrayList<String>();
	
	
	public TxCmdHandler() {
	}


	public void addVerifyUserCmd(VerifyUserInput verifyUserInput) {
		this.verifyUserCmd.add(verifyUserInput);
	}
	
	public void addVerifyUserRespCmd(String verifyUserResponse) {
		this.verifyUserRespCmd.add(verifyUserResponse);
	}
	
	
	public VerifyUserInput getLatestVerifyUserCmd() {
		
		for(int i = verifyUserCmd.size() - 1; i >= 0;) {
			return (VerifyUserInput) verifyUserCmd.get(i);
		}
		return null;
	}
	
	public String getLatestVerifyUserRespCmd() {
		
		for(int i = verifyUserRespCmd.size() - 1; i >= 0;) {
			return (String) verifyUserRespCmd.get(i);
		}
		return null;
	}

}