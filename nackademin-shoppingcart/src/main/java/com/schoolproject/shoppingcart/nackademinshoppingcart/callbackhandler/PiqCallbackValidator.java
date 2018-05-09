package com.schoolproject.shoppingcart.nackademinshoppingcart.callbackhandler;

import com.schoolproject.shoppingcart.nackademinshoppingcart.callbackhandler.callbackinput.AuthorizeTxInput;
import com.schoolproject.shoppingcart.nackademinshoppingcart.callbackhandler.callbackinput.CancelTxInput;
import com.schoolproject.shoppingcart.nackademinshoppingcart.callbackhandler.callbackinput.TransferTxInput;
import com.schoolproject.shoppingcart.nackademinshoppingcart.callbackhandler.callbackinput.VerifyUserInput;
import com.schoolproject.shoppingcart.nackademinshoppingcart.siteuser.SiteUser;

public class PiqCallbackValidator {

    public PiqValidateObject validateVerifyUserRequest(SiteUser user, VerifyUserInput indata, PiqValidateObject pvo) {

        if (!indata.getUserId().equals(user.getUserId().toString())) {

            pvo.setSuccess(false);
            pvo.setResultMessage(pvo.ERROR_USERID_DOES_NOT_MATCH);

            return pvo;

        } else {

            pvo.setSuccess(true);
            pvo.setResultMessage("");

            return pvo;

        }

    }

    public PiqValidateObject validateAutorizeTxRequest(SiteUser user, AuthorizeTxInput indata, PiqValidateObject pvo) {

        if (!indata.getUserId().equals(user.getUserId().toString())) {

            pvo.setSuccess(false);
            pvo.setResultMessage(pvo.ERROR_USERID_DOES_NOT_MATCH);

            return pvo;

        } else if(!(indata.getTxAmount() <= user.getBalance())){

            pvo.setSuccess(false);
            pvo.setResultMessage(pvo.ERROR_NOT_ENOUGH_CURRENCY);

            return pvo;

        } else if(!indata.getTxAmountCy().equals(user.getBalanceCy())) {


            pvo.setSuccess(false);
            pvo.setResultMessage(pvo.ERROR_TXCY_DOES_NOT_MATCH_BALANCECY);

        } else

            pvo.setSuccess(true);

        return pvo;

    }

    public PiqValidateObject validateTransferTxRequest(SiteUser user, TransferTxInput indata, PiqValidateObject pvo) {

        if (!indata.getUserId().equals(user.getUserId().toString())) {

            pvo.setSuccess(false);
            pvo.setResultMessage(pvo.ERROR_USERID_DOES_NOT_MATCH);

            return pvo;

        } else if(!indata.getTxAmountCy().equals(user.getBalanceCy())){

            pvo.setSuccess(false);
            pvo.setResultMessage(pvo.ERROR_TXCY_DOES_NOT_MATCH_BALANCECY);

            return pvo;

        } else {

            pvo.setSuccess(true);

            return pvo;
        }

    }

    public PiqValidateObject validateCancelTxRequest(SiteUser user, CancelTxInput indata, PiqValidateObject pvo) {

        if (!indata.getUserId().equals(user.getUserId().toString())) {

            pvo.setSuccess(false);
            pvo.setResultMessage(pvo.ERROR_USERID_DOES_NOT_MATCH);
            return pvo;

        } else

            pvo.setSuccess(true);
        return pvo;

    }
}
