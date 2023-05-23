package com.example.fitapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class CalculateBodyFat extends AppCompatActivity {

    EditText etAge, etWeight, etHeight, etNeck, etWaist;
    Button calculateBodyFatButton;
    TextView tvBodyFatValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculate_body_fat);

        etAge = findViewById(R.id.etAge);
        etWeight = findViewById(R.id.etWeight);
        etHeight = findViewById(R.id.etHeight);
        etNeck = findViewById(R.id.etNeck);
        etWaist = findViewById(R.id.etWaist);
        calculateBodyFatButton = findViewById(R.id.calculateBodyFatButton);
        tvBodyFatValue = findViewById(R.id.tvBodyFatValue);

        calculateBodyFatButton.setOnClickListener(v -> {
            if (etAge.getText().toString().isEmpty() || etWeight.getText().toString().isEmpty() || etHeight.getText().toString().isEmpty() || etNeck.getText().toString().isEmpty() || etWaist.getText().toString().isEmpty()) {
                Toast.makeText(CalculateBodyFat.this, "Please fill all the fields", Toast.LENGTH_SHORT).show();
                return;
            }
            double age = Double.parseDouble(etAge.getText().toString());
            double weight = Double.parseDouble(etWeight.getText().toString());
            double height = Double.parseDouble(etHeight.getText().toString());
            double neck = Double.parseDouble(etNeck.getText().toString());
            double waist = Double.parseDouble(etWaist.getText().toString());
            double bodyFatValue = calculateBodyFat(age, weight, height, neck, waist);
            tvBodyFatValue.setText(String.valueOf(bodyFatValue));
        });
    }

    public double calculateBodyFat(double age, double weight, double height, double neck, double waist) {
        double bodyFatValue = 0;
        if (age >= 0 && age <= 39) {
            bodyFatValue = 1.20 * (weight / height) + 0.23 * age - 16.2;
        } else if (age >= 40 && age <= 59) {
            bodyFatValue = 1.20 * (weight / height) + 0.23 * age - 5.4;
        } else if (age >= 60) {
            bodyFatValue = 1.20 * (weight / height) + 0.23 * age + 0.8;
        }
        return bodyFatValue;
    }
}