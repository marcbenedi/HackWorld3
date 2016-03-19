package com.stirhack.hackworld;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    Context cxt;
    boolean repe = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        cxt = getApplicationContext();

        FloatingActionButton fat = (FloatingActionButton)findViewById(R.id.fab);
        fat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(cxt, "abc", Toast.LENGTH_LONG).show();
                Intent i = new Intent(cxt,Settings_Activity.class);
                startActivity(i);



            }
        });
    }

    LatLng HackISU = new LatLng(42.034722, -93.62);
    LatLng MHacks = new LatLng(42.281389, -83.748333);
    LatLng SteelHacks = new LatLng(40.439722, -79.976389);
    LatLng HackUPC = new LatLng(41.387819, 2.112314);
    LatLng T9Hacks = new LatLng(40.027435, -105.251945);
    LatLng HackMTY = new LatLng(25.666667, -100.3);
    LatLng WHACK = new LatLng(42.296389, -71.293056);
    LatLng StatsHack = new LatLng(56.3404, -2.7955);
    LatLng StrathHACK = new LatLng(55.858, -4.259);
	
	LatLng WarwickHACK = new LatLng(52.416667, -1.516667);
    LatLng UHACK = new LatLng(25.783333, -80.216667);
    LatLng ICHACK = new LatLng(51.507222, -0.1275);
    LatLng VTHacks = new LatLng(37.23, -80.4178);
    LatLng SpartaHack = new LatLng(42.7348, -84.4808);
    LatLng HampHack = new LatLng(42.366667, -72.516667);


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

       addmarkers();
        mMap.moveCamera(CameraUpdateFactory.newLatLng(HackISU));

        mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {
                if (original(marker.getTitle()) && !repe){
                    mMap.clear();
                    addmarkers();
                    Utility a = new Utility(cxt);
                    a.updateMarker(new View(cxt),mMap,marker.getPosition());
                    repe = true;

                }
                else {repe= false;}

                return false;
            }
        });


    }

    public boolean original(String s){
        if(s.equals("HackISU"))return true;
        else if (s.equals("MHacks:Refactor"))return true;
        else if (s.equals("SteelHacks"))return true;
        else if (s.equals("HackUPC"))return true;
        else if (s.equals("T9Hacks"))return true;
        else if (s.equals("HackMTY"))return true;
        else if (s.equals("WHACK"))return true;
        else if (s.equals("StacsHack"))return true;
        else if (s.equals("StrathHACK"))return true;
        else if (s.equals("WarwickHACK"))return true;
        else if (s.equals("UHACK"))return true;
        else if (s.equals("ICHACK"))return true;
        else if (s.equals("VTHacks"))return true;
        else if (s.equals("SpartaHack"))return true;
        else if (s.equals("HampHack"))return true;

        return false;
    }

    public void addmarkers(){
        mMap.addMarker(new MarkerOptions().position(HackISU).title("HackISU")
                .icon(BitmapDescriptorFactory.fromResource(R.mipmap.hackisu)));

        //mMap.addMarker(new MarkerOptions().position(HackISU).title("HackISU"));
        mMap.addMarker(new MarkerOptions().position(MHacks).title("MHacks:Refactor")
                .icon(BitmapDescriptorFactory.fromResource(R.mipmap.mhacksrefactor)));
        mMap.addMarker(new MarkerOptions().position(SteelHacks).title("SteelHacks")
                .icon(BitmapDescriptorFactory.fromResource(R.mipmap.steelhacks)));
        mMap.addMarker(new MarkerOptions().position(HackUPC).title("HackUPC")
                .icon(BitmapDescriptorFactory.fromResource(R.mipmap.hackupc)));
        mMap.addMarker(new MarkerOptions().position(T9Hacks).title("T9Hacks")
                .icon(BitmapDescriptorFactory.fromResource(R.mipmap.t9hacks)));
        mMap.addMarker(new MarkerOptions().position(HackMTY).title("HackMTY")
                .icon(BitmapDescriptorFactory.fromResource(R.mipmap.hackmty)));
        mMap.addMarker(new MarkerOptions().position(WHACK).title("WHACK")
                .icon(BitmapDescriptorFactory.fromResource(R.mipmap.whack)));
        mMap.addMarker(new MarkerOptions().position(StatsHack).title("StacsHack")
                .icon(BitmapDescriptorFactory.fromResource(R.mipmap.stacshack)));
        mMap.addMarker(new MarkerOptions().position(StrathHACK).title("StrathHACK")
                .icon(BitmapDescriptorFactory.fromResource(R.mipmap.strathhack)));

        mMap.addMarker(new MarkerOptions().position(WarwickHACK).title("WarwickHACK")
                .icon(BitmapDescriptorFactory.fromResource(R.mipmap.rsz_warwickhacks)));
        mMap.addMarker(new MarkerOptions().position(UHACK).title("UHACK")
                .icon(BitmapDescriptorFactory.fromResource(R.mipmap.rsz_uhack)));
        mMap.addMarker(new MarkerOptions().position(ICHACK).title("ICHACK")
                .icon(BitmapDescriptorFactory.fromResource(R.mipmap.rsz_ichack)));
        mMap.addMarker(new MarkerOptions().position(VTHacks).title("VTHacks")
                .icon(BitmapDescriptorFactory.fromResource(R.mipmap.rsz_vchacks)));
        mMap.addMarker(new MarkerOptions().position(SpartaHack).title("SpartaHack")
                .icon(BitmapDescriptorFactory.fromResource(R.mipmap.rsz_spartahack)));
        mMap.addMarker(new MarkerOptions().position(HampHack).title("HampHack")
                .icon(BitmapDescriptorFactory.fromResource(R.mipmap.rsz_hamphack)));
    }
}
