import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.awt.Graphics2D;

import javax.imageio.ImageIO;

public class GhettoObject {
	protected int x, y, width, height;
	public static final int NORTH = 1, SOUTH = 3, EAST = 2, WEST = 4;
	protected BufferedImage img;
	protected Rectangle boundingRect;

	public GhettoObject(int inputx, int inputy, int inputwidth, int inputheight, String imageName) {
		x = inputx;
		y = inputy;
		width = inputwidth;
		height = inputheight;
		loadImage(imageName);
	}

	public void draw(Graphics g) {
		g.drawImage(img, x, y, null);
	}
	
	protected void loadImage(String imageName) {
		try {
			URL url = getClass().getResource("res/" + imageName + ".png");
			img = ImageIO.read(url);
		} catch (Exception e) {
			System.out.println("Image could not be opened: " + "res/" + imageName + ".png");
			e.printStackTrace();
		}
		img = getScaledImage(img, width, height);
	}

	public BufferedImage getScaledImage(Image srcImg, int w, int h) {
		BufferedImage resizedImg = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2 = resizedImg.createGraphics();
		g2.drawImage(srcImg, 0, 0, w, h, null);
		g2.dispose();
		return resizedImg;
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
	
	public Rectangle getBoundingBox() {
		return new Rectangle(x, y, width, height);
	}
		

}