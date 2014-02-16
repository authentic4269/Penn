package com.example.androidclient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;


public class Connection implements Runnable, SensorEventListener {
	private SensorManager mSensorManager;
	private Sensor mRotationVectorSensor;
	private Sensor mLinearAccelerationSensor;
	private SensorManager manager;
	private PrintWriter out;
	private BufferedReader in;
	private boolean notify = false;
	
	public Connection(SensorManager m)
	{
		manager = m;

	}
	
	public void run() {
		try {
			mRotationVectorSensor = manager
					.getDefaultSensor(Sensor.TYPE_ROTATION_VECTOR);
			mLinearAccelerationSensor = manager
					.getDefaultSensor(Sensor.TYPE_LINEAR_ACCELERATION);

			
			manager.registerListener(this, mRotationVectorSensor, 100000);
			manager.registerListener(this, mLinearAccelerationSensor, 100000);
            // Make connection and initialize streams
            Socket socket = new Socket("158.130.167.201", 2000);
            in = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	public void notifyOrientation()
	{
		JSONObject ob = new JSONObject();
		try {
			ob.put("type", 2);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		out.println(ob.toString());
	}

	@Override
	public void onAccuracyChanged(Sensor arg0, int arg1) {
		// TODO Auto-generated method stub
		
	}

	public void onSensorChanged(SensorEvent event) {
		// we received a sensor event. it is a good practice to check
		// that we received the proper event
		JSONObject ob = new JSONObject();
		int i;
		if (event.sensor.getType() == Sensor.TYPE_ROTATION_VECTOR) {
			try {
				ob.put("type", 0);
				JSONArray arr = new JSONArray();
				for (i = 0; i < 3; i++)
					arr.put(event.values[i]);
				ob.put("data", arr);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		if (event.sensor.getType() == Sensor.TYPE_LINEAR_ACCELERATION) {
			try {
				ob.put("type", 1);
				JSONArray arr = new JSONArray();
				for (i = 0; i < 3; i++)
					arr.put(event.values[i]);
				ob.put("data", arr);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		out.println(ob.toString());
	}

	

}
