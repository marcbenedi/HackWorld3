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
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public class ListActivity extends Activity {

    private ArrayList<Hackathon> myList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_list);

        ImageView myImage = (ImageView) findViewById(R.id.myImage);
        myImage.setAlpha(127);

        BackgroundJSOUP a = new BackgroundJSOUP(this);
        try {
            myList = a.execute().get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

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

    private void registrarEventos() {

        /// selecciona la lista en pantalla segun su ID
        ListView lista1 = (ListView) findViewById(R.id.miLista);
        ListAdapter adapter = new MyAdapter(this, R.layout.item_list, myList);
        lista1.setAdapter(adapter);

        // registra una accion para el evento click
        lista1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                /// Obtiene el valor de la casilla elegida
                final Hackathon itemSeleccionado = (Hackathon) adapterView.getItemAtPosition(i);

                AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
                builder.setMessage("City: " + itemSeleccionado.getWhere() + "\n" + "Date: "
                        + itemSeleccionado.getWhen() + "\n")
                        .setTitle("HACKATHON DETAILS")
                        .setPositiveButton("Go to website", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Intent intent = new Intent(Intent.ACTION_VIEW);
                                intent.setData(Uri.parse(itemSeleccionado.getLink()));
                                startActivity(intent);
                            }
                        })
                        .show();

            }
        });

    }

}
