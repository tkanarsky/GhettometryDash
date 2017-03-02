import java.awt.Dimension;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.Timer;

public class GhettoPanel extends JPanel {

	private Dimension dim;
	private Timer timer;
	private InputManager im;

	public GhettoPanel(Dimension d) {
		super(false);
		im = new InputManager();
		this.dim = d;
		this.setPreferredSize(dim);
		setUpGameMap();
		setUpInputs();
		setUpTimer();
	}

	private void onClick(boolean state) {
		
		

	}

	private void setUpInputs() {
		
		this.getInputMap().put(KeyStroke.getKeyStroke("pressed SPACE"), "JUMPING");
		this.getInputMap().put(KeyStroke.getKeyStroke("released SPACE"), "NOT JUMPING");
		this.im.addInput("JUMP");


	}

}
