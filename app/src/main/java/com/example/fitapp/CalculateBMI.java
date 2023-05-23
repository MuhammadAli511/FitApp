package com.example.fitapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class CalculateBMI extends AppCompatActivity {
    EditText etWeight, etHeight;
    RadioGroup genderRadioGroup;
    Button calculateBMIButton;
    TextView tvBMIValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculate_bmi);

        etWeight = findViewById(R.id.etWeight);
        etHeight = findViewById(R.id.etHeight);
        genderRadioGroup = findViewById(R.id.genderRadioGroup);
        calculateBMIButton = findViewById(R.id.calculateBMIButton);
        tvBMIValue = findViewById(R.id.tvBMIValue);

        calculateBMIButton.setOnClickListener(v -> {
            if (etWeight.getText().toString().isEmpty() || etHeight.getText().toString().isEmpty() || genderRadioGroup.getCheckedRadioButtonId() == -1) {
                Toast.makeText(CalculateBMI.this,"Please fill all the fields",Toast.LENGTH_SHORT).show();
                return;
            }
            double weight = Double.parseDouble(etWeight.getText().toString());
            double height = Double.parseDouble(etHeight.getText().toString());
            double bmi = weight / (height * height);
            tvBMIValue.setText(String.valueOf(bmi));
        });
    }
}