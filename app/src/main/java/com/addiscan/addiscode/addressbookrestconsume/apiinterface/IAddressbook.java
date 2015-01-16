package com.addiscan.addiscode.addressbookrestconsume.apiinterface;

import com.addiscan.addiscode.addressbookrestconsume.models.*;

import java.util.List;
import java.util.UUID;

import retrofit.Callback;
import retrofit.http.*;

/**
 * Created by Abdu on 1/14/2015.
 */
public interface IAddressbook {
    @GET("/Contact")
    public List<Contact> GetContacts();
    @GET("/Contact")
    public void getContacts(Callback<ContactData> response);
    @GET("/Contact/{Id}/")
    public void getContactDetail(@Path("Id") String ContactId, Callback<ContactData> response);
    @POST("/Contact")
    public void SaveContact(@Body Contact contact, Callback<ContactData> response);
    @PUT("/Contact")
    public void UpdateContact(@Body Contact body, Callback<ContactData> response);
    @DELETE("/Contact/{Id}")
    public void DeleteContact(@Path("Id") String ContactId, Callback<ResponseStatus> response);
}
