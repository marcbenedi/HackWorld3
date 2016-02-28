package com.stirhack.hackworld;

import android.content.Context;
import android.view.View;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.concurrent.ExecutionException;

public class Utility {

    static Context context;

    public Utility(Context c)
    {
        context = c;
    }
    public static void updateMarker(View v, GoogleMap mMap, LatLng position)
    {

        String temp = new String("NULL");
        BackgroundPlaceAPI a = new BackgroundPlaceAPI(context);
        try {
            temp = a.execute(position).get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        int weatherId = -1;
        String weatherDescription = "ERROR";
        int size = 0;
        LatLng pos;
        double lat;
        double lng;
        String name;

        //Get the wheater id
        try {
            JSONObject apiObj = new JSONObject(temp);
            JSONArray listArr = apiObj.getJSONArray("results");
            JSONObject local;
            size = listArr.length();
            for (int i = 0; i < size; ++i){
                local = listArr.getJSONObject(i);
                name = local.getString("name");
                JSONObject location = local.getJSONObject("geometry");
                location = location.getJSONObject("location");
                lat = location.getDouble("lat");
                lng = location.getDouble("lng");
                pos = new LatLng(lat,lng);
                mMap.addMarker(new MarkerOptions().position(pos).title(name));
                System.out.print(name+lat+lng+"\n");
            }

        } catch (JSONException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
