package com.addiscan.addiscode.addressbookrestconsume.models;

/**
 * Created by Abdu on 1/14/2015.
 */
public class Contact {
    public String Id;
    public String FirstName;
    public String LastName;
    public String Email;
    public String Department;
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
