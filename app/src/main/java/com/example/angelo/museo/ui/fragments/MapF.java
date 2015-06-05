package com.example.angelo.museo.ui.fragments;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.example.angelo.museo.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapF extends FragmentActivity implements OnMapReadyCallback {



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




        String Longi= getIntent().getStringExtra("longitud");
        String Lati= getIntent().getStringExtra("latitud");

       // Toast.makeText(getBaseContext(), Longi, Toast.LENGTH_SHORT).show();

    }


    @Override
    public void onMapReady(GoogleMap map) {
        map.moveCamera(CameraUpdateFactory
                .newLatLngZoom(new LatLng(0.0, 0.0), 17));
        map.addMarker(new MarkerOptions()
                .position(new LatLng(0.0, 0.0)));

    }
}




