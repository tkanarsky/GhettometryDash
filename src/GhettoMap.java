import java.awt.Dimension;
import java.awt.Graphics;
import java.io.IOException;
import java.util.ArrayList;

public class GhettoMap {

	private static final int BLOCK_WIDTH = 60;

	private Dimension dim;

	public ObjectType[][] mapTemplate;
	public ArrayList<GhettoObject> ghettoObjects;
	public Player player;

	public GhettoMap(Dimension dim, String levelName) {
		try {
			mapTemplate = new BitmapParser(levelName).readBitmap();
		} catch (IOException e) {
			Log.log("Level file not found", Log.ERROR);
			e.printStackTrace();
		}
		this.dim = dim;
		this.ghettoObjects = new ArrayList<>();
		loadObjects();
	}

	private void loadObjects() {
		for (int y = 0; y < mapTemplate.length; y++) {
			for (int x = 0; x < mapTemplate[y].length; x++) {
				switch (mapTemplate[y][x]) {
				case EMPTY:
					break;
				case SPIKE:
					ghettoObjects.add(new Spike(x * BLOCK_WIDTH, y
							* BLOCK_WIDTH));
					
				default:
					break;
				}
			}
		}
	}

	public void tick() {
		for (GhettoObject go : ghettoObjects) {
			go.tick();
		}
	}

	public void draw(Graphics g) {
		for (GhettoObject go : ghettoObjects) {
			go.draw(g);
		}
	}

}
