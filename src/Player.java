import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

public class Player {

	
	private int x, y, width, height, speed;
	private Vec2 direction;
	private Image img;
	
	public Player(int x, int y){
		//super(x, y);
		this.x = x;
		this.y = y;
		try
		{
			URL url = getClass().getResource("res/basicSquare.png");
			img = ImageIO.read(url);
		}
		catch (IOException e)
		{
			System.out.println("Problem opening the .jpg");
			e.printStackTrace();
		}
		
	}
	
	public int getX(){
		return x;
	}
	
	public int getY(){
		return y;
	}
	
	public void setX(int x){
		this.x = x;
	}
	
	public void setY(int y){
		this.y = y;
	}
	
	public void draw(Graphics g){
		g.drawImage(img, x, y, 20, 20, null);
	}
	
	public void move(){
		x += 5;
	}
	
	public void setMoving(Vec2 direction, int speed){
		this.direction = direction;
		this.speed = speed;
		
	}
	
	protected void onCollide(LevelObject LO){
		
	}
}
