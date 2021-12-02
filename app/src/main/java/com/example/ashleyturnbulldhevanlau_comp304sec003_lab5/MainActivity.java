package com.example.ashleyturnbulldhevanlau_comp304sec003_lab5;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;
import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageClickListener;
import com.synnapps.carouselview.ImageListener;

public class MainActivity extends AppCompatActivity {

    private int[] images = new int[] {
            R.drawable.alcohol, R.drawable.asian, R.drawable.burger, R.drawable.icecream, R.drawable.mexican1, R.drawable.pizza, R.drawable.streetfood1
    };

    private String[] imageTitle = new String[] {
            "Alcohol", "Asian Food", "Burgers", "Ice-Cream", "Mexican Food", "Pizza", "Street Food"
    };

    private static final int PERMISSION_REQUEST_LOCATION = 0;
    private View mLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mLayout = findViewById(R.id.layout);

        CarouselView carouselView = findViewById(R.id.carouselview);
        carouselView.setPageCount(images.length);
        carouselView.setImageListener(new ImageListener() {
            @Override
            public void setImageForPosition(int position, ImageView imageView) {
                imageView.setImageResource(images[position]);
            }
        });
        carouselView.setImageClickListener(new ImageClickListener() {
            @Override
            public void onClick(int position) {
                String foodItem = imageTitle[position];
                searchNearby(foodItem);
            }
        });
    }

    public void search(View view) {
        Intent intent = new Intent(this, MapsActivity.class);
        startActivity(intent);
    }

    public void searchNearby(String foodItem) {
        Intent intent = new Intent(this, RestaurantListActivity.class);
//        LocationManager lm = (LocationManager)getSystemService(Context.LOCATION_SERVICE);
//        Location location = lm.getLastKnownLocation(LocationManager.GPS_PROVIDER);
//        Double longitude = location.getLongitude();
//        Double latitude = location.getLatitude();
        Double longitude = 43.6532;
        Double latitude = 79.3832;
        String longit = Double.toString(longitude);
        String lat = Double.toString(latitude);
        intent.putExtra("long", longit);
        intent.putExtra("lat", lat);
        intent.putExtra("food", foodItem);
        startActivity(intent);
    }
}
