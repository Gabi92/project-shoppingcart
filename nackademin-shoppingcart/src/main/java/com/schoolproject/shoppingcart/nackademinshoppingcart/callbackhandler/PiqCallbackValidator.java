package com.schoolproject.shoppingcart.nackademinshoppingcart.callbackhandler;

import com.schoolproject.shoppingcart.nackademinshoppingcart.callbackhandler.callbackinput.AuthorizeTxInput;
import com.schoolproject.shoppingcart.nackademinshoppingcart.callbackhandler.callbackinput.CancelTxInput;
import com.schoolproject.shoppingcart.nackademinshoppingcart.callbackhandler.callbackinput.TransferTxInput;
import com.schoolproject.shoppingcart.nackademinshoppingcart.callbackhandler.callbackinput.VerifyUserInput;
import com.schoolproject.shoppingcart.nackademinshoppingcart.siteuser.SiteUser;

public class PiqCallbackValidator {

    public boolean validateVerifyUserRequest(SiteUser user, VerifyUserInput indata) {

        if(!indata.getUserId().equals(user.getUserId().toString())) {

            return false;

        } else {

            return true;
        }
    }

    public boolean validateAutorizeTxRequest(SiteUser user, AuthorizeTxInput indata) {

        if(!indata.getUserId().equals(user.getUserId().toString())){

            return false;

        } else {

            return true;
        }
    }

    public boolean validateTransferTxRequest(SiteUser user, TransferTxInput indata) {

        if(!indata.getUserId().equals(user.getUserId().toString())) {

            return false;

        } else {

            return true;
        }
    }

    public boolean validateCancelTxRequest(SiteUser user, CancelTxInput indata) {

        if(!indata.getUserId().equals(user.getUserId().toString())) {

            return false;

        } else {

            return true;
        }
    }
}
