package com.example.simon.helloworld;


import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;


public class AccelerometersActivity extends AppCompatActivity implements SensorEventListener {
    private SensorManager sensorManager;
    private Sensor accelerometer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accelerometers);

        sensorManager = (SensorManager)getSystemService(SENSOR_SERVICE);;
        accelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        }

    protected void onResume() {
        super.onResume();
        sensorManager.registerListener(this, accelerometer, sensorManager.SENSOR_DELAY_NORMAL);
    }

    protected void onPause() {
        super.onPause();
        sensorManager.unregisterListener(this);
    }

    public void onAccuracyChanged(Sensor sensor, int accuracy) {
    }

    public void onSensorChanged(SensorEvent event) {
       TextView textViewX = (TextView) findViewById(R.id.textViewX);
        textViewX.setText("X: " + event.values[0]);

        TextView textViewY = (TextView) findViewById(R.id.textViewY);
        textViewY.setText("Y: " + event.values[1]);

        TextView textViewZ = (TextView) findViewById(R.id.textViewZ);
        textViewZ.setText("Z: " + event.values[2]);
    }
}
