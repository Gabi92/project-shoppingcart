package com.schoolproject.shoppingcart.nackademinshoppingcart.callbackhandler.callbackinput;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class TransferTxInput {

	String userId;
	String authCode;
	Double txAmount;
	String txAmountCy;
	String txPspAmount;
	String txPspAmountCy;
	String fee;
	String feeCy;
	String txId;
	Number txTypeId;
	String txName;
	String provider;
	String txRefId;
	
	
	
	//Constructor
	
	public TransferTxInput(String input) throws Exception {
		
		ObjectMapper mapper = new ObjectMapper();
		
		mapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
        JsonNode node = mapper.readValue(input, JsonNode.class);
		
		this.userId = node.get("userId").asText();
		this.authCode = node.get("authCode").asText();
		this.txAmount = node.get("txAmount").asDouble();
		this.txAmountCy = node.get("txAmountCy").asText();
		this.txPspAmount = node.get("txPspAmount").asText();
		this.txPspAmountCy = node.get("txPspAmountCy").asText();
		this.fee = node.get("fee").asText();
		this.feeCy = node.get("feeCy").asText();
		this.txId = node.get("txId").asText();
		this.txTypeId = node.get("txTypeId").asInt();
		this.txName = node.get("txName").asText();
		this.provider = node.get("provider").asText();
		this.txRefId = node.get("txRefId").asText();
		
	}

	
	
	//Getters
	
	public String getUserId() {
		return userId;
	}

	public String getAuthCode() {
		return authCode;
	}

	public Double getTxAmount() {
		return txAmount;
	}

	public String getTxAmountCy() {
		return txAmountCy;
	}

	public String getTxPspAmount() {
		return txPspAmount;
	}

	public String getTxPspAmountCy() {
		return txPspAmountCy;
	}

	public String getFee() {
		return fee;
	}

	public String getFeeCy() {
		return feeCy;
	}

	public String getTxId() {
		return txId;
	}

	public Number getTxTypeId() {
		return txTypeId;
	}

	public String getTxName() {
		return txName;
	}

	public String getProvider() {
		return provider;
	}

	public String getTxRefId() {
		return txRefId;
	}


	
	
	
	//Setters
	
	public void setUserId(String userId) {
		this.userId = userId;
	}


	public void setAuthCode(String authCode) {
		this.authCode = authCode;
	}


	public void setTxAmount(Double txAmount) {
		this.txAmount = txAmount;
	}


	public void setTxAmountCy(String txAmountCy) {
		this.txAmountCy = txAmountCy;
	}


	public void setTxPspAmount(String txPspAmount) {
		this.txPspAmount = txPspAmount;
	}


	public void setTxPspAmountCy(String txPspAmountCy) {
		this.txPspAmountCy = txPspAmountCy;
	}


	public void setFee(String fee) {
		this.fee = fee;
	}


	public void setFeeCy(String feeCy) {
		this.feeCy = feeCy;
	}


	public void setTxId(String txId) {
		this.txId = txId;
	}


	public void setTxTypeId(Number txTypeId) {
		this.txTypeId = txTypeId;
	}


	public void setTxName(String txName) {
		this.txName = txName;
	}


	public void setProvider(String provider) {
		this.provider = provider;
	}


	public void setTxRefId(String txRefId) {
		this.txRefId = txRefId;
	}
	
	
}

