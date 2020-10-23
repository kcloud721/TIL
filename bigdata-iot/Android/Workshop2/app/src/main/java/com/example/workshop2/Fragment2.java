package com.example.workshop2;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class Fragment2 extends Fragment {
    LocationManager locationManager;
    SupportMapFragment supportMapFragment;
    MapView gmap;
    GoogleMap gm;

    public Fragment2() {

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_2, container, false);
        gmap = (MapView) v.findViewById(R.id.map);
        gmap.onCreate(savedInstanceState);
        gmap.onResume();

        MapsInitializer.initialize(getActivity().getApplicationContext());

        gmap.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap googleMap) {
                LatLng latlng = new LatLng(37.543571, 126.905226);
                if (ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                    return;
                }

                // 권한 획득 후 매니저 실행
                MyLocation myLocation = new MyLocation();
                locationManager = (LocationManager) getActivity().getSystemService(Context.LOCATION_SERVICE);
                locationManager.requestLocationUpdates(
                        LocationManager.GPS_PROVIDER,
                        1,
                        0,
                        myLocation
                );

                // 내 위치 파랑색 표시
                googleMap.setMyLocationEnabled(true);
                // 마커 표시
                googleMap.addMarker(
                        new MarkerOptions().position(latlng).
                                title("공항").snippet("xxx")
                );
                googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latlng,10));
            }
        });

        return v;
    }

    class MyLocation implements LocationListener {
        @Override
        public void onLocationChanged(@NonNull Location location) {
            double lat = location.getLatitude();
            double lon = location.getLongitude();
        }
    }
}