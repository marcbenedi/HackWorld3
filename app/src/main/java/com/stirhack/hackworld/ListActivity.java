package com.stirhack.hackworld;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

public class ListActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_list);

        ImageView myImage = (ImageView) findViewById(R.id.myImage);
        myImage.setAlpha(127);

        //PROBA---------------------------------------------
        BackgroundJSOUP a = new BackgroundJSOUP(this);
        a.execute();

        registrarEventos();
    }

    /*@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return super.onOptionsItemSelected(item);
    }*/

    private void registrarEventos(){

        /// selecciona la lista en pantalla segun su ID
        ListView lista1 = (ListView) findViewById(R.id.miLista);

        // registra una accion para el evento click
        lista1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                /// Obtiene el valor de la casilla elegida
                String itemSeleccionado = adapterView.getItemAtPosition(i).toString();

                show_details(i);

            }
        });

    }

    public void show_details(int position) {
        String[] cities = {"Ames", "Ann Arbor", "Pittsburgh", "Barcelona", "Boulder", "Monterrey",
                "Wellesley", "St. Andrews", "Glasgow","Coventry","Miami","London","Blacksburg","East Lansing","Amherst"};

        String[] dates = {"19/02/2016", "19/02/2016", "19/02/2016", "19/02/2016", "20/02/2016", "20/02/2016", "20/02/2016",
                "20/02/2016", "20/02/2016","20/02/2016","20/02/2016","20/02/2016","26/02/2016","26/02/2016","26/02/2016"};

        String[] urels = {"http://hackisu.com/", "http://mhacks.org/", "http://steelhacks.com/",
                "https://hackupc.com/", "http://t9hacks.org/", "http://hackmty.com/",
                "http://wellesleyhacks.org/", "http://stacshack.org/", "http://www.hack.warwick.tech",
                "http://www.hack.warwick.tech/","http://coe.miami.edu/uhack2016/","http://www.ichack.org/",
                "http://vthacks.com/","https://www.spartahack.com/","http://hamphack.hampshire.edu/"};

        String city = cities[position];
        String date = dates[position];
        final String url = urels[position];

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("City: " + city + "\n" + "Date: " + date + "\n")
                .setTitle("HACKATON DETAILS")
                .setPositiveButton("Go to website", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(Intent.ACTION_VIEW);
                        intent.setData(Uri.parse(url));
                        startActivity(intent);
                    }
                })
                .show();
    }

}
