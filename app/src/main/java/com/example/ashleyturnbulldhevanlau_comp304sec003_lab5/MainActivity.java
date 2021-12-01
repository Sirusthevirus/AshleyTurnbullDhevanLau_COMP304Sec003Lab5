package com.example.ashleyturnbulldhevanlau_comp304sec003_lab5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageClickListener;
import com.synnapps.carouselview.ImageListener;

public class MainActivity extends AppCompatActivity {

    private int[] images = new int[] {
            R.drawable.alcohol, R.drawable.asian, R.drawable.burger, R.drawable.icecream, R.drawable.mexican1, R.drawable.pizza, R.drawable.streetfood1
    };

    private String[] imageTitle = new String[] {
            "Alcohol, Asian, Burger, Ice-Cream, Mexican, Pizza, Street-Food"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


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

                Toast.makeText(MainActivity.this, imageTitle[position], Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void search(View view) {
        Intent intent = new Intent(this, MapsActivity.class);
        startActivity(intent);
    }

    public void searchNearby(View view) {
        Intent intent = new Intent(this, MapsActivity.class);
        startActivity(intent);
    }
}