package com.example.ashleyturnbulldhevanlau_comp304sec003_lab5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.ashleyturnbulldhevanlau_comp304sec003_lab5.databinding.ActivityMainBinding;
import com.example.ashleyturnbulldhevanlau_comp304sec003_lab5.databinding.ActivityRestaurantListBinding;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class RestaurantListActivity extends AppCompatActivity {



    private TextView textView_SelectedCuisine;
    private ListView listView_Restaurants;

    //Method 1 Variables
    private static final String API_KEY = "AIzaSyBpT-nwC_MW6Q6vAg8Ads6CwtqgQsoaUx8";

    private static final String PLACES_API_BASE = "https://maps.googleapis.com/maps/api/place";

    private static final String TYPE_AUTOCOMPLETE = "/autocomplete";
    private static final String TYPE_DETAILS = "/details";
    private static final String TYPE_SEARCH = "/nearbysearch";
    private static final String OUT_JSON = "/json?";
    private static final String LOG_TAG = "ListRest";

    //Method 2 Variables


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant_list);
        Intent intent = getIntent();

        Double longitude = Double.parseDouble(intent.getStringExtra("long"));
        Double latitude = Double.parseDouble(intent.getStringExtra("lat"));
        String foodType = intent.getStringExtra("food");
        int radius = 1000;

        listView_Restaurants = (ListView) findViewById(R.id.ListView_Restaurants);
        textView_SelectedCuisine = findViewById(R.id.TextView_SelectedCuisine);
        textView_SelectedCuisine.setText(foodType);

        //Hard coded lists for testing purposes
        String [] tempNames = {"Burger King", "McDonalds", "KFC"};
        String [] tempAddresses = {"Your mom's house", "Underground Basement", "K F C dees nuts"};

        ArrayList<Restaurant> restaurantArrayList = new ArrayList<>();

        for(int i = 0; i < tempNames.length; i++){
            Restaurant restaurant = new Restaurant(tempNames[i], tempAddresses[i]);
            restaurantArrayList.add(restaurant);
        }

        ListAdapter listAdapter = new ListAdapter(RestaurantListActivity.this, restaurantArrayList);

        listView_Restaurants.setAdapter(listAdapter);
//        listView_Restaurants.setClickable(true);
//        listView_Restaurants.setOnItemClickListener(new AdapterView.OnItemClickListener(){
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id){
//
//                //When clicking restaurant find on map
////                Intent intent = new Intent(RestaurantListActivity.this, MapsActivity.class);
////                intent.putExtra("lat", restaurantArrayList.get(position).getLatitude());
////                intent.putExtra("long", restaurantArrayList.get(position).getLongitude());
////                intent.putExtra("name", restaurantArrayList.get(position).getName());
//            }
//        });

//        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
//        StrictMode.setThreadPolicy(policy);
//
//        ArrayList<Restaurant> list = search(latitude, longitude, radius, foodType);
//        Log.e(LOG_TAG, list.toString() );
//        if(list != null){
//            ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_expandable_list_item_1, list);
//            listView_Restaurants.setAdapter(adapter);
//        }
    }

//    public static ArrayList<Restaurant> search(double lat, double lng, int radius, String foodType){
//        ArrayList<Restaurant> resultList = null;
//
//        HttpURLConnection conn = null;
//        StringBuilder jsonResults = new StringBuilder();
//        try {
//            StringBuilder sb = new StringBuilder(PLACES_API_BASE);
//            sb.append(TYPE_SEARCH);
//            sb.append(OUT_JSON);
//            sb.append("location=" + String.valueOf(lat) + "," + String.valueOf(lng));
//            sb.append("&radius=" + String.valueOf(radius));
//            sb.append("&type="+ foodType);
//            sb.append("&key=" + API_KEY);
//
//            URL url = new URL(sb.toString());
//            conn = (HttpURLConnection) url.openConnection();
//            InputStreamReader in = new InputStreamReader(conn.getInputStream());
//
//            int read;
//            char[] buff = new char[1024];
//            while ((read = in.read(buff)) != -1) {
//                jsonResults.append(buff, 0, read);
//            }
//        } catch (MalformedURLException e) {
//            Log.e(LOG_TAG, "Error processing Places API URL", e);
//            return resultList;
//        } catch (IOException e) {
//            Log.e(LOG_TAG, "Error connecting to Places API", e);
//            return resultList;
//        } finally {
//            if (conn != null) {
//                conn.disconnect();
//            }
//        }
//        try {
//            // Create a JSON object hierarchy from the results
//            JSONObject jsonObj = new JSONObject(jsonResults.toString());
//            JSONArray predsJsonArray = jsonObj.getJSONArray("results");
//
//            // Extract the descriptions from the results
//            resultList = new ArrayList<Restaurant>(predsJsonArray.length());
//            for (int i = 0; i < predsJsonArray.length(); i++) {
//                Restaurant restaurant = new Restaurant();
//                restaurant.reference = predsJsonArray.getJSONObject(i).getString("reference");
//                restaurant.name = predsJsonArray.getJSONObject(i).getString("name");
//                resultList.add(restaurant);
//            }
//        } catch (JSONException e) {
//            Log.e(LOG_TAG, "Error processing JSON results", e);
//        }
//        return resultList;
//    }
//
//    public static class Restaurant {
//        private String reference;
//        private String name;
//
//        public Restaurant(){
//            super();
//        }
//
//        public String getName() {
//            return name;
//        }
//        @Override
//        public String toString(){
//            return this.name;
//        }
//    }
}