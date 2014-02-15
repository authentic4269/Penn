package main;

import gui.SwingOrientation;
import java.awt.AWTException;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;

import java.util.LinkedList;

import org.json.*;

import server.DataTransformer;
import server.PhoneSocketServer;
import java.awt.*;
//This class contains the main method which reads in data from the 
public class PhoneRemote {
	
	double orientation[];
	double acceleration[];
	double canonicalOrientations[][] = new double[4][3];
	double smooth[] = {-36, 9, 44, 69, 84, 89, 84, 69, 44, 9, -36};
	double smoothDenom;
	LinkedList<LinkedList<Double>> lastOrientations = new LinkedList<LinkedList<Double>>();
	int calibrate = 0;
	SwingOrientation gui;
	static Robot bot;
	final double delay = .02;
	private Mouse mouse = null;
	
	
	public static void main(String[] args) throws AWTException  {
		PhoneRemote controller = new PhoneRemote();
		controller.gui = new SwingOrientation();
		controller.gui.run();	

		controller.lastOrientations.add(new LinkedList<Double>());
		controller.lastOrientations.add(new LinkedList<Double>());
		controller.lastOrientations.add(new LinkedList<Double>());
		controller.orientation = new double[3];
		int i, j;
		for (i = 0; i < 3; i++)
		{
			for (j = 0; j < 11; j++)
			{
				controller.lastOrientations.get(i).add(0.0);
			}
		}
		controller.smoothDenom = 0.0;
		for (i = 0; i < 11; i++)
		{
			controller.smoothDenom += controller.smooth[i];
		}
		PhoneSocketServer connection = new PhoneSocketServer(controller);
	}
	
	public PhoneRemote() throws AWTException{
		bot= new Robot();
	}

	public void updateOrientation(double[] vals) {
		orientation = vals;
		int i, j;
		double smoothNumer;
		LinkedList<Double> cur;
		for (i = 0; i < 3; i++)
		{
			cur = lastOrientations.get(i);
			cur.removeFirst();
			cur.add(vals[i]);
			smoothNumer = 0.0;
			for (j = 0; j < 11; j++)
			{
				smoothNumer += smooth[j] * vals[i];
			}
			orientation[i] = smoothNumer / smoothDenom;
		}
		if (mouse != null)
		{
			mouse.updateOrientation(orientation);
		}
	}

	public void updateAcceleration(double[] vals) {
		acceleration = vals;
		refreshMouse();
	}

	public void calibrate() {
		int i;
		for (i = 0; i < 3; i++)
			canonicalOrientations[calibrate][i] = orientation[i];
		if (calibrate == 3)
		{
			gui.finish();
			mouse = new Mouse(canonicalOrientations);
		}
		else 
		{
			gui.showTarget(++calibrate);
		}
	}
	
	public void refreshMouse(){
		
		
	}
}
