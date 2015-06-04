package com.example.angelo.museo.ui.fragments;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.example.angelo.museo.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;

public class MapF extends FragmentActivity implements OnMapReadyCallback {

    public boolean needsInit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_museo);


        MapFragment mapFrag=
                (MapFragment)getFragmentManager()
                        .findFragmentById(R.id.map);
        /**if (savedInstanceState==null){
            needsInit=true;
        }*/
            mapFrag.getMapAsync(this);
    }




    @Override
    public void onMapReady(GoogleMap map) {

            LatLng sydney = new LatLng(-33.867, 151.206);

            map.setMyLocationEnabled(true);
            map.moveCamera(CameraUpdateFactory.newLatLngZoom(sydney, 13));


    }
}




