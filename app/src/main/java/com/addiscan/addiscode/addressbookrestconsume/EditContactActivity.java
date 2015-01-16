package com.addiscan.addiscode.addressbookrestconsume;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.addiscan.addiscode.addressbookrestconsume.clientdata.ClientData;
import com.addiscan.addiscode.addressbookrestconsume.models.Contact;

import java.util.ArrayList;

/**
 * Created by Mohammed on 1/14/2015.
 */
public class EditContactActivity extends Activity {
    private TextView firstName,lastName,email,department,year;
    private Contact contact;
    private ArrayList<CharSequence> contactList = new ArrayList<CharSequence>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_contact);
        getActionBar().setDisplayHomeAsUpEnabled(true);

        firstName = (TextView)findViewById(R.id.firstNameEditTextNewContact);
        lastName = (TextView)findViewById(R.id.lastNameEditTextNewContact);
        email = (TextView)findViewById(R.id.emailEditTextNewContact);
        department = (TextView)findViewById(R.id.departmentEditTextNewContact);
        year = (TextView)findViewById(R.id.yearEditTextNewContact);

        contactList = getIntent().getCharSequenceArrayListExtra("contact");

        contact = new Contact(
                (String)contactList.get(0),
                (String)contactList.get(1),
                (String)contactList.get(2),
                (String)contactList.get(3),
                (String)contactList.get(4),
                (String)contactList.get(5)
        );

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        String sett = prefs.getString("api_location","");
        Log.d("EditActivity",sett);

        firstName.setText(contact.FirstName);
        lastName.setText(contact.LastName);
        email.setText(contact.Email);
        department.setText(contact.Department);
        year.setText(contact.Year);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_new_contact,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {

            case android.R.id.home:
               // startActivity(new Intent(this, DetailContactActivity.class));
                return true;

            case R.id.menu_save:

                Contact updateContact = new Contact(
                        contact.Id,
                        firstName.getText().toString(),
                        lastName.getText().toString(),
                        email.getText().toString(),
                        department.getText().toString(),
                        year.getText().toString()
                );


                ClientData.UpdateContact(updateContact);
               // startActivity(new Intent(this, DetailContactActivity.class));
                break;

            case R.id.menu_discard:
                startActivity(new Intent(this, DetailContactActivity.class));
                return true;
        }
        return true;
    }
}
