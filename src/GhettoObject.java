import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.awt.Graphics2D;

import javax.imageio.ImageIO;

public class GhettoObject {
	protected int speed, x, y, width, height, health, direction;
	public String type;
	public static final int NORTH = 1, SOUTH = 3, EAST = 2, WEST = 4;

	public GhettoObject(int inputx, int inputy, int inputwidth, int inputheight, String inputtype) {
		x = inputx;
		y = inputy;
		width = inputwidth;
		height = inputheight;
		type = inputtype;
	}

	public void draw(Graphics g) {
		try {
			BufferedImage img = ImageIO.read(getClass().getResourceAsStream(imageFileName()));

			img = (BufferedImage) getScaledImage(img, width, height);

			g.drawImage(img, x, y, null);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private String imageFileName() {
		return null;
	}

	public Image getScaledImage(Image srcImg, int w, int h) {
		//resizes the image
		BufferedImage resizedImg = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2 = resizedImg.createGraphics();
		/* System.out.println("meep");
		g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
		RenderingHints.VALUE_INTERPOLATION_BILINEAR); */
		g2.drawImage(srcImg, 0, 0, w, h, null);
		g2.dispose();

		return resizedImg;
	}

	public void setType(String input) {
		type = input;
	}

	public String getType() {
		return type;
	}

	public void setSpeed(int input) {
		speed = input;
	}

	public int getSpeed() {
		return speed;
	}

	public void setX(int input) {
		x = input;
	}

	public int getX() {
		return x;
	}

	public void setY(int input) {
		y = input;
	}

	public int getY() {
		return y;
	}

	public void setWidth(int input) {
		width = input;
	}

	public int getWidth() {
		return width;
	}

	public void setHeight(int input) {
		height = input;
	}

	public int getHeight() {
		return height;
	}

	public void setHealth(int input) {
		health = input;
	}

	public int getHealth() {
		return health;
	}

	public void setLevel(int input) {
		level = input;
	}

	public int getLevel() {
		return level;
	}

	public void setDirection(int input){
		direction = input;
	}
	
	public int getDirection(){
		return direction;
	}
	
	
	@Override
	public void move() {
		//moves with boundaries based on speed, if the next move is off the map, it will not move
		if (x <= (600-width-speed) && direction == EAST) {
			setX(x + speed);
		} else if (x >= speed-1 && direction == WEST) {
			setX(x - speed);
//			System.out.println(x + " " + y + " " + speed);
		} else if (y >= speed && direction == NORTH) {
			setY(y - speed);
		} else if (y <= (600-height-speed) && direction == SOUTH) {
			setY(y + speed);
		}
	}

	public void nameYoSelf() {
		//i just did this for fun, apparently it's supposed to be called "toString"
		System.out.println(type + " at " + x + " " + y);
	}


	@Override
	public Rectangle getBoundingRect() {
		// TODO Auto-generated method stub
		return null;
	}

}