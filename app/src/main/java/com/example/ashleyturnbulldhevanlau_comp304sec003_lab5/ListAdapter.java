package com.example.ashleyturnbulldhevanlau_comp304sec003_lab5;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class ListAdapter extends ArrayAdapter<Restaurant> {

    public ListAdapter(Context context, ArrayList<Restaurant> restaurantArrayList){
        super(context, R.layout.list_item, restaurantArrayList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        Restaurant restaurant = getItem(position);

        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        TextView textView_Name = convertView.findViewById(R.id.TextView_RestName);
        TextView textView_Address = convertView.findViewById(R.id.TextView_RestAddress);

        textView_Name.setText(restaurant.getName());
        textView_Address.setText(restaurant.getAddress());

        return convertView;
    }
}
