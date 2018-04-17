package com.example.simon.helloworld;

import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onAccelerometersButton(View view){
        Intent intent = new Intent(this, AccelerometersActivity.class);
        startActivity(intent);
    }

    public void onCompassButton(View view) {
        Intent intent = new Intent(this, CompassActivity.class);
        startActivity(intent);
    }
}
