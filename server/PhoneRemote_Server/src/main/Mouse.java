package main;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Robot;
import java.awt.Toolkit;
import java.util.LinkedList;

public class Mouse {

	double[][] co;
	double dif0;
	double dif1;
	Robot r;
	double height;
	double width;
	LinkedList<Double> smoothx;
	LinkedList<Double> smoothy;
	
	public Mouse(double[][] canonicalOrientations) {
		co = canonicalOrientations;
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		width = screenSize.getWidth();
		height = screenSize.getHeight();
		try {
			r = new Robot();
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void updateOrientation(double[] orientation) {
		double x = width * (orientation[0] - co[1][0]) / (co[0][0] - co[1][0]);
		double y = height * (orientation[1] - co[2][1]) / (co[3][1] - co[2][1]);
		r.mouseMove((int) x, (int) y);
	}

}
