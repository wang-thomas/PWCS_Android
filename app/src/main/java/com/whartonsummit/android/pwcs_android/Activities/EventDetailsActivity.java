package com.whartonsummit.android.pwcs_android.Activities;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

//import com.mapbox.mapboxsdk.Mapbox;
//import com.mapbox.mapboxsdk.annotations.Icon;
//import com.mapbox.mapboxsdk.annotations.IconFactory;
//import com.mapbox.mapboxsdk.annotations.MarkerOptions;
//import com.mapbox.mapboxsdk.camera.CameraPosition;
//import com.mapbox.mapboxsdk.geometry.LatLng;
//import com.mapbox.mapboxsdk.maps.MapView;
//import com.mapbox.mapboxsdk.maps.MapboxMap;
//import com.mapbox.mapboxsdk.maps.OnMapReadyCallback;
import com.whartonsummit.android.pwcs_android.Models.Event;
import com.whartonsummit.android.pwcs_android.Models.Location;
import com.whartonsummit.android.pwcs_android.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by zhileizheng on 4/3/18.
 */

public class EventDetailsActivity extends AppCompatActivity {

    private Event event;

    @BindView(R.id.webView1)
    WebView webView;
//    @BindView(R.id.mapView)
//    MapView mapView;
    @BindView(R.id.title_info)
    TextView panelTitle;
    @BindView(R.id.time_info) TextView timeInfo;
    @BindView(R.id.location_info) TextView locationInfo;
    @BindView(R.id.background_image) ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_panel_details);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        event = (Event) intent.getSerializableExtra("event");

        imageView.setImageResource(event.getImageResource());
        setUpToolbar();
        setUpView();

//        Mapbox.getInstance(this, "pk.eyJ1Ijoid3RwdGhvbWFzIiwiYSI6ImNqdHB2NWZwejA4cWM0NHBwaWg0anNldHQifQ.uyiI7rDP0P2f-5sao6nm2Q");
//        mapView.onCreate(savedInstanceState);
//        setUpMapView();
    }

    private void setUpToolbar() {
        setTitle(event.getName());
        Toolbar toolbar = findViewById(R.id.app_toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionbar = getSupportActionBar();
        actionbar.setDisplayHomeAsUpEnabled(true);
        actionbar.setHomeAsUpIndicator(R.drawable.ic_arrow_back_black);
    }

    private void setUpView() {
        timeInfo.setText(event.getTime());
        panelTitle.setText(event.getName());
        locationInfo.setText(event.getLocation().toString());
        String htmlText = "<html><body style=\"text-align:justify; font-size: 14px\"> %s </body></Html>";
        String myData = event.getDesc();
        webView.loadData(String.format(htmlText, myData), "text/html", "utf-8");
    }

//    private void setUpMapView() {
//        final Location location = event.getLocation();
//        mapView.getMapAsync(new OnMapReadyCallback() {
//            @Override
//            public void onMapReady(MapboxMap mapboxMap) {
//                mapboxMap.setCameraPosition(new CameraPosition.Builder()
//                    .target(new LatLng(location.toLatLng()[0], location.toLatLng()[1]))
//                    .zoom(15)
//                    .build());
//                mapboxMap.addMarker(new MarkerOptions()
//                        .position(new LatLng(location.toLatLng()[0], location.toLatLng()[1]))
//                        .title(location.toString())
//                        .snippet("UPenn")
//                );
////                mapboxMap.addOnMapClickListener(new MapboxMap.OnMapClickListener() {
////                    @Override
////                    public void onMapClick(@NonNull LatLng point) {
////                        goToGoogleMap();
////
////                    }
////                });
//            }
//        });
//    }

    private Bitmap resize(Drawable image) {
        Bitmap b = ((BitmapDrawable)image).getBitmap();
        Bitmap bitmapResized = Bitmap.createScaledBitmap(b, 100, 100, false);
        return bitmapResized;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.right_button, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.map_action) {
            goToGoogleMap();
            return true;
        }
        this.finish();
        return super.onOptionsItemSelected(item);
    }

    private void goToGoogleMap() {
        Location location = event.getLocation();
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/maps/search/?api=1&query=" + location.toSearchTerm()));
        startActivity(browserIntent);
    }

//    @Override
//    public void onStart() {
//        super.onStart();
//        mapView.onStart();
//    }
//
//    @Override
//    public void onResume() {
//        super.onResume();
//        mapView.onResume();
//    }
//
//    @Override
//    public void onPause() {
//        super.onPause();
//        mapView.onPause();
//    }
//
//    @Override
//    public void onStop() {
//        super.onStop();
//        mapView.onStop();
//    }
//
//    @Override
//    public void onLowMemory() {
//        super.onLowMemory();
//        mapView.onLowMemory();
//    }
//
//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
//        mapView.onDestroy();
//    }
//
//    @Override
//    protected void onSaveInstanceState(Bundle outState) {
//        super.onSaveInstanceState(outState);
//        mapView.onSaveInstanceState(outState);
//    }
}

