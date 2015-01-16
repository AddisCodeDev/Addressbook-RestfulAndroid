package com.addiscan.addiscode.addressbookrestconsume.clientdata;

import android.location.Address;

import com.addiscan.addiscode.addressbookrestconsume.apihandler.AddressbookAPIHandler;
import com.addiscan.addiscode.addressbookrestconsume.models.*;


import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by Abdu on 1/14/2015.
 */
public class ClientData {
    public static List<Contact> contacts = new ArrayList<Contact>();
    public static Contact contact = new Contact();



    public void GetContacts(){

      //final List<Contact> contacts = new ArrayList<Contact>();
       AddressbookAPIHandler.getApiInterface().getContacts(new Callback<ContactData>() {

           @Override
           public void success(ContactData contactData, Response response) {
               contacts = contactData.getContacts();
           }

           @Override
           public void failure(RetrofitError error) {

           }
       });

   }

    public static Contact GetContactDetail(String Id){
       AddressbookAPIHandler.getApiInterface().getContactDetail(Id,new Callback<ContactData>() {
           @Override
           public void success(ContactData contactData, Response response) {
               contact = contactData.getContact();
           }

           @Override
           public void failure(RetrofitError error) {

           }
       });
       return contact;
   }

    public static void SaveContact(Contact contact){


        AddressbookAPIHandler.getApiInterface().SaveContact(contact,new Callback<ContactData>() {
            @Override
            public void success(ContactData contactData, Response response) {

            }

            @Override
            public void failure(RetrofitError error) {

            }
        });

    }

    public static void UpdateContact(Contact contact){

        AddressbookAPIHandler.getApiInterface().UpdateContact(contact,new Callback<ContactData>() {
            @Override
            public void success(ContactData contactData, Response response) {

            }

            @Override
            public void failure(RetrofitError error) {

            }
        });
    }

    public static void DeleteContact(String Id){
        AddressbookAPIHandler.getApiInterface().DeleteContact(Id,new Callback<ResponseStatus>() {
            @Override
            public void success(ResponseStatus responseStatus, Response response) {

            }

            @Override
            public void failure(RetrofitError error) {

            }
        });
    }
}
