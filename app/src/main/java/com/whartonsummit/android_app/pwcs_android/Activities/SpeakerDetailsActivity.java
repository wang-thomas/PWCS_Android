package com.whartonsummit.android_app.pwcs_android.Activities;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

import com.makeramen.roundedimageview.RoundedImageView;
import com.whartonsummit.android_app.pwcs_android.Models.Speaker;
import com.whartonsummit.android_app.pwcs_android.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SpeakerDetailsActivity extends AppCompatActivity {
    @BindView(R.id.speaker_image) ImageView speakerImage;
    @BindView(R.id.name_text) TextView speakerName;
    @BindView(R.id.title_text) TextView speakerTitle;
    @BindView(R.id.webView1) WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_speaker_details);

        Toolbar toolbar = findViewById(R.id.app_toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionbar = getSupportActionBar();
        actionbar.setDisplayHomeAsUpEnabled(true);
        actionbar.setHomeAsUpIndicator(R.drawable.ic_arrow_back_black);

        ButterKnife.bind(this);
        Intent intent = getIntent();
        Speaker speaker = (Speaker) intent.getSerializableExtra("speaker");
        this.setTitle(speaker.getName());
        setUpView(speaker);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        this.finish();
        return super.onOptionsItemSelected(item);
    }

    private void setUpView(Speaker speaker) {
        speakerImage.setImageResource(speaker.getImageResource());
        speakerName.setText(speaker.getName());
        speakerTitle.setText(speaker.getTitle());
        String htmlText = "<html><body style=\"text-align:justify; font-size: 14px\"> %s </body></Html>";
        String myData = speaker.getDesc();
        webView = (WebView) findViewById(R.id.webView1);
        webView.loadData(String.format(htmlText, myData), "text/html", "utf-8");
    }


}
