package com.stirhack.hackworld;


import android.content.Context;
import android.os.AsyncTask;

import com.google.android.gms.maps.model.LatLng;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

public class BackgroundJSOUP extends AsyncTask<LatLng, Void, String> {
    //Params,Progress,Result

    private Context context;
    String resultConnection;

    public BackgroundJSOUP(Context c)
    {
        context = c;
    }

    @Override
    protected String doInBackground(LatLng... params) {

        final String url = "https://mlh.io/seasons/s2016-eu/events";

        try {
            Document doc = Jsoup.connect(url).get();
            resultConnection = doc.toString();
            System.out.print(resultConnection);
            System.out.print("\n\n\n\n");
            System.out.print(doc.title()+"\n");



        } catch (IOException e) {
            e.printStackTrace();
        }
        //System.out.print("DEBUG INFORMATION "+resultConnection+"\n");
        return resultConnection;
        //String with all the JSON response from the API
    }

}