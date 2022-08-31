package com.example.bodyfatpercentagecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
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

                if (isFemale.isChecked()){
                    if (sWaist.matches("") | sHip.matches("") |
                            sHeight.matches("") | sNeck.matches("")) {
                        Toast.makeText(getApplicationContext(), "All measurements required.",
                                Toast.LENGTH_SHORT).show();
                    } else {
                        result.setText("11");
                    }
                }

                if (isMale.isChecked()){
                    if (sHip.matches("") | sHeight.matches("") | sNeck.matches("")) {
                        Toast.makeText(getApplicationContext(), "Neck, Hip, and Height Required.",
                                Toast.LENGTH_SHORT).show();
                    } else {
                        result.setText("12");
                    }
                }

            }
        });

    }



}