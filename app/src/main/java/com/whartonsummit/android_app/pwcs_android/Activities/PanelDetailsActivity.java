package com.whartonsummit.android_app.pwcs_android.Activities;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.webkit.WebView;

import com.whartonsummit.android_app.pwcs_android.R;

public class PanelDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_panel_details);
        setTitle("Finance Panel");

        Toolbar toolbar = findViewById(R.id.app_toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionbar = getSupportActionBar();
        actionbar.setDisplayHomeAsUpEnabled(true);
        actionbar.setHomeAsUpIndicator(R.drawable.ic_arrow_back_black);

        String htmlText = "<html><body style=\"text-align:justify\"> %s </body></Html>";
        String myData = "The 2018 Penn Wharton China Summit will be held on April 13th-15th, " +
                "2018 at the University of Pennsylvania. Hosted by the China Summit Foundation and the Penn Wharton China Center, " +
                "and further supported by the Chinese embassy and the government of Pennsylvania, PWCS is committed to build an " +
                "influential platform that promotes communications between the two countries and establish connections among " +
                "students oversea in the United States. With over 1500 attendees coming from 4 countries, 34 States and over 70 Cities, " +
                "the inaugural PWCS in April 2016 has already become the largest student organized summit in the United States. " +
                "2018 is an important year for the development of US-China relationship. We hope to strengthen the communication and " +
                "facilitate cooperation between top students, professionals and corporations from both countries, and contribute " +
                "to the long-lasting friendship between the United States and China.";

        WebView webView = (WebView) findViewById(R.id.webView1);
        webView.loadData(String.format(htmlText, myData), "text/html", "utf-8");
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        this.finish();
        return super.onOptionsItemSelected(item);
    }
}
