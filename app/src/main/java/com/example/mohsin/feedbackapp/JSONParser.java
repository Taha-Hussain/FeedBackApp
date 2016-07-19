package com.example.mohsin.feedbackapp;


import android.annotation.SuppressLint;
import android.util.Log;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JSONParser {
    public JSONParser()
    {
        super();
    }



    @SuppressLint("LongLogTag")
    public boolean parseUserAuth(JSONObject object)
    {     boolean userAtuh=false;
        try {
            userAtuh= object.getBoolean("Value");
        } catch (JSONException e) {
            // TODO Auto-generated catch block
            Log.d("JSONParser => parseUserAuth", e.getMessage());
        }

        return userAtuh;
    }

    @SuppressLint("LongLogTag")
    public UserDetailsTable parseCustomer_details(JSONObject object)
    {
        UserDetailsTable userDetail=new UserDetailsTable();

        try {
            JSONObject jsonObj=object.getJSONArray("Value").getJSONObject(0);

            userDetail.setCustomerName(jsonObj.getString("customerName"));
            userDetail.setCustomerFeedback(jsonObj.getString("customerFeedback"));

        } catch (JSONException e) {
            // TODO Auto-generated catch block
            Log.d("JSONParser => parseUserDetails", e.getMessage());
        }

        return userDetail;

    }


}
