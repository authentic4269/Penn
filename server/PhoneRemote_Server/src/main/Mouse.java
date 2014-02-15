package main;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Robot;
import java.awt.Toolkit;

public class Mouse {

	double[][] co;
	Robot r;
	final double screenWidth = .3589; //width of this machine's screen in meters
	final double screenHeight = .2471; //height of this machine's screen in meters 
	int pixelWidth;  //width of this machine's screen in pixels
	int pixelHeight; //height of this machine's screen in pixels 
	
	public Mouse(double[][] canonicalOrientations) {
		co = canonicalOrientations;
		try {
			r = new Robot();
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		 pixelWidth = screenSize.width;
		 pixelHeight = screenSize.height;
	}

	public void updateOrientation(double[] orientation) {
		// TODO Auto-generated method stub
		
	}
	
	public void updateCoordinates(double[] currentPosition){
		
		int newXCoord = (int) Math.floor((currentPosition[0]/screenWidth)*pixelWidth);
		int newYCoord = pixelHeight - (int) Math.floor((currentPosition[1]/screenHeight)*pixelHeight);
		
	}

}
