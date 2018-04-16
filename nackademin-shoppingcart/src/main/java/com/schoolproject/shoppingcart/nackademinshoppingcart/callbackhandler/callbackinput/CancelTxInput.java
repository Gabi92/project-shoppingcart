package com.schoolproject.shoppingcart.nackademinshoppingcart.callbackhandler.callbackinput;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class CancelTxInput {

	
	String userId;
	String authCode;
	String txAmount;
	String txAmountCy;
	String txId;
	String txTypeId;
	String txName;
	String provider;
	
	
	//Constructor
	
	public CancelTxInput(String input) throws Exception{
		
		ObjectMapper mapper = new ObjectMapper();
		
		mapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
        JsonNode node = mapper.readValue(input, JsonNode.class);
		
        this.userId = node.get("userId").asText();
		this.authCode = node.get("authCode").asText();
		this.txAmount = node.get("txAmount").asText();
		this.txAmountCy = node.get("txAmountCy").asText();
		this.txId = node.get("txId").asText();
		this.txTypeId = node.get("txTypeId").asText();
		this.txName = node.get("txName").asText();
		this.provider = node.get("provider").asText();
	}


	//Getters

	public String getUserId() {
		return userId;
	}



	public String getAuthCode() {
		return authCode;
	}



	public String getTxAmount() {
		return txAmount;
	}



	public String getTxAmountCy() {
		return txAmountCy;
	}



	public String getTxId() {
		return txId;
	}



	public String getTxTypeId() {
		return txTypeId;
	}



	public String getTxName() {
		return txName;
	}



	public String getProvider() {
		return provider;
	}
	

	//Setters

	public void setUserId(String userId) {
		this.userId = userId;
	}


	public void setAuthCode(String authCode) {
		this.authCode = authCode;
	}


	public void setTxAmount(String txAmount) {
		this.txAmount = txAmount;
	}


	public void setTxAmountCy(String txAmountCy) {
		this.txAmountCy = txAmountCy;
	}


	public void setTxId(String txId) {
		this.txId = txId;
	}


	public void setTxTypeId(String txTypeId) {
		this.txTypeId = txTypeId;
	}


	public void setTxName(String txName) {
		this.txName = txName;
	}


	public void setProvider(String provider) {
		this.provider = provider;
	}
	
	
	
}
