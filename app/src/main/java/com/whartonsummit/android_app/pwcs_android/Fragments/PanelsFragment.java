package com.whartonsummit.android_app.pwcs_android.Fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.whartonsummit.android_app.pwcs_android.Adapters.PanelsListAdapter;
import com.whartonsummit.android_app.pwcs_android.Adapters.SpeakerListAdapter;
import com.whartonsummit.android_app.pwcs_android.Models.Panel;
import com.whartonsummit.android_app.pwcs_android.R;

import java.util.ArrayList;
import java.util.List;

public class PanelsFragment extends Fragment {

    private RecyclerView panelsRecyclerView;
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
        panelsRecyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerView);
        linearLayoutManager = new LinearLayoutManager(getContext());
        panelsRecyclerView.setLayoutManager(linearLayoutManager);

        // set Adapters
        adapter = new PanelsListAdapter(getPanelsData());
        panelsRecyclerView.setAdapter(adapter);
        return rootView;
    }

    private List<Panel> getPanelsData() {
        List<Panel> panels = new ArrayList<Panel>();
        panels.add(new Panel("Finance Panel", R.drawable.panel_bg_1,
                "Make America Great Again", "9:00AM - 11:00AM",
                "Annenburg Center", "This is an awesome panel."));
        panels.add(new Panel("Technology Panel", R.drawable.panel_bg_2,
                "Make America Tech Again", "1:00PM - 3:00PM",
                "Annenburg Center", "This is an awesome panel."));
        return panels;
    }
}
