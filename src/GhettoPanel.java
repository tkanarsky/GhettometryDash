import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractAction;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.Timer;

public class GhettoPanel extends JPanel {

	private Dimension dim;
	private Timer timer;
	private InputManager im;

	private static final int TICK_SPEED = 15;

	public GhettoPanel(Dimension d) {
		super(false);
		im = new InputManager();
		this.dim = d;
		this.setPreferredSize(dim);
		this.setBackground(new Color(0,0,0));
//		setUpGameMap();
		setUpInputs();
		setUpTimer();
	}

	private void setUpInputs() {

		this.getInputMap().put(KeyStroke.getKeyStroke("pressed SPACE"),
				"JUMPING");
		this.getInputMap().put(KeyStroke.getKeyStroke("released SPACE"),
				"NOT JUMPING");
		this.im.addInput("JUMP");
		this.getActionMap().put("JUMPING", new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				im.setInput("JUMP", true);
				repaint();
			}
		});
		this.getActionMap().put("NOT JUMPING", new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				im.setInput("JUMP", false);
				repaint();
			}
		});

	}

	private void setUpTimer() {
		timer = new Timer(10, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO: Shit that ticks
			}
		});
	}

}
