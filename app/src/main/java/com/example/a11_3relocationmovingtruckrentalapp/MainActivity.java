package com.example.a11_3relocationmovingtruckrentalapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int size;
    int mileage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final RadioButton ten = (RadioButton) findViewById(R.id.tenFoot);
        final RadioButton seventeen = (RadioButton) findViewById(R.id.seventeenFoot);
        final RadioButton twentySix = (RadioButton) findViewById(R.id.twentySixFoot);
        final EditText miles = (EditText) findViewById(R.id.txtMiles);
        final Button rent = (Button) findViewById(R.id.btnRent);
        final SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this);

        rent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ten.isChecked()) {
                    size = 10;
                } else if (seventeen.isChecked()) {
                    size = 17;
                } else if (twentySix.isChecked()) {
                    size = 26;
                }
                mileage = Integer.parseInt(miles.getText().toString());

                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putInt("key1", size);
                editor.putInt("key2", mileage);
                editor.commit();
                startActivity(new Intent(MainActivity.this, rental.class));
            }
        });
    }
}
