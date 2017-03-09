import java.awt.Dimension;
import java.io.IOException;
import java.util.ArrayList;


public class GhettoMap {
	public ObjectType[][] mapTemplate;
	public ArrayList<GhettoObject> map;
	public Player player;
	private Dimension dim;
	private int rows;
	private int columns;
	private int templateColumnToLoad = 0;
	private static final int BLOCK_WIDTH = 60;
	private boolean gameOver = false;
	
	public GhettoMap(Dimension dim, String levelName) {
		try {
			mapTemplate = new BitmapParser(levelName).readBitmap();
		} catch (IOException e) {
			Log.log("Level file not found", Log.ERROR);		
			e.printStackTrace();
		}
		this.dim = dim;
		loadObjects();
	}
	
	private void loadObjects() {
		for (int y = 0; y < mapTemplate.length; y++) { 
			for (int x = 0; x < mapTemplate[x].length; x++) {
				switch(mapTemplate[y][x]) {
					case EMPTY:
						break;
					case SPIKE:
						map.add(new Spike(x*BLOCK_WIDTH, y*BLOCK_WIDTH));
				}
			}
		}
	}


	private void advancePlayer() {
		if (!gameOver) {
			
		}
	}
	
	public boolean gameOver() {
		for (GhettoObject go : map) {
			if (player.isColliding(go)) {
				
			}
		}
	}
	
	
	
}
