package com.ideyatech.moove.merchant;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationServices;
import com.ideyatech.moove.R;
import com.ideyatech.moove.login.Moove;
import com.ideyatech.moove.main.MainActivity;
import com.ideyatech.moove.reward.RewardsActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

/**
 * Created by kendeng on 4/30/2016.
 */
public class MapView extends AppCompatActivity implements OnMapReadyCallback,
        GoogleApiClient.ConnectionCallbacks,
        GoogleApiClient.OnConnectionFailedListener {

    public void onConnectionSuspended(int var1){

    }

    public void onConnectionFailed(@NonNull ConnectionResult var1){

    }

    private GoogleMap mMap;
    private GoogleApiClient mGoogleApiClient;
    private Location mLastLocation;
    private double lat;
    private double lng;

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.map);

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        //*****************************************************************************************
        //*                                     TOOLBAR
        //*****************************************************************************************
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_awesome_toolbar);
        setSupportActionBar(myToolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Back");

        Button reward = (Button) findViewById(R.id.reward);
        Button dash = (Button) findViewById(R.id.dash);
//        Button account = (Button) findViewById()
        Button now = (Button) findViewById(R.id.merchant);

        now.setBackgroundResource(R.drawable.button_merchantactive);

        reward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), RewardsActivity.class);
                startActivity(i);
            }
        });

        dash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i);
            }
        });

        //*****************************************************************************************
        //*                                     BACK TO TITLE
        //*****************************************************************************************
        ImageView home = (ImageView) findViewById(R.id.icon);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Moove.class);
                startActivity(i);
            }
        });

        if (mGoogleApiClient == null) {
            mGoogleApiClient = new GoogleApiClient.Builder(this)
                    .addConnectionCallbacks(this)
                    .addOnConnectionFailedListener(this)
                    .addApi(LocationServices.API)
                    .build();
        }

    }

    public boolean onOptionsItemSelected(MenuItem item) {
        // TODO Auto-generated method stub
        switch(item.getItemId()){
            case android.R.id.home: finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }


    //*****************************************************************************************
    //*                          CONNECTIONS, MAPS, & LOCATION(GPS)
    //*****************************************************************************************

    @Override
    protected void onStart() {
        super.onStart();
        mGoogleApiClient.connect();
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (mGoogleApiClient.isConnected()) {
            mGoogleApiClient.disconnect();
        }
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        String[] place = {"Toby's Sports Megamall", "Toby's Sports EDSA Shangri-La", "Toby's Sports Robinson's Galleria",
                            "Toby's Sports Greenbelt 3"};
        double[] lat = {14.585124, 14.581848, 14.591471, 14.552077};
        double[] lng = {121.057355, 121.055508, 121.059686, 121.025945};

//        LatLng mega = new LatLng(14.585124, 121.057355);
//        LatLng shang = new LatLng(14.581848, 121.055508);
//        LatLng galle = new LatLng(14.591471, 121.059686);
//        LatLng gb3 = new LatLng(14.552077, 121.025945);

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                == PackageManager.PERMISSION_GRANTED) {
            mMap.setMyLocationEnabled(true);
        } else {
            // Show rationale and request permission.
        }

        for (int i = 0 ; i < 4 ; i++){
            mMap.addMarker((new MarkerOptions().position(new LatLng(lat[i], lng[i])).title(place[i])));
        }

//        mMap.addMarker(new MarkerOptions().position(mega).title("Toby's Sports Megamall"));
//        mMap.addMarker(new MarkerOptions().position(shang).title("Toby's Sports EDSA Shangri-La"));
//        mMap.addMarker(new MarkerOptions().position(galle).title("Toby's Sports Robinson's Galleria"));
//        mMap.addMarker(new MarkerOptions().position(gb3).title("Toby's Sports Greenbelt 3"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(getlat(), getlng()), 15));
    }

    @Override
    public void onConnected(Bundle connectionHint) {
        if (checkPermission(Manifest.permission.ACCESS_FINE_LOCATION,1,1) != PackageManager.PERMISSION_GRANTED
                && checkPermission(Manifest.permission.ACCESS_COARSE_LOCATION,1,1) != PackageManager.PERMISSION_GRANTED) {
            mLastLocation = LocationServices.FusedLocationApi.getLastLocation(mGoogleApiClient);
            if (mLastLocation != null) {
                setlat(mLastLocation.getLatitude());
                setlng(mLastLocation.getLongitude());
                onMapReady(mMap);
            }
        }
    }

    public void setlat(double lat){
        this.lat = lat;
    }

    public double getlat(){
        return lat;
    }

    public void setlng(double lng){ this.lng = lng;    }

    public double getlng(){
        return lng;
    }
}