package com.whartonsummit.android.pwcs_android.Fragments.Timelines;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.whartonsummit.android.pwcs_android.Adapters.TimeLineAdapter;
import com.whartonsummit.android.pwcs_android.Models.TimelineObj;
import com.whartonsummit.android.pwcs_android.R;
import com.whartonsummit.android.pwcs_android.Services.DataService;

import java.util.List;

/**
 * Created by zhileizheng on 3/31/18.
 */

public class Day1Fragment extends TimelineFragment {

    private RecyclerView mRecyclerView;
    private TimeLineAdapter mTimeLineAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_timeline, container, false);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mRecyclerView.setHasFixedSize(true);
        mTimeLineAdapter = new TimeLineAdapter(prepareData());
        mRecyclerView.setAdapter(mTimeLineAdapter);
        return view;
    }

    private List<TimelineObj> prepareData() {
        return DataService.getInstance().getScheduleForDay(1);
    }
}
