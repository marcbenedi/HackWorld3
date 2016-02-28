package com.stirhack.hackworld;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Settings_Activity extends AppCompatActivity {

    SharedPreferences prefs;
    CheckBox cFood;
    CheckBox cHotel;
    EditText eRadius;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings_);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        prefs = getSharedPreferences("userSettings",MODE_PRIVATE);
        boolean food = prefs.getBoolean("food", false);
        boolean hotel = prefs.getBoolean("hotel", false);
        String radius = prefs.getString("radius", "50");

        cFood = (CheckBox)findViewById(R.id.checkBox);
        cHotel = (CheckBox)findViewById(R.id.checkBox2);
        eRadius = (EditText)findViewById(R.id.editText);

        cFood.setChecked(food);
        cHotel.setChecked(hotel);
        eRadius.setText(radius, TextView.BufferType.EDITABLE);

    }

    @Override
    protected void onStop()
    {
        super.onStop();
        saveSettings();
    }

    public void saveSettings()
    {
        SharedPreferences.Editor editor = prefs.edit();
        editor.putBoolean("food",cFood.isChecked());
        editor.putBoolean("hotel",cHotel.isChecked());
        editor.putString("radius",eRadius.getText().toString());

        //Commit
        editor.commit();
        Toast.makeText(this, "Settings saved", Toast.LENGTH_LONG).show();
    }

}
