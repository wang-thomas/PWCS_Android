package com.whartonsummit.android.pwcs_android.Activities;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
import com.squareup.picasso.Picasso;
import com.whartonsummit.android.pwcs_android.Models.Location;
import com.whartonsummit.android.pwcs_android.Models.Panel;
import com.whartonsummit.android.pwcs_android.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PanelDetailsActivity extends AppCompatActivity {

    private Panel panel;

    @BindView(R.id.webView1) WebView webView;
    //@BindView(R.id.mapView) MapView mapView;
    @BindView(R.id.title_info) TextView panelTitle;
    @BindView(R.id.time_info) TextView timeInfo;
    @BindView(R.id.location_info) TextView locationInfo;
    @BindView(R.id.background_image) ImageView imageView;
    @BindView(R.id.speakersList) TextView speakerlist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_panel_details);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        panel = (Panel) intent.getSerializableExtra("panel");

        setUpToolbar();
        setUpView();
        Picasso.get().load(panel.getImageUrl()).into(imageView);

        //Mapbox.getInstance(this, "pk.eyJ1IjoidG9teiIsImEiOiJjajJyN3dyenkwMDVqMndzN3Y0cjk0bTRmIn0.FEEGdubneAr17N9f8ZHh5g");
        //mapView.onCreate(savedInstanceState);
        //setUpMapView();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.right_button, menu);
        return true;
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
        String htmlText = "<html><body style=\"text-align:left; font-size: 14px\"> %s </body></Html>";
        String myData = panel.getDesc();
        String speakers = panel.getSpeakers();
        speakerlist.setText(speakers);
        webView.loadData(String.format(htmlText, myData), "text/html", "utf-8");
    }

//    private void setUpMapView() {
//        final Location location = panel.getLocation();
//        mapView.getMapAsync(new OnMapReadyCallback() {
//            @Override
//            public void onMapReady(MapboxMap mapboxMap) {
//                mapboxMap.setCameraPosition(new CameraPosition.Builder()
//                        .target(new LatLng(location.toLatLng()[0], location.toLatLng()[1]))
//                        .zoom(15)
//                        .build());
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
        Location location = panel.getLocation();
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
