package com.whartonsummit.android_app.pwcs_android.Activities;

import android.content.Intent;
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
import android.widget.TextView;

import com.mapbox.mapboxsdk.Mapbox;
import com.mapbox.mapboxsdk.annotations.Icon;
import com.mapbox.mapboxsdk.annotations.IconFactory;
import com.mapbox.mapboxsdk.annotations.MarkerOptions;
import com.mapbox.mapboxsdk.geometry.LatLng;
import com.mapbox.mapboxsdk.maps.MapView;
import com.mapbox.mapboxsdk.maps.MapboxMap;
import com.mapbox.mapboxsdk.maps.OnMapReadyCallback;
import com.whartonsummit.android_app.pwcs_android.Models.Location;
import com.whartonsummit.android_app.pwcs_android.Models.Panel;
import com.whartonsummit.android_app.pwcs_android.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PanelDetailsActivity extends AppCompatActivity {

    private Panel panel;

    @BindView(R.id.webView1) WebView webView;
    @BindView(R.id.mapView) MapView mapView;
    @BindView(R.id.title_info) TextView panelTitle;
    @BindView(R.id.time_info) TextView timeInfo;
    @BindView(R.id.location_info) TextView locationInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_panel_details);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        panel = (Panel) intent.getSerializableExtra("panel");

        setUpToolbar();
        setUpView();

        Mapbox.getInstance(this, "pk.eyJ1IjoidG9teiIsImEiOiJjajJyN3dyenkwMDVqMndzN3Y0cjk0bTRmIn0.FEEGdubneAr17N9f8ZHh5g");
        mapView.onCreate(savedInstanceState);
        setUpMapView();
    }

    private void setUpToolbar() {
        setTitle(panel.getName());
        Toolbar toolbar = findViewById(R.id.app_toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionbar = getSupportActionBar();
        actionbar.setDisplayHomeAsUpEnabled(true);
        actionbar.setHomeAsUpIndicator(R.drawable.ic_arrow_back_black);
    }

    private void setUpView() {
        timeInfo.setText(panel.getTime());
        panelTitle.setText(panel.getName());
        locationInfo.setText(panel.getLocation().toString());
        String htmlText = "<html><body style=\"text-align:justify; font-size: 14px\"> %s </body></Html>";
        String myData = panel.getDesc();
        webView.loadData(String.format(htmlText, myData), "text/html", "utf-8");
    }

    private void setUpMapView() {
        final Location location = panel.getLocation();
        mapView.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(MapboxMap mapboxMap) {
                IconFactory iconFactory = IconFactory.getInstance(PanelDetailsActivity.this);
                Drawable image = ContextCompat.getDrawable(PanelDetailsActivity.this, R.drawable.map_marker_icon);
                Icon icon = iconFactory.fromBitmap(resize(image));
                mapboxMap.addMarker(new MarkerOptions()
                        .position(new LatLng(location.toLatLng()[0], location.toLatLng()[1]))
                        .title(location.toString())
                        .snippet("UPenn")
                        .icon(icon)
                );
            }
        });
    }

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
