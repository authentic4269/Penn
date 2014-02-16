package main;

import gui.SwingOrientation;

import java.awt.AWTException;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;

import org.json.*;

import server.DataTransformer;
import server.PhoneSocketServer;

//This class contains the main method which reads in data from the 
public class PhoneRemote {
	
	double orientation[];
	double acceleration[];
	double canonicalOrientations[][] = new double[3][3];
	int calibrate = 0;
	SwingOrientation gui;
	
	public static void main(String[] args)  {
		PhoneRemote controller = new PhoneRemote();
		PhoneSocketServer connection = new PhoneSocketServer(controller);
		controller.gui = new SwingOrientation();
		controller.gui.showTarget(0);
		
	}
	
	public PhoneRemote()
	{
	}

	public void updateOrientation(double[] vals) {
		orientation = vals;
	}

	public void updateAcceleration(double[] vals) {
		acceleration = vals;
		System.out.println("Acceleration:");
		System.out.print("\t0: " + vals[0] + ", 1: " + vals[1] + ", 2: " + vals[2] + "\n");
	}

	public void calibrate() {
		if (calibrate == 3)
		{
			gui.finish();
		}
		else 
		{
			gui.showTarget(++calibrate);
		}
	}
}
