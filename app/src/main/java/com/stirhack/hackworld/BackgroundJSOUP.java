package com.stirhack.hackworld;


import android.content.Context;
import android.os.AsyncTask;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;

public class BackgroundJSOUP extends AsyncTask<Void, Void, String> {
    //Params,Progress,Result

    private Context context;
    String resultConnection;

    public BackgroundJSOUP(Context c)
    {
        context = c;
    }

    @Override
    protected String doInBackground(Void... params) {

        final String url = "https://mlh.io/seasons/s2016-eu/events";

        try {
            Document doc = Jsoup.connect(url).get();
            Elements event = doc.select("div.event-wrapper");
            /*for (org.jsoup.nodes.Element row : event.select("h3")) {
                System.out.print(row.text());
                System.out.print("\n");
            }*/
            for (org.jsoup.nodes.Element row : event) {
                String a = row.toString();
                System.out.print(a+"\n");
                System.out.print(row.text());
                System.out.print("\n");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        //System.out.print("DEBUG INFORMATION "+resultConnection+"\n");
        return resultConnection;
        //String with all the JSON response from the API
    }

}