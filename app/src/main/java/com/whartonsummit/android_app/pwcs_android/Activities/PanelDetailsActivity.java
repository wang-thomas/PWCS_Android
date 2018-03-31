package com.whartonsummit.android_app.pwcs_android.Activities;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.webkit.WebView;

import com.mapbox.mapboxsdk.Mapbox;
import com.mapbox.mapboxsdk.annotations.Icon;
import com.mapbox.mapboxsdk.annotations.IconFactory;
import com.mapbox.mapboxsdk.annotations.MarkerOptions;
import com.mapbox.mapboxsdk.geometry.LatLng;
import com.mapbox.mapboxsdk.maps.MapView;
import com.mapbox.mapboxsdk.maps.MapboxMap;
import com.mapbox.mapboxsdk.maps.OnMapReadyCallback;
import com.whartonsummit.android_app.pwcs_android.R;

public class PanelDetailsActivity extends AppCompatActivity {

    private MapView mapView;
    private CardView card;

    private WebView webView;

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

        String htmlText = "<html><body style=\"text-align:justify; font-size: 14px\"> %s </body></Html>";
        String myData = "The 2018 Penn Wharton China Summit will be held on April 13th-15th, " +
                "2018 at the University of Pennsylvania. Hosted by the China Summit Foundation and the Penn Wharton China Center, " +
                "and further supported by the Chinese embassy and the government of Pennsylvania, PWCS is committed to build an " +
                "influential platform that promotes communications between the two countries and establish connections among " +
                "students oversea in the United States. With over 1500 attendees coming from 4 countries, 34 States and over 70 Cities, " +
                "the inaugural PWCS in April 2016 has already become the largest student organized summit in the United States. " +
                "2018 is an important year for the development of US-China relationship. We hope to strengthen the communication and " +
                "facilitate cooperation between top students, professionals and corporations from both countries, and contribute " +
                "to the long-lasting friendship between the United States and China.";
        card = (CardView) findViewById(R.id.card_view);

        webView = (WebView) findViewById(R.id.webView1);
        webView.loadData(String.format(htmlText, myData), "text/html", "utf-8");
        Mapbox.getInstance(this, "pk.eyJ1IjoidG9teiIsImEiOiJjajJyN3dyenkwMDVqMndzN3Y0cjk0bTRmIn0.FEEGdubneAr17N9f8ZHh5g");


        mapView = (MapView) findViewById(R.id.mapView);
        mapView.onCreate(savedInstanceState);
        mapView.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(MapboxMap mapboxMap) {
                IconFactory iconFactory = IconFactory.getInstance(PanelDetailsActivity.this);
                Drawable image = ContextCompat.getDrawable(PanelDetailsActivity.this, R.drawable.map_marker_icon);
                Icon icon = iconFactory.fromBitmap(resize(image));
                mapboxMap.addMarker(new MarkerOptions()
                        .position(new LatLng(39.9528219,-75.196286))
                        .title("Annenburg Center")
                        .snippet("UPenn")
                        .icon(icon)
                );
            }
        });
    }

//    private void setHeightForCard(String str) {
//        android.view.ViewGroup.LayoutParams params = card.getLayoutParams();
//        params.height = 600;
//        card.setLayoutParams(params);
//    }

    private Bitmap resize(Drawable image) {
        Bitmap b = ((BitmapDrawable)image).getBitmap();
        Bitmap bitmapResized = Bitmap.createScaledBitmap(b, 100, 100, false);
        return bitmapResized;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        this.finish();
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onStart() {
        super.onStart();
        mapView.onStart();
    }

    @Override
    public void onResume() {
        super.onResume();
        mapView.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        mapView.onPause();
    }

    @Override
    public void onStop() {
        super.onStop();
        mapView.onStop();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mapView.onLowMemory();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mapView.onDestroy();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        mapView.onSaveInstanceState(outState);
    }
}
