package com.whartonsummit.android_app.pwcs_android.Adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.whartonsummit.android_app.pwcs_android.Activities.ContactDetailsActivity;
import com.whartonsummit.android_app.pwcs_android.Activities.EventDetailsActivity;
import com.whartonsummit.android_app.pwcs_android.Activities.PanelDetailsActivity;
import com.whartonsummit.android_app.pwcs_android.Models.Contact;
import com.whartonsummit.android_app.pwcs_android.Models.Panel;
import com.whartonsummit.android_app.pwcs_android.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by zhileizheng on 4/18/18.
 */

public class ContactsListAdapter extends RecyclerView.Adapter<ContactsListAdapter.ViewHolder>{

    List<Contact> data;

    public ContactsListAdapter(List<Contact> contactsData) {
        this.data = contactsData;
    }

    @Override
    public ContactsListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.contact_list_item, parent, false);
        return new ContactsListAdapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final ContactsListAdapter.ViewHolder holder, int position) {
        final Contact contact = data.get(position);
        holder.contactName.setText(contact.getFirstName() + " " + contact.getLastName());
        holder.detailBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = goToDetail(contact, holder.detailBtn.getContext());
                holder.detailBtn.getContext().startActivity(intent);
            }
        });
    }

    private Intent goToDetail(Contact contact, Context context) {
        Intent intent= new Intent(context, ContactDetailsActivity.class);
        intent.putExtra("contact", contact);
        return intent;
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.contact_name) TextView contactName;
        @BindView(R.id.to_detail_button) ImageButton detailBtn;

        public ViewHolder(View v) {
            super(v);
            ButterKnife.bind(this, v);
        }
    }

    public void refreshData(List<Contact> contacts) {
        data = contacts;
        notifyDataSetChanged();
    }
}
