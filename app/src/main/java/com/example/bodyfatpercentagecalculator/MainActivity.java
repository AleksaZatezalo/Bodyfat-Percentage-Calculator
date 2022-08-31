package com.aleksa.BodyFatCalc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText neck;
    EditText waist;
    EditText height;
    EditText hip;
    Switch isMale;
    Switch isFemale;
    Button calculate;
    EditText result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        // getting all items
        neck = findViewById(R.id.neckWidth);
        waist = findViewById(R.id.waistWidth);
        hip = findViewById(R.id.hipWidth);
        height = findViewById(R.id.height);
        isMale  = (Switch) findViewById(R.id.isMale);
        isFemale =  (Switch) findViewById(R.id.isFemale);
        calculate = findViewById(R.id.calculate);
        result = findViewById(R.id.result);

        //Setting Switches and Toggoling
        isMale.setChecked(false);
        isFemale.setChecked(true);

        isMale.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                if (isMale.isChecked()){
                   isFemale.setChecked(false);
                } else {
                    isFemale.setChecked(true);
                }//checking if  switch is checked
            }
        });

        isFemale.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                if (isFemale.isChecked()){
                    isMale.setChecked(false);
                } else {
                    isMale.setChecked(true);

                } //checking if  switch is checked
            }
        });

        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String sWaist = waist.getText().toString();
                String sHip = hip.getText().toString();
                String sHeight = height.getText().toString();
                String sNeck = neck.getText().toString();

                int nWaist;
                int nHip;
                int nHeight;
                int nNeck;


                if (isFemale.isChecked()){
                    if (sWaist.matches("") | sHip.matches("") |
                            sHeight.matches("") | sNeck.matches("")) {
                        Toast.makeText(getApplicationContext(), "All measurements required.",
                                Toast.LENGTH_SHORT).show();
                    } else {
                        try {
                            nWaist = Integer.parseInt(sWaist);
                            nNeck = Integer.parseInt(sNeck);
                            nHeight = Integer.parseInt(sHeight);
                            nHip = Integer.parseInt(sHip);
                            double bfPercent = (86.01 * Math.log10(nWaist + nHip - nNeck) -
                                    (70.041 * Math.log10(nHeight)) + 36.76);
                            result.setText((bfPercent) + "%");
                        } catch(NumberFormatException nfe) {
                            System.out.println("Could not parse " + nfe);
                            Toast.makeText(getApplicationContext(), "Round to Nearest cm.",
                                    Toast.LENGTH_SHORT).show();
                        }

                    }
                }

                if (isMale.isChecked()){
                    if (sWaist.matches("") | sHeight.matches("") | sNeck.matches("")) {
                        Toast.makeText(getApplicationContext(), "Neck, Waist, and Height Required.",
                                Toast.LENGTH_SHORT).show();
                    } else {
                        try {
                            nWaist = Integer.parseInt(sWaist);
                            nNeck = Integer.parseInt(sNeck);
                            nHeight = Integer.parseInt(sHeight);
                            double bfPercent = (86.01 * Math.log10(nWaist - nNeck) -
                                    (70.041 * Math.log10(nHeight)) + 36.76);
                            result.setText((bfPercent) + "%");
                        } catch(NumberFormatException nfe) {
                            System.out.println("Could not parse " + nfe);
                            Toast.makeText(getApplicationContext(), "Round to Nearest cm.",
                                    Toast.LENGTH_SHORT).show();
                        }

                    }
                }

            }
        });

    }



}