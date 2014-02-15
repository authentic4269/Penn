package com.example.androidclient;

import android.app.Activity;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

import com.androidplot.xy.*;

/**
 * Wrapper activity demonstrating the use of the new {@link SensorEvent#values
 * rotation vector sensor} ({@link Sensor#TYPE_ROTATION_VECTOR
 * TYPE_ROTATION_VECTOR}).
 * 
 * @see Sensor
 * @see SensorEvent
 * @see SensorManager
 * 
 */
public class MotionControllerActivity extends Activity {

	private Thread conn;
	private Connection connection;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		int i = R.layout.activity_motion_controller;
		connection = new Connection((SensorManager)getSystemService(SENSOR_SERVICE));
		this.conn = new Thread(connection);
		setContentView(i);
		ImageButton bt = (ImageButton) findViewById(R.id.imageButton1);
		//this.conn.start();
		
		
		bt.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				connection.notifyOrientation();
			}
			
		});
		this.conn.start();

	}

	@Override
	protected void onResume() {
		// Ideally a game should implement onResume() and onPause()
		// to take appropriate action when the activity looses focus
		super.onResume();
	}

	@Override
	protected void onPause() {
		// Ideally a game should implement onResume() and onPause()
		// to take appropriate action when the activity looses focus
		super.onPause();

	}

	public void stop() {
	}



}