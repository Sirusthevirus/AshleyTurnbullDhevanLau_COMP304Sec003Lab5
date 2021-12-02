package com.example.ashleyturnbulldhevanlau_comp304sec003_lab5;

import android.os.AsyncTask;

import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;

import com.google.android.gms.maps.GoogleMap;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GetNearbyPlaces extends AsyncTask<Object, String, String> {

    private String googlePlaceData, url;
    private ArrayList<Restaurant> restaurantList = new ArrayList<>();

    @NonNull
    @Override
    protected String doInBackground(Object... objects){
        url = (String) objects[0];

        DownloadUrl downloadUrl = new DownloadUrl();
        try {
            googlePlaceData = downloadUrl.ReadTheUrl(url);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return googlePlaceData;
    }

    @Override
    protected void onPostExecute(String s) {
        List<HashMap<String,String>> nearbyPlacesList = null;
        DataParser dataParser = new DataParser();
        nearbyPlacesList = dataParser.parse(s);
        PopulateRestaurantsList(nearbyPlacesList);
    }

    public void PopulateRestaurantsList(List<HashMap<String,String>> nearbyPlacesList){

        ArrayList<Restaurant> restaurantList = new ArrayList<>();

        for(int i=0; i < nearbyPlacesList.size(); i++){

            HashMap<String, String> googleNearbyPlace = nearbyPlacesList.get(i);

            String name = googleNearbyPlace.get("place_name");
            String address = googleNearbyPlace.get("vicinity");
            Double lat = Double.parseDouble(googleNearbyPlace.get("lat"));
            Double lng = Double.parseDouble(googleNearbyPlace.get("lng"));

            Restaurant restaurant = new Restaurant(name, address, lat, lng);
            restaurantList.add(restaurant);
        }
    }

    public ArrayList<Restaurant> GetNearbyRestaurants(){

        return restaurantList;
    }
}
