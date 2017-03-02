import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;


public class GhettoLauncher extends JFrame {
	
	public GhettoLauncher() {
		super("Ghettometry Dash!");
		System.setProperty("sun.java2d.opengl", "true");
		
		Dimension d = new Dimension(800,600);
		GhettoPanel panel = new GhettoPanel(d);
		this.add(panel);
		this.pack();
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
