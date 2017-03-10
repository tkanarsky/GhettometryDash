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

	protected double x, y;
	protected int width, height;
	protected BufferedImage img;
	protected ObjectType type;

	protected Vec2 velocity = Vec2.zero();

	public GhettoObject(int inputx, int inputy, int inputwidth, int inputheight, ObjectType inputtype) {
		x = inputx;
		y = inputy;
		width = inputwidth;
		height = inputheight;
		type = inputtype;
		loadImage(type.getImageName());
	}

	public void draw(Graphics g, int xOffset, int yOffset) {
		g.drawImage(img, (int) (x - xOffset), (int) (y - yOffset), width, height, null);
	}

	public void tick() {
		x += velocity.getX();
		y += velocity.getY();
	};

	protected void loadImage(String imageName) {
		try {
			URL url = getClass().getResource("res/" + imageName + ".png");
			img = ImageIO.read(url);
		} catch (Exception e) {
			System.out.println("Image could not be opened: " + "res/"
					+ imageName + ".png");
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

	public void setVelocity(Vec2 v) {
		velocity = v;
	}

	public Vec2 getVelocity() {
		return velocity;
	}

	public void setX(double d) {
		x = d;
	}

	public double getX() {
		return x;
	}

	public void setY(double d) {
		y = d;
	}

	public double getY() {
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
		return new Rectangle((int) x, (int) y, width, height);
	}

	public boolean isColliding(GhettoObject go) {
		return getBoundingBox().intersects(go
				.getBoundingBox());
	}

}