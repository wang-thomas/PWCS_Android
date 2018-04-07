package com.whartonsummit.android_app.pwcs_android.Fragments;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;

import com.whartonsummit.android_app.pwcs_android.Adapters.FaqExpandableAdapter;
import com.whartonsummit.android_app.pwcs_android.R;
import com.whartonsummit.android_app.pwcs_android.R;
import com.whartonsummit.android_app.pwcs_android.Services.DataService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FaqFragment extends Fragment {

    ExpandableListAdapter expandableListAdapter;
    ExpandableListView expandableListView;
    List<String> questionsList;
    HashMap<String, String> answersToQuestions;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_faq, container, false);
        expandableListView = (ExpandableListView) view.findViewById(R.id.faq_table);
        prepareListData();
        expandableListAdapter = new FaqExpandableAdapter(getContext(), questionsList, answersToQuestions);
        expandableListView.setAdapter(expandableListAdapter);
        return view;
    }

    private void prepareListData() {
        questionsList = DataService.getInstance().getQuestionsList();
        answersToQuestions = DataService.getInstance().getAnswersToQuestions();
    }
}
