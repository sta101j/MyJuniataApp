package com.example.CampusResource;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class FleetActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fleet);

        findViewById(R.id.btnBack).setOnClickListener(v -> finish());
    }
}
