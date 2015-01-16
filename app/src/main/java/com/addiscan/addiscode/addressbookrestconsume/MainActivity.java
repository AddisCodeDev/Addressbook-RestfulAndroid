package com.addiscan.addiscode.addressbookrestconsume;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListView;

import com.addiscan.addiscode.addressbookrestconsume.apihandler.AddressbookAPIHandler;
import com.addiscan.addiscode.addressbookrestconsume.clientdata.ClientData;
import com.addiscan.addiscode.addressbookrestconsume.listadapter.ContactListAdapter;
import com.addiscan.addiscode.addressbookrestconsume.models.Contact;
import com.addiscan.addiscode.addressbookrestconsume.models.ContactData;

import java.util.ArrayList;
import java.util.List;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by Mohammed on 1/11/2015.
 */
public class MainActivity extends Activity{
    private ListView listView;
    private ContactListAdapter mContactListAdapter;
    private List<Contact> mListContact;

    private int numSelected = 0;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AddressbookAPIHandler.getApiInterface().getContacts(new Callback<ContactData>() {

            @Override
            public void success(ContactData contactData, Response response) {
                mListContact = contactData.getContacts();
                listView = (ListView)findViewById(R.id.listView);

                mContactListAdapter = new ContactListAdapter(MainActivity.this,mListContact);

                // mContactListAdapter = new ContactListAdapter(this);
                listView.setAdapter(mContactListAdapter);
                listView.setOnItemClickListener(new ContactItemClickListener());
                listView.setMultiChoiceModeListener(new ContactItemOnLongClickListener());
            }

            @Override
            public void failure(RetrofitError error) {

            }

        });



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {

            case R.id.menu_add:
                startActivity(new Intent().setClass(this,NewContactActivity.class));
                break;
            case R.id.menu_preference:
                startActivity(new Intent().setClass(this,SettingActivity.class));
                break;
        }
        return true;
    }

    public class ContactItemClickListener implements AdapterView.OnItemClickListener{

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Intent intent = new Intent();
            intent.setClass(getBaseContext(), DetailContactActivity.class);
            String contactId = mListContact.get(position).Id;
            intent.putExtra("Id",contactId);
            startActivity(intent);
        }

    }

    public class ContactItemOnLongClickListener implements AbsListView.MultiChoiceModeListener{

        List<Contact> listOfSelectedItem = new ArrayList<Contact>();

        @Override
        public void onItemCheckedStateChanged(ActionMode mode, int position, long id, boolean checked) {
            if (checked) {
                mContactListAdapter.setChecked(position, true);
                numSelected++;
                listOfSelectedItem.add(mListContact.get(position));
            } else {
                mContactListAdapter.unCheck(position);
                numSelected--;
                listOfSelectedItem.remove(mListContact.get(position));
            }

            mode.setTitle(numSelected + " item selected");
        }

        @Override
        public boolean onCreateActionMode(ActionMode mode, Menu menu) {
            mode.getMenuInflater().inflate(R.menu.menu_context_main,menu);
            return true;
        }

        @Override
        public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
            return false;
        }

        @Override
        public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
            switch (item.getItemId()){
                case R.id.menu_delete:
                    for(Contact contact : listOfSelectedItem){
                        mListContact.remove(contact);
                       ClientData.DeleteContact(contact.Id);
                    }
                    mContactListAdapter.notifyDataSetChanged();
                    numSelected = 0;
                    mode.finish();
                    return true;
                default:
                    return  false;
            }
        }

        @Override
        public void onDestroyActionMode(ActionMode mode) {

        }

    }

    public List<Contact> setContacts(){
        List<Contact> listContact = new ArrayList<Contact>();
        //listContact = AddressbookAPIHandler.getApiInterface().GetContacts();

        //listContact = new ClientData().GetContacts();

        return listContact;
    }

}
