package com.addiscan.addiscode.addressbookrestconsume.dbmodels;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

/**
 * Created by Abdu on 1/21/2015.
 */
@Table(name="Contacts")
public class ContactTable extends Model {
    @Column(name = "FirstName")
    public String FirstName;
    @Column(name = "LastName")
    public String LastName;
    @Column(name="Email")
    public String Email;
    @Column(name="Department")
    public String Department;
    @Column(name="Year")
    public String Year;

    public ContactTable(){}
}
