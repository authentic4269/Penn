package gui;

import java.awt.Toolkit;

import javax.swing.JFrame;

public class SwingOrientation {
	public SwingOrientation() {
		JFrame frame = new JFrame("FrameDemo");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// 3. Create components and put them in the frame.
		// ...create emptyLabel...
		
		Toolkit tk = Toolkit.getDefaultToolkit();  
		int xSize = ((int) tk.getScreenSize().getWidth());  
		int ySize = ((int) tk.getScreenSize().getHeight());  
		frame.setSize(xSize,ySize);  
		frame.show();  
		// 4. Size the frame.

		// 5. Show it.
		frame.setVisible(true);
	}

	public void showTarget(int i) {
		// TODO Auto-generated method stub
		
	}

	public void finish() {
		// TODO Auto-generated method stub
		
	}

}
