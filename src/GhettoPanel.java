import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
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
	private GhettoMap gm;

	private static final int TICK_SPEED = 15;

	public GhettoPanel(Dimension d) {
		super(false);
		im = new InputManager();
		this.dim = d;
		this.setPreferredSize(dim);
		this.setBackground(new Color(0, 0, 0));
		setUpGameMap();
		setUpInputs();
		setUpTimer();
	}

	private void setUpGameMap() {
		gm = new GhettoMap(im, dim, "level");
	}

	private void setUpInputs() {

		this.getInputMap().put(KeyStroke.getKeyStroke("SPACE"), "JUMPING");
		this.getInputMap().put(KeyStroke.getKeyStroke("released SPACE"), "NOT JUMPING");
		im.addInput("JUMP");
		this.getActionMap().put("JUMPING", new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				im.setInput("JUMP", true);
			}
		});
		this.getActionMap().put("NOT JUMPING", new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				im.setInput("JUMP", false);
			}
		});

		String[] inputNames = { "up", "down", "left", "right" };

//		this.getInputMap().put(KeyStroke.getKeyStroke("UP"), "up");
//		this.getInputMap().put(KeyStroke.getKeyStroke("DOWN"), "down");
//		this.getInputMap().put(KeyStroke.getKeyStroke("LEFT"), "left");
//		this.getInputMap().put(KeyStroke.getKeyStroke("RIGHT"), "right");

		this.getInputMap().put(KeyStroke.getKeyStroke("released UP"), "released up");
		this.getInputMap().put(KeyStroke.getKeyStroke("released DOWN"), "released down");
		this.getInputMap().put(KeyStroke.getKeyStroke("released LEFT"), "released left");
		this.getInputMap().put(KeyStroke.getKeyStroke("released RIGHT"), "released right");

		this.getInputMap().put(KeyStroke.getKeyStroke("W"), "up");
		this.getInputMap().put(KeyStroke.getKeyStroke("S"), "down");
		this.getInputMap().put(KeyStroke.getKeyStroke("A"), "left");
		this.getInputMap().put(KeyStroke.getKeyStroke("D"), "right");

		this.getInputMap().put(KeyStroke.getKeyStroke("released W"), "released up");
		this.getInputMap().put(KeyStroke.getKeyStroke("released S"), "released down");
		this.getInputMap().put(KeyStroke.getKeyStroke("released A"), "released left");
		this.getInputMap().put(KeyStroke.getKeyStroke("released D"), "released right");

		for (String name : inputNames) {
			im.addInput(name);
		}

		// This associates the command shoot with some action. In this
		// case, the action triggers a shoot command invoked on my GameMap. In
		// general, whatever
		// goes in the actionPerformed method will be executed when a shoot
		// command
		// is sent...

		for (final String name : inputNames) {
			this.getActionMap().put(name, new AbstractAction() {
				@Override
				public void actionPerformed(ActionEvent e) {
					im.setInput(name, true);
				}
			});

			this.getActionMap().put("released " + name, new AbstractAction() {
				@Override
				public void actionPerformed(ActionEvent e) {
					im.setInput(name, false);
				}
			});
		}

	}

	private void setUpTimer() {
		timer = new Timer(10, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				gm.tick();
				repaint();
			}
		});
		timer.start();
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		gm.draw(g);
	}

}
