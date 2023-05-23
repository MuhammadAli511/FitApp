package com.example.fitapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainPage extends AppCompatActivity {
    Button bmi, bodyfat, meals;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);

        bmi = findViewById(R.id.bmi);
        bodyfat = findViewById(R.id.bodyfat);
        meals = findViewById(R.id.meals);

        bmi.setOnClickListener(v -> {
            Intent intent = new Intent(MainPage.this, CalculateBMI.class);
            startActivity(intent);
        });

        bodyfat.setOnClickListener(v -> {
            Intent intent = new Intent(MainPage.this, CalculateBodyFat.class);
            startActivity(intent);
        });

        meals.setOnClickListener(v -> {
            Intent intent = new Intent(MainPage.this, EnterMeal.class);
            startActivity(intent);
        });
    }
}