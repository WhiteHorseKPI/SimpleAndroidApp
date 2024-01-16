package com.example.simpleandroidapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    private TextView numberTextView;

    private int number = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        numberTextView = findViewById(R.id.numberTextView);
        updateNumberOnUI();

        findViewById(R.id.increaseButton).setOnClickListener(v -> increaseNumber());
        findViewById(R.id.decreaseButton).setOnClickListener(v -> decreaseNumber());
    }


    private void increaseNumber() {
        final int maxValue = 10;
        if (number == maxValue) {
            showToast("Number cannot be more than 10");
            return;
        }
        number++;
        updateNumberOnUI();
    }


    private void decreaseNumber() {
        final int minValue = 0;
        if (number == minValue) {
            showToast("Number cannot be less than 0");
            return;
        }
        number--;
        updateNumberOnUI();
    }


    private void updateNumberOnUI() {
        numberTextView.setText(String.valueOf(number));
    }


    private void showToast(final String msg) {
        runOnUiThread(() -> Toast
            .makeText(MainActivity.this, msg, Toast.LENGTH_SHORT)
            .show());
    }
}