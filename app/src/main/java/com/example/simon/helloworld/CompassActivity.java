package com.example.simon.helloworld;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class CompassActivity extends AppCompatActivity implements SensorEventListener {
    private SensorManager sensorManager;
    private Sensor rotationVector;
    private ImageView compassImg;
    private TextView compassText;
    private  float[] vector = new float[9];
    private float[] orientation = new float[3];
    private float azimuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compass);

        sensorManager = (SensorManager)getSystemService(SENSOR_SERVICE);
        compassImg = (ImageView) findViewById(R.id.compass);
        compassText = (TextView) findViewById(R.id.textViewCompass);

        rotationVector = sensorManager.getDefaultSensor(Sensor.TYPE_ROTATION_VECTOR);
    }

    protected void onResume() {
        super.onResume();
        sensorManager.registerListener(this, rotationVector, sensorManager.SENSOR_DELAY_NORMAL);
    }

    protected void onPause() {
        super.onPause();
        sensorManager.unregisterListener(this);
    }

    public void onAccuracyChanged(Sensor sensor, int accuracy) {
    }

    public void onSensorChanged(SensorEvent event) {
        SensorManager.getRotationMatrixFromVector(vector , event.values);
        azimuth = (float) (Math.toDegrees(SensorManager.getOrientation(vector, orientation)[0]) + 180) % 360;

        compassImg.setRotation(-azimuth);

        compassText.setText("Heading: " + azimuth + "degrees");
    }
}
