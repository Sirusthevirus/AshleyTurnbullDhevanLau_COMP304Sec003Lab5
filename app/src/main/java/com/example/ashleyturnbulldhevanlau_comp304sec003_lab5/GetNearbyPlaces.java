package com.example.ashleyturnbulldhevanlau_comp304sec003_lab5;

import android.os.AsyncTask;
import android.util.Log;

import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;

import com.google.android.gms.maps.GoogleMap;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GetNearbyPlaces {

    private String googlePlaceData, url;
    private ArrayList<Restaurant> restaurantList = new ArrayList<>();

    protected void doInBackground(Object... objects){
        url = (String) objects[0];

        DownloadUrl downloadUrl = new DownloadUrl();
        try {
            googlePlaceData = downloadUrl.ReadTheUrl(url);
        } catch (IOException e) {
            e.printStackTrace();
        }
        List<HashMap<String,String>> nearbyPlacesList = null;
        DataParser dataParser = new DataParser();
        nearbyPlacesList = dataParser.parse(googlePlaceData);
        Log.e("OnPostExecute", "Populating Restaurants");
        PopulateRestaurantsList(nearbyPlacesList);
    }

    protected void onPostExecute(String s) {
        List<HashMap<String,String>> nearbyPlacesList = null;
        DataParser dataParser = new DataParser();
        nearbyPlacesList = dataParser.parse(s);
        Log.e("OnPostExecute", "Populating Restaurants");
        PopulateRestaurantsList(nearbyPlacesList);
    }

    public void PopulateRestaurantsList(List<HashMap<String,String>> nearbyPlacesList){

        Log.e("Num Nearby Places", ""+nearbyPlacesList.size());
        //ArrayList<Restaurant> restaurantList = new ArrayList<>();

        for(int i=0; i < nearbyPlacesList.size(); i++){

            HashMap<String, String> googleNearbyPlace = nearbyPlacesList.get(i);

            String name = googleNearbyPlace.get("place_name");
            String address = googleNearbyPlace.get("vicinity");
            Double lat = Double.parseDouble(googleNearbyPlace.get("lat"));
            Double lng = Double.parseDouble(googleNearbyPlace.get("lng"));

            Restaurant restaurant = new Restaurant(name, address, lat, lng);
            Log.e("Adding Restuarant: ", ""+restaurant.getName());
            restaurantList.add(restaurant);
        }
    }

    public ArrayList<Restaurant> GetNearbyRestaurants(){

        return restaurantList;
    }
}
