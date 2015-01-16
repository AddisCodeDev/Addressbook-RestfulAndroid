package com.addiscan.addiscode.addressbookrestconsume.apihandler;

import com.addiscan.addiscode.addressbookrestconsume.apiinterface.*;

import retrofit.RestAdapter;

/**
 * Created by Abdu on 1/14/2015.
 */
public class AddressbookAPIHandler {

    private static final String API_URL = "http://192.168.1.123:8015/api";
    private static RestAdapter restAdapter;
    private static RestAdapter getRestAdapter(){
        if(restAdapter==null){
            restAdapter = new RestAdapter.Builder().setEndpoint(API_URL).build();
        }
        return restAdapter;
    }

    public static IAddressbook getApiInterface(){
        IAddressbook addressbook = null;
        try{
            if(restAdapter==null){
                restAdapter = getRestAdapter();
            }
            addressbook = restAdapter.create(IAddressbook.class);
        }catch (Exception e){
            e.printStackTrace();
        }
        return addressbook;
    }

}
