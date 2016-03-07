package com.stirhack.hackworld;


import android.content.Context;
import android.os.AsyncTask;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

public class BackgroundJSOUP extends AsyncTask<Void, Void, ArrayList<Hackathon>> {
    //Params,Progress,Result

    private Context context;

    public BackgroundJSOUP(Context c)
    {
        context = c;
    }

    @Override
    protected ArrayList<Hackathon> doInBackground(Void... params) {

        ArrayList<Hackathon> myList = new ArrayList<>();
        Hackathon hackathon;

        final String url = "https://mlh.io/seasons/s2016-eu/events";

        try {
            Document doc = Jsoup.connect(url).get();
            Elements event = doc.select("div.event-wrapper");

            for (org.jsoup.nodes.Element row : event) {
                Element link0 = row.select("a").first();
                String link = link0.attr("abs:href");
                String name = row.select("h3").text();
                String when = row.select("p").get(0).text();
                String where = row.select("p").get(1).text();
                hackathon = new Hackathon(name,when,where,link);
                myList.add(hackathon);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        //System.out.print("DEBUG INFORMATION "+resultConnection+"\n");
        return myList;
        //String with all the JSON response from the API
    }

}