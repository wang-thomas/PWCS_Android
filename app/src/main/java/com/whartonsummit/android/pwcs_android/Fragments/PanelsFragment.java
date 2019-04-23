package com.whartonsummit.android.pwcs_android.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.whartonsummit.android.pwcs_android.Adapters.PanelsListAdapter;
import com.whartonsummit.android.pwcs_android.Models.Panel;
import com.whartonsummit.android.pwcs_android.R;
import com.whartonsummit.android.pwcs_android.Services.DataService;

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
        return DataService.getInstance().getPanels();
    }
}
