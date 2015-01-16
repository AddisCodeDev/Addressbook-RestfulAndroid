package com.addiscan.addiscode.addressbookrestconsume;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.addiscan.addiscode.addressbookrestconsume.apihandler.AddressbookAPIHandler;
import com.addiscan.addiscode.addressbookrestconsume.clientdata.ClientData;
import com.addiscan.addiscode.addressbookrestconsume.models.Contact;
import com.addiscan.addiscode.addressbookrestconsume.models.ContactData;

import java.util.ArrayList;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by Mohammed on 1/11/2015.
 */
public class DetailContactActivity extends Activity {
    private TextView fullName,email,department,year;
    private Contact contact;
    private ClientData clientData;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_contact);
        getActionBar().setDisplayHomeAsUpEnabled(true);

        fullName = (TextView)findViewById(R.id.detailFullName);
        email = (TextView)findViewById(R.id.detailEmail);
        department = (TextView)findViewById(R.id.detailDepartment);
        year = (TextView)findViewById(R.id.detailYear);

        contact = new Contact();
        clientData = new ClientData();

        String id = getIntent().getExtras().getString("Id");

        contact = clientData.GetContactDetail(id);

        fullName.setText(contact.FirstName + " " + contact.LastName);
        email.setText(contact.Email);
        department.setText(contact.Department);
        year.setText(contact.Year);
       // Log.d("DetailContactActivity",id);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_detail_contact,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {

            case android.R.id.home:
                startActivity(new Intent(this, MainActivity.class));
                return true;

            case R.id.menu_edit:
                Intent intent = new Intent().setClass(this, EditContactActivity.class);
                ArrayList<CharSequence> cont = new ArrayList<CharSequence>();
                cont.add(contact.Id);
                cont.add(contact.FirstName);
                cont.add(contact.LastName);
                cont.add(contact.Email);
                cont.add(contact.Department);
                cont.add(contact.Year);
                intent.putCharSequenceArrayListExtra("contact",cont);
                startActivity(intent);
                return true;

            case R.id.menu_discard:
                startActivity(new Intent(this, MainActivity.class));
                return true;

        }
        return true;
    }

}
