package com.example.a11_3relocationmovingtruckrentalapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.media.Image;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.DecimalFormat;

public class rental extends AppCompatActivity {
    double truckPrice;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rental);

        final TextView output = (TextView) findViewById(R.id.outputDisplay);
        final ImageView pic = (ImageView) findViewById(R.id.imgTruck);
        final SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this);
        int truckSize = sharedPref.getInt("key1", 0);
        int miles = sharedPref.getInt("key2", 0);

        if (truckSize == 10) {
            pic.setImageResource(R.drawable.ten);
            truckPrice = 19.95;
        } else if (truckSize == 17) {
            pic.setImageResource(R.drawable.seventeen);
            truckPrice = 29.95;
        } else if (truckSize == 26) {
            pic.setImageResource(R.drawable.twentysix);
            truckPrice = 39.95;
        }
        //display truck pic of appropriate size
        //display full cost renting for 1 day with cost of mileage
        //rental price = truck + (miles * .99)
        double price = truckPrice + (miles * 0.99);

        DecimalFormat money = new DecimalFormat("$###,###.00");
        output.setText("One-day rental total cost is:\n"+money.format(price));
    }
}
