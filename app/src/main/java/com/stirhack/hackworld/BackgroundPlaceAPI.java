package com.stirhack.hackworld;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;

import com.google.android.gms.maps.model.LatLng;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class BackgroundPlaceAPI extends AsyncTask<LatLng, Void, String> {
    //Params,Progress,Result

    private Context context;
    String resultConnection;
    SharedPreferences prefs;
    Boolean food;
    Boolean hotel;
    String radius;

    public BackgroundPlaceAPI(Context c)
    {
        context = c;
    }

    @Override
    protected String doInBackground(LatLng... params) {
        prefs = context.getSharedPreferences("userSettings",Context.MODE_PRIVATE);
        food = prefs.getBoolean("food",false);
        hotel = prefs.getBoolean("hotel",false);
        radius = prefs.getString("radius","50");
        String types;
        if (food && hotel){
            types = "food,lodging";
        }
        else if (food){
            types = "food";
        }
        else{
            types = "lodging";
        }

        //ERROR NetworkOnMainThreadException
        //Possible solució: Crear un nou thread
        double lati = params[0].latitude;
        double longi = params[0].longitude;
        final String url = "https://maps.googleapis.com/maps/api/place/nearbysearch/json?" +
                "location="+lati+","+longi +
                "&radius="+radius+"&" +
                "types="+types+"&" +
                "key=AIzaSyA3rWKCiEOEAmCF24tQVmoCqqj5ua5wzeE";
        HttpURLConnection urlConnection = null;
        BufferedReader reader = null;
        System.out.print("DEBUG: "+url+"\n");

        try{
            URL url3 = new URL(url);

            // Create the request to OpenWeatherMap, and open the connection
            urlConnection = (HttpURLConnection) url3.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.connect();

            // Read the input stream into a String
            InputStream inputStream = urlConnection.getInputStream();
            StringBuffer buffer = new StringBuffer();
            if (inputStream == null) {
                // Nothing to do.
                return null;
            }
            reader = new BufferedReader(new InputStreamReader(inputStream));

            String line;
            while ((line = reader.readLine()) != null) {
                // Since it's JSON, adding a newline isn't necessary (it won't affect parsing)
                // But it does make debugging a *lot* easier if you print out the completed
                // buffer for debugging.
                buffer.append(line + "\n");
            }
            //Guardem el resultat
            resultConnection = buffer.toString();
        }
        catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (urlConnection != null) {
                urlConnection.disconnect();
            }
            if (reader != null) {
                try {
                    reader.close();
                } catch (final IOException e) {
                }
            }
        }
        //System.out.print("DEBUG INFORMATION "+resultConnection+"\n");
        return resultConnection;
        //String with all the JSON response from the API
    }

}