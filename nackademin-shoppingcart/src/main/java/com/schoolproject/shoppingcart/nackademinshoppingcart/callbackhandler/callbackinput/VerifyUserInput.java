package com.schoolproject.shoppingcart.nackademinshoppingcart.callbackhandler.callbackinput;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class VerifyUserInput {
	
	
	private String userId;
	private String sessionId;
	
	
	//Constructor
	
	public VerifyUserInput(String input) throws Exception {
	
		ObjectMapper mapper = new ObjectMapper();
		
		mapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
        JsonNode node = mapper.readValue(input, JsonNode.class);
       
        
		this.userId = node.get("userId").asText();
		this.sessionId = node.get("sessionId").asText();
	}

	
	//Getters

	public String getUserId() {
		return userId;
	}


	public String getSessionId() {
		return sessionId;
	}
	
	
	//Setters
	
	public void setUserId(String userId) {
		this.userId = userId;
	}


	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}


	@Override
	public String toString() {
		return "VerifyUserInput [userId=" + userId + ", sessionId=" + sessionId + "]";
	}
	
	

}
