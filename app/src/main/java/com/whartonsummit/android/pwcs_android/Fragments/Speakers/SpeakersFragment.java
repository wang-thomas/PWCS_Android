package com.whartonsummit.android.pwcs_android.Fragments.Speakers;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.whartonsummit.android.pwcs_android.Adapters.SpeakerListAdapter;
import com.whartonsummit.android.pwcs_android.Models.Speaker;
import com.whartonsummit.android.pwcs_android.R;

import java.util.ArrayList;
import java.util.List;

public class SpeakersFragment extends android.support.v4.app.Fragment {

    private RecyclerView speakersRecycleView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager gridLayoutManager;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_speakers, container, false);

        // setUpRecyclerView
        speakersRecycleView = (RecyclerView) rootView.findViewById(R.id.recyclerView);
        gridLayoutManager = new GridLayoutManager(getContext(), 2);
        speakersRecycleView.setLayoutManager(gridLayoutManager);

        // set Adapters
        mAdapter = new SpeakerListAdapter(getSpeakerData());
        speakersRecycleView.setAdapter(mAdapter);
        return rootView;
    }

    private List<Speaker> getSpeakerData() {
        List<Speaker> speakerData = new ArrayList<Speaker>();
        return speakerData;
    }
}
