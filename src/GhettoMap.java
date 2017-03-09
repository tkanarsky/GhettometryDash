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
					System.out.println(x * BLOCK_WIDTH + " " + y * BLOCK_WIDTH);
					break;
				default:
					break;
				}
			}
		}
	}

	private void makePlayer() {
		player = new Player(-10, -10);
		ghettoObjects.add(player);
	}

	public void tick() {
		for (GhettoObject go : ghettoObjects) {
			go.tick();
		}

		Vec2 dir = Vec2.zero();

		if (im.getInput("up")) {
			dir.addLocal(0, -1);
		}
		if (im.getInput("right")) {
			dir.addLocal(1, 0);
		}
		if (im.getInput("down")) {
			dir.addLocal(0, 1);
		}
		if (im.getInput("left")) {
			dir.addLocal(-1, 0);
		}

		if (dir.equals(Vec2.zero())) {
			player.setVelocity(Vec2.zero());
		} else {
			player.setVelocity(dir.normalize());
		}
		
		System.out.println(player.getX() + " " + player.getY());

	}

	public void draw(Graphics g) {
		for (GhettoObject go : ghettoObjects) {
			go.draw(g, (int) (player.getX() - dim.getWidth() / 2 + player.getWidth() / 2), (int) (player.getY() - dim.getHeight() / 2 + player.getHeight() / 2));
			//go.draw(g, 0, 0);
		}
	}

}
