package com.whartonsummit.android.pwcs_android.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import com.whartonsummit.android.pwcs_android.R;

/**
 * Created by zhileizheng on 4/3/18.
 */

public class AboutFragment extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_about, container, false);
        WebView desc = view.findViewById(R.id.webView);
        String htmlText = "<html><body style=\"text-align:justify; font-size: 14px\"> %s </body></Html>";
        String myData = "Penn Wharton China Summit is hosted by the China Summit Foundation and the Penn Wharton China Center, and further supported by the Chinese embassy and the government of Pennsylvania. The summit is committed to building an influential platform that promotes communications between the two countries and establish connections among students oversea in the United States. <br/><br/>With over 1500 attendees coming from 4 countries, 34 States and over 70 Cities, the inaugural PWCS in April 2016 has already become the largest student organized summit in the United States. ";
        desc.loadData(String.format(htmlText, myData), "text/html", "utf-8");
        return view;
    }

}
