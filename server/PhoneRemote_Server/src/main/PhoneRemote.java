package main;

import gui.SwingOrientation;
import server.PhoneSocketServer;
import java.awt.*;
//This class contains the main method which reads in data from the 
public class PhoneRemote {
	
	double orientation[];
	double acceleration[];
	double canonicalOrientations[][] = new double[3][3];
	int calibrate = 0;
	SwingOrientation gui;
	static Robot bot;
	final double delay = .02;
	
	
	public static void main(String[] args) throws AWTException  {
		PhoneRemote controller = new PhoneRemote();
		//PhoneSocketServer connection = new PhoneSocketServer(controller);
		controller.gui = new SwingOrientation();
		controller.gui.showTarget(0);
		
	}
	
	public PhoneRemote() throws AWTException{
		bot= new Robot();
	}

	public void updateOrientation(double[] vals) {
		orientation = vals;
		refreshMouse();
	}

	public void updateAcceleration(double[] vals) {
		acceleration = vals;
		refreshMouse();
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
	
	public void refreshMouse(){
		
		
	}
}
