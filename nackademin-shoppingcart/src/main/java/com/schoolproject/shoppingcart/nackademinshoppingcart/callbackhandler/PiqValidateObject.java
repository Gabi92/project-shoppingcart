package com.schoolproject.shoppingcart.nackademinshoppingcart.callbackhandler;

public class PiqValidateObject {

    private boolean success;
    private String resultMessage = "";

    final String ERROR_USERID_DOES_NOT_MATCH = "ERROR_USERID_DOES_NOT_MATCH";
    final String ERROR_NOT_ENOUGH_CURRENCY = "ERROR_NOT_ENOUGH_CURRENCY";
    final String ERROR_TXCY_DOES_NOT_MATCH_BALANCECY = "ERROR_TXCY_DOES_NOT_MATCH_BALANCECY";


    public PiqValidateObject() {
    }


    public boolean isSuccess() {
        return success;
    }


    public void setSuccess(boolean success) {
        this.success = success;
    }


    public String getResultMessage() {
        return resultMessage;
    }


    public void setResultMessage(String resultMessage) {
        this.resultMessage = resultMessage;
    }

}
