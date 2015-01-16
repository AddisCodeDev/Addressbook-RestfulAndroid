package com.addiscan.addiscode.addressbookrestconsume.models;

import java.util.*;

/**
 * Created by Abdu on 1/14/2015.
 */
public class ContactData {
    public ResponseStatus ResponseStatus;
    public Contact Contact;
    public List<Contact> Contacts;


    public Contact getContact() {
        return Contact;
    }

    public void setContact(Contact contact) {
        Contact = contact;
    }

    public ResponseStatus getResponseStatus() {
        return ResponseStatus;
    }

    public void setResponseStatus(ResponseStatus responseStatus) {
        ResponseStatus = responseStatus;
    }

    public List<Contact> getContacts() {
        return Contacts;
    }

    public void setContacts(List<Contact> contacts) {
        Contacts = contacts;
    }
}
