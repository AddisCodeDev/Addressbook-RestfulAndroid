package com.addiscan.addiscode.addressbookrestconsume.listadapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.addiscan.addiscode.addressbookrestconsume.R;
import com.addiscan.addiscode.addressbookrestconsume.apihandler.AddressbookAPIHandler;
import com.addiscan.addiscode.addressbookrestconsume.models.Contact;
import com.addiscan.addiscode.addressbookrestconsume.models.ContactData;

import java.util.List;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by Mohammed on 1/11/2015.
 */
public class ContactListAdapter extends BaseAdapter {
    private List<Contact> mListContact;
    private Context mContext;

    public ContactListAdapter(Context context,List<Contact> contacts){
        this.mContext = context;
        this.mListContact = contacts;
    }

    public ContactListAdapter(Context context){
        this.mContext = context;
    }

    @Override
    public int getCount() {
        return mListContact.size();
    }

    @Override
    public Object getItem(int position) {
        return mListContact.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public void setChecked(int position,boolean checked) {
       // mListContact.get(position).isChecked = checked;
       // notifyDataSetChanged();
    }

    public void unCheck(int position) {

       // mListContact.get(position).isChecked = false;

       // notifyDataSetChanged();
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        Contact contact = mListContact.get(position);
        final ViewHolder viewHolder = new ViewHolder();

        convertView = LayoutInflater.from(mContext).inflate(R.layout.activity_list_contact_item,
                parent,false);


        viewHolder.firstName = (TextView)convertView.findViewById(R.id.firstNameListContact);
        viewHolder.lastName = (TextView)convertView.findViewById(R.id.lastNameListContact);



        /*AddressbookAPIHandler.getApiInterface().getContacts(new Callback<ContactData>() {

            @Override
            public void success(ContactData contactData, Response response) {
                viewHolder.firstName.setText(contactData.getContacts().get(position).FirstName);
                viewHolder.lastName.setText(contactData.getContacts().get(position).LastName);
            }

            @Override
            public void failure(RetrofitError error) {

            }

        });*/
        //

        viewHolder.firstName.setText(contact.FirstName);
        viewHolder.lastName.setText(contact.LastName);

        return convertView;
    }

    class ViewHolder{
        public TextView firstName;
        public TextView lastName;

        public ViewHolder(){}
    }
}
