package com.whartonsummit.android_app.pwcs_android.Fragments;


import android.os.Bundle;
import android.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.whartonsummit.android_app.pwcs_android.Adapters.ContactsListAdapter;
import com.whartonsummit.android_app.pwcs_android.Adapters.PanelsListAdapter;
import com.whartonsummit.android_app.pwcs_android.Models.Contact;
import com.whartonsummit.android_app.pwcs_android.Models.Panel;
import com.whartonsummit.android_app.pwcs_android.R;
import com.whartonsummit.android_app.pwcs_android.Services.DataService;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ContactsFragment extends android.support.v4.app.Fragment {

    private RecyclerView contactsRecyclerView;
    private RecyclerView.LayoutManager linearLayoutManager;
    private ContactsListAdapter adapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_contacts, container, false);

        // setUpRecyclerView
        contactsRecyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerView);
        linearLayoutManager = new LinearLayoutManager(getContext());
        contactsRecyclerView.setLayoutManager(linearLayoutManager);

        // set Adapters
        adapter = new ContactsListAdapter(getContactsData());
        contactsRecyclerView.setAdapter(adapter);

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(contactsRecyclerView.getContext(),
                LinearLayoutManager.VERTICAL);
        contactsRecyclerView.addItemDecoration(dividerItemDecoration);
        return rootView;
    }

    private List<Contact> getContactsData() {
        return DataService.getInstance().getContacts();
    }

    @Override
    public void onResume() {
        super.onResume();
        adapter.refreshData(getContactsData());
    }
}
