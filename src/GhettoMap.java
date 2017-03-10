import java.awt.Dimension;
import java.awt.Graphics;
import java.io.IOException;
import java.util.ArrayList;

public class GhettoMap {

	private static final int BLOCK_WIDTH = 60;

	private Dimension dim;

	private InputManager im;

	public ObjectType[][] mapTemplate;
	public ArrayList<GhettoObject> ghettoObjects;
	public Player player;

	public GhettoMap(InputManager im, Dimension dim, String levelName) {

		try {
			mapTemplate = new BitmapParser(levelName).readBitmap();
		} catch (IOException e) {
			Log.log("Level file not found", Log.ERROR);
			e.printStackTrace();
		}

		this.im = im;
		this.dim = dim;
		this.ghettoObjects = new ArrayList<>();

		loadObjects();
		makePlayer();

	}

	private void loadObjects() {
		for (int y = 0; y < mapTemplate.length; y++) {
			for (int x = 0; x < mapTemplate[y].length; x++) {
				switch (mapTemplate[y][x]) {
				case EMPTY:
					break;
				case SPIKE:
					ghettoObjects.add(new Spike(x * BLOCK_WIDTH, y * BLOCK_WIDTH));
					break;
				case BLOCK:
					ghettoObjects.add(new Block(x * BLOCK_WIDTH, y * BLOCK_WIDTH));
					break;
				case SHORT_BLOCK:
					ghettoObjects.add(new ShortBlock(x * BLOCK_WIDTH, y * BLOCK_WIDTH));
					break;
				case PAD_PINK:
					ghettoObjects.add(new PinkPad(x * BLOCK_WIDTH, y * BLOCK_WIDTH));
					break;
				case PAD_BLUE:
					ghettoObjects.add(new BluePad(x * BLOCK_WIDTH, y * BLOCK_WIDTH));
					break;
				case PAD_YELLOW:
					ghettoObjects.add(new YellowPad(x * BLOCK_WIDTH, y * BLOCK_WIDTH));
					break;
				case RING_PINK:
					ghettoObjects.add(new PinkRing(x * BLOCK_WIDTH, y * BLOCK_WIDTH));
					break;
				case RING_BLUE:
					ghettoObjects.add(new BlueRing(x * BLOCK_WIDTH, y * BLOCK_WIDTH));
					break;
				case RING_YELLOW:
					ghettoObjects.add(new YellowRing(x * BLOCK_WIDTH, y * BLOCK_WIDTH));
					break;
				default:
					break;
				}
			}
		}
	}

	private void makePlayer() {
		player = new Player(0, 60);
		ghettoObjects.add(player);
	}

	public void tick() {
		for (GhettoObject go : ghettoObjects) {
			//if(!go.isColliding(go))
			if(player.isColliding(go) && !(go instanceof Player)){
				player.getVelocity().setY(0);
				if(go instanceof Block){
					if (im.getInput("JUMP"))
					{
						player.jump();
					}
				}
				if(go instanceof YellowPad) {
					player.jump();
					player.jump();
				}
			}
			go.tick();
		}		
	}

	public void draw(Graphics g) {
		for (GhettoObject go : ghettoObjects) {
			go.draw(g, (int) (player.getX() - dim.getWidth() / 2 + player.getWidth() / 2), (int) (player.getY() - dim.getHeight() / 2 + player.getHeight() / 2));
			//go.draw(g, 0, 0);
		}
	}

}
