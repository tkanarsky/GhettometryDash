import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

public class Player extends GhettoObject{

	public Player(int x, int y) {
		super(x, y, 60, 60, ObjectType.PLAYER);
		
	}
	
	public void jump(){
		velocity.addLocal(0, -1);
	}
	
	@Override
	public void tick()
	{
		super.tick();
		velocity.addLocal(0, 0.1);
	}
	
	
}
