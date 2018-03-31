package com.whartonsummit.android_app.pwcs_android.Fragments;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.whartonsummit.android_app.pwcs_android.Models.TimelineObj;
import com.whartonsummit.android_app.pwcs_android.R;
import com.whartonsummit.android_app.pwcs_android.Adapters.TimeLineAdapter;

import java.util.ArrayList;
import java.util.List;


public class TimelineFragment extends Fragment {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;
    private OnFragmentInteractionListener mListener;

    private RecyclerView mRecyclerView;
    private TimeLineAdapter mTimeLineAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_timeline, container, false);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mRecyclerView.setHasFixedSize(true);
        mTimeLineAdapter = new TimeLineAdapter();
        mRecyclerView.setAdapter(mTimeLineAdapter);
        return view;
    }


    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        public void onTimelineFragmentInteraction(Uri uri);
    }

    private List<TimelineObj> prepareData() {
        List<TimelineObj> list = new ArrayList<TimelineObj>();
        list.add(new TimelineObj("Finance Panel", "8AM - 9AM", "Annenburg Center", ""));
        return list;
    }
}
