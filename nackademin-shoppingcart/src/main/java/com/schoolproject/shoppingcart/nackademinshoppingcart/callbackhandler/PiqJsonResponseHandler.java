package com.schoolproject.shoppingcart.nackademinshoppingcart.callbackhandler;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.schoolproject.shoppingcart.nackademinshoppingcart.callbackhandler.callbackinput.TransferTxInput;
import com.schoolproject.shoppingcart.nackademinshoppingcart.callbackhandler.callbackinput.VerifyUserInput;
import com.schoolproject.shoppingcart.nackademinshoppingcart.siteuser.SiteUser;

import java.util.UUID;

public class PiqJsonResponseHandler {

    public String verifyUserSuccess(SiteUser user) {

        String response;
        JsonObject jsonobj = new JsonObject();

        jsonobj.addProperty("userId",user.getUserId());
        jsonobj.addProperty("success",true);
        jsonobj.addProperty("firstName",user.getFirstName());
        jsonobj.addProperty("lastName",user.getLastName());
        jsonobj.addProperty("street",user.getStreet());
        jsonobj.addProperty("city",user.getCity());
        jsonobj.addProperty("zip",user.getZip());
        jsonobj.addProperty("country",user.getCountry());
        jsonobj.addProperty("email",user.getEmail());
        jsonobj.addProperty("dob",user.getDob());
        jsonobj.addProperty("mobile",user.getMobile());
        jsonobj.addProperty("balance",user.getBalance());
        jsonobj.addProperty("balanceCy",user.getBalanceCy());

        response = new Gson().toJson(jsonobj);

        return response;
    }


    public String verifyUserFailed(SiteUser user, VerifyUserInput indata, PiqValidateObject pvo) {

        String response;
        JsonObject jsonobj = new JsonObject();

        jsonobj.addProperty("sessionId", indata.getSessionId());
        jsonobj.addProperty("userId", indata.getUserId());
        jsonobj.addProperty("success", false);
        jsonobj.addProperty("errMsg", pvo.getResultMessage());

        response = new Gson().toJson(jsonobj);

        return response;

    }


    public String authorizeTxSuccess(SiteUser user) {

        String response;
        JsonObject jsonobj = new JsonObject();
        UUID authCode = UUID.randomUUID();

        jsonobj.addProperty("userId", user.getUserId());
        jsonobj.addProperty("success", true);
        jsonobj.addProperty("merchantTxId","1");
        jsonobj.addProperty("authCode", authCode.toString());

        response = new Gson().toJson(jsonobj);

        return response;


    }


    public String authorizeTxFailed(SiteUser user,PiqValidateObject pvo) {

        String response;
        JsonObject jsonobj = new JsonObject();
        UUID authCode = UUID.randomUUID();

        jsonobj.addProperty("userId", user.getUserId());
        jsonobj.addProperty("success", false);
        jsonobj.addProperty("authCode", authCode.toString());
        jsonobj.addProperty("errMsg", pvo.getResultMessage());

        response = new Gson().toJson(jsonobj);

        return response;
    }



    public String transferTxSucess(SiteUser user, TransferTxInput indata) {

        String response;

        JsonObject jsonobj = new JsonObject();

        jsonobj.addProperty("userId", user.getUserId());
        jsonobj.addProperty("success", true);
        jsonobj.addProperty("txId", indata.getTxId());
        jsonobj.addProperty("merchantTxId", "1");

        response = new Gson().toJson(jsonobj);

        return response;

    }


    public String transferTxFailed(SiteUser user, TransferTxInput indata, PiqValidateObject pvo) {
        String response;
        JsonObject jsonobj = new JsonObject();

        jsonobj.addProperty("userId", user.getUserId());
        jsonobj.addProperty("success", false);
        jsonobj.addProperty("txId", indata.getTxId());
        jsonobj.addProperty("errMsg", pvo.getResultMessage());

        response = new Gson().toJson(jsonobj);

        return response;
    }


    public String cancelTxSuccess(SiteUser user) {

        String response;
        JsonObject jsonobj = new JsonObject();

        jsonobj.addProperty("userId", user.getUserId());
        jsonobj.addProperty("success", true);

        response = new Gson().toJson(jsonobj);

        return response;

    }

    public String cancelTxFailed(SiteUser user, PiqValidateObject pvo) {

        String response;
        JsonObject jsonobj = new JsonObject();

        jsonobj.addProperty("userId", user.getUserId());
        jsonobj.addProperty("success", false);
        jsonobj.addProperty("errMsg", pvo.getResultMessage());

        response = new Gson().toJson(jsonobj);

        return response;
    }
}
