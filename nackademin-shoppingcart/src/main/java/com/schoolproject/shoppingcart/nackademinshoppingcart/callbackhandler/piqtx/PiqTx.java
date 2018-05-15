package com.schoolproject.shoppingcart.nackademinshoppingcart.callbackhandler.piqtx;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class PiqTx {

    @Id
    @GeneratedValue
    private Long txId;

    private String userId;
    private String sessionId;
    private Double txAmount;
    private String txAmountCy;
    private String piqTxId;
    private int txTypeId;
    private String txName;
    private String provider;
    private String authCode;
    private String txPspAmount;
    private String txPspAmountCy;
    private String fee;
    private String feeCy;
    private String txRefId;
    private String verifyUserResponse;
    private String authorizeTxResponse;
    private String transferTxResponse;
    private String cancelTxResponse;
    private String txSuccess;
    private String txMsg;

    //getters

    public Long getTxId() {
        return txId;
    }

    public String getUserId() {
        return userId;
    }

    public String getSessionId() {
        return sessionId;
    }

    public Double getTxAmount() {
        return txAmount;
    }

    public String getTxAmountCy() {
        return txAmountCy;
    }

    public String getPiqTxId() {
        return piqTxId;
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

    public String getAuthCode() {
        return authCode;
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

    public String getTxRefId() {
        return txRefId;
    }

    public String getTxSuccess() {
        return txSuccess;
    }

    public String getTxMsg() {
        return txMsg;
    }

    public String getVerifyUserResponse() {
        return verifyUserResponse;
    }

    public String getAuthorizeTxResponse() {
        return authorizeTxResponse;
    }

    public String getTransferTxResponse() {
        return transferTxResponse;
    }

    public String getCancelTxResponse() {
        return cancelTxResponse;
    }


    //setters

    public void setTxId(Long txId) {
        this.txId = txId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public void setTxAmount(Double txAmount) {
        this.txAmount = txAmount;
    }

    public void setTxAmountCy(String txAmountCy) {
        this.txAmountCy = txAmountCy;
    }

    public void setPiqTxId(String piqTxId) {
        this.piqTxId = piqTxId;
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

    public void setAuthCode(String authCode) {
        this.authCode = authCode;
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

    public void setTxRefId(String txRefId) {
        this.txRefId = txRefId;
    }

    public void setVerifyUserResponse(String verifyUserResponse) {
        this.verifyUserResponse = verifyUserResponse;
    }

    public void setAuthorizeTxResponse(String authorizeTxResponse) {
        this.authorizeTxResponse = authorizeTxResponse;
    }

    public void setTransferTxResponse(String transferTxResponse) {
        this.transferTxResponse = transferTxResponse;
    }

    public void setCancelTxResponse(String cancelTxResponse) {
        this.cancelTxResponse = cancelTxResponse;
    }

    public void setTxSuccess(String success) {
        this.txSuccess = success;
    }

    public void setTxMsg(String txMsg) {
        this.txMsg = txMsg;
    }
}
