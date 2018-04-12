package com.schoolproject.shoppingcart.nackademinshoppingcart.callbackhandler.callbackinput;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class AuthorizeTxInput {

    private String userId;
    private Double txAmount;
    private String txAmountCy;
    private String txId;
    private int txTypeId;
    private String txName;
    private String provider;


    //Constructor

    public AuthorizeTxInput(String input) throws Exception {

        ObjectMapper mapper = new ObjectMapper();

        mapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
        JsonNode node = mapper.readValue(input, JsonNode.class);

        this.userId = node.get("userId").asText();
        this.txAmount = node.get("txAmount").asDouble();
        this.txAmountCy = node.get("txAmountCy").asText();
        this.txId = node.get("txId").asText();
        this.txTypeId = node.get("txTypeId").asInt();
        this.txName = node.get("txName").asText();
        this.provider = node.get("provider").asText();
    }

    //Getters
    public String getUserId() {
        return userId;
    }
    public Double getTxAmount() {
        return txAmount;
    }
    public String getTxAmountCy() {
        return txAmountCy;
    }
    public String getTxId() {
        return txId;
    }
    public int getTxTypeId() {
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
    public void setTxAmount(Double txAmount) {
        this.txAmount = txAmount;
    }
    public void setTxAmountCy(String txAmountCy) {
        this.txAmountCy = txAmountCy;
    }
    public void setTxId(String txId) {
        this.txId = txId;
    }
    public void setTxTypeId(int txTypeId) {
        this.txTypeId = txTypeId;
    }
    public void setTxName(String txName) {
        this.txName = txName;
    }
    public void setProvider(String provider) {
        this.provider = provider;
    }

}
