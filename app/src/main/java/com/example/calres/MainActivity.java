package com.example.calres;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Spinner spinnerBand1, spinnerBand2, spinnerBand3, spinnerBand4;
    private TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        spinnerBand1 = findViewById(R.id.spinner_band1);
        spinnerBand2 = findViewById(R.id.spinner_band2);
        spinnerBand3 = findViewById(R.id.spinner_band3);
        spinnerBand4 = findViewById(R.id.spinner_band4);
        Button btnSet = findViewById(R.id.btn_set);
        tvResult = findViewById(R.id.tv_result);


        btnSet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateResistance();
            }
        });
    }

    private void calculateResistance() {
        //selected value from dropdown
        String color1 = spinnerBand1.getSelectedItem().toString();
        String color2 = spinnerBand2.getSelectedItem().toString();
        String color3 = spinnerBand3.getSelectedItem().toString();
        String color4 = spinnerBand4.getSelectedItem().toString();

        //function called
        int value1 = getColorValue(color1);
        int value2 = getColorValue(color2);
        int multiplier = getMultiplier(color3);
        double tolerance = getTolerance(color4);


        int resistance = (value1 * 10 + value2) * multiplier;

        // Display the result
        String result = resistance + "Ω ±" + tolerance + "%";
        tvResult.setText("Resistance Value: " + result);
    }


    private int getColorValue(String color) {
        switch (color) {
            case "Black":
                return 0;
            case "Brown":
                return 1;
            case "Red":
                return 2;
            case "Orange":
                return 3;
            case "Yellow":
                return 4;
            case "Green":
                return 5;
            case "Blue":
                return 6;
            case "Violet":
                return 7;
            case "Gray":
                return 8;
            case "White":
                return 9;
            default:
                return -1; // Error case
        }
    }

    // Method to get the multiplier value of the color
    private int getMultiplier(String color) {
        switch (color) {
            case "Black":
                return 1;
            case "Brown":
                return 10;
            case "Red":
                return 100;
            case "Orange":
                return 1000;
            case "Yellow":
                return 10000;
            case "Green":
                return 100000;
            case "Blue":
                return 1000000;
            case "Violet":
                return 10000000;
            case "Gray":
                return 100000000;
            case "White":
                return 1000000000;
            default:
                return -1; // Error case
        }
    }


    private double getTolerance(String color) {
        switch (color) {

            case "Gold":
                return 5.0;
            case "Silver":
                return 10.0;
            default:
                return 20.0;
        }
    }
}
