package com.example.ashleyturnbulldhevanlau_comp304sec003_lab5;

import androidx.fragment.app.FragmentActivity;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.example.ashleyturnbulldhevanlau_comp304sec003_lab5.databinding.ActivityMapsBinding;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private ActivityMapsBinding binding;
    Double longitude, latitude;
    String restaurauntName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMapsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        Intent intent = getIntent();
        restaurauntName = intent.getStringExtra("name");
        longitude = Double.parseDouble(intent.getStringExtra("long"));
        latitude = Double.parseDouble(intent.getStringExtra("lat"));
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        float zoomLevel = 16.0f;
        mMap = googleMap;
        LatLng restaurant = new LatLng(latitude, longitude);
        mMap.addMarker(new MarkerOptions().position(restaurant).title("Marker for " + restaurauntName));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(restaurant, zoomLevel));
    }
}