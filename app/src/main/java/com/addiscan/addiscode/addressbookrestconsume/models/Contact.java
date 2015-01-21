package com.addiscan.addiscode.addressbookrestconsume.models;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

/**
 * Created by Abdu on 1/14/2015.
 */
//@Table(name="Contacts")
public class Contact {
    public String Id;
    //@Column(name="FirstName")
    public String FirstName;
    //@Column(name="LastName")
    public String LastName;
    //@Column(name="Email")
    public String Email;
    //@Column(name="Department")
    public String Department;
    //@Column(name="Year")
    public String Year;


    public Contact(){}

    public Contact (String Id,String FirstName,String LastName,String Email,String Department,String Year){
        this.Id = Id;
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.Email = Email;
        this.Department = Department;
        this.Year = Year;

    }

    public String toString(){
        return this.Department;
    }
}
