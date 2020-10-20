package com.example.p675;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MainActivity extends AppCompatActivity {
    SupportMapFragment supportMapFragment;
    GoogleMap gmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        supportMapFragment =
                (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        supportMapFragment.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap googleMap) {
                gmap = googleMap;
                LatLng latlng = new LatLng(37.484194, 130.905423);
                gmap.animateCamera(CameraUpdateFactory.newLatLngZoom(latlng,14));

            }
        });
    }

    public void ck1(View v){
        LatLng latLng = new LatLng(36.082236, 129.553908);
        gmap.addMarker(new MarkerOptions().position(latLng).
                title("포항").snippet("XXX").
                icon(BitmapDescriptorFactory.fromResource(R.drawable.marker)));
        gmap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng, 15));
    }

    public void ck2(View v){
        
    }
}