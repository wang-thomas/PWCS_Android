package com.whartonsummit.android_app.pwcs_android.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.whartonsummit.android_app.pwcs_android.Adapters.EventsListAdapter;
import com.whartonsummit.android_app.pwcs_android.Adapters.PanelsListAdapter;
import com.whartonsummit.android_app.pwcs_android.Models.Event;
import com.whartonsummit.android_app.pwcs_android.Models.Panel;
import com.whartonsummit.android_app.pwcs_android.R;
import com.whartonsummit.android_app.pwcs_android.Services.DataService;

import java.util.List;

/**
 * Created by zhileizheng on 4/1/18.
 */

public class EventsFragment extends Fragment {

    private RecyclerView eventsRecyclerView;
    private RecyclerView.LayoutManager linearLayoutManager;
    private RecyclerView.Adapter adapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_panels, container, false);

        // setUpRecyclerView
        eventsRecyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerView);
        linearLayoutManager = new LinearLayoutManager(getContext());
        eventsRecyclerView.setLayoutManager(linearLayoutManager);

        // set Adapters
        adapter = new EventsListAdapter(getEventsData());
        eventsRecyclerView.setAdapter(adapter);
        return rootView;
    }

    private List<Event> getEventsData() {
        return DataService.getInstance().getEvents();
    }
}

