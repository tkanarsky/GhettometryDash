import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;

import javax.imageio.ImageIO;

public class BitmapParser {

	static BufferedImage levelMap;
	private static Color spike = new Color(255, 0, 0);
	private static Color regularBlock = new Color(0, 0, 0);
	private static Color halfBlock = new Color(50, 50, 50);
	private static Color empty = new Color(255, 255, 255);

	private static HashMap<Color, LevelObjects> colorCodes = new HashMap<Color, LevelObjects>();

	static {
		colorCodes.put(new Color(255, 0, 0), LevelObjects.SPIKE);
		colorCodes.put(new Color(0, 0, 0), LevelObjects.BLOCK);
		colorCodes.put(new Color(127, 127, 127), LevelObjects.SHORT_BLOCK);
		colorCodes.put(new Color(255, 255, 255), LevelObjects.EMPTY);
		colorCodes.put(new Color(255, 255, 0), LevelObjects.PAD_YELLOW);
		colorCodes.put(new Color(255, 0, 255), LevelObjects.PAD_PINK);
		colorCodes.put(new Color(0, 255, 255), LevelObjects.PAD_BLUE);
		colorCodes.put(new Color(127, 127, 0), LevelObjects.RING_YELLOW);
		colorCodes.put(new Color(127, 0, 127), LevelObjects.RING_PINK);
		colorCodes.put(new Color(0, 127, 127), LevelObjects.RING_BLUE);
		colorCodes.put(new Color(0, 255, 0), LevelObjects.GRAVITY_PORTAL);
	}

	public BitmapParser(String levelName) {
		try {
			URL url = getClass().getResource("res/" + levelName + ".png");
			levelMap = ImageIO.read(url);
			if (levelMap.getHeight() != 10)
				throw new Exception();
		} catch (Exception e) {
			Log.log("Level bitmap must be 10 pixels high!", Log.ERROR);
			e.printStackTrace();
		}
		Log.log("Successfully loaded levelmap: " + levelName, Log.VERBOSE);
	}

	public LevelObjects[][] readBitmap() throws IOException {
		LevelObjects[][] bitmap = new LevelObjects[levelMap.getHeight()][levelMap
				.getWidth()];
		for (int i = 0; i < bitmap.length; i++) {
			for (int j = 0; j < bitmap[i].length; j++) {
				Color c = Color.decode(Integer.toString(levelMap.getRGB(j, i)));
				switch (colorCodes.get(c)) {
				case SPIKE:
					bitmap[i][j] = LevelObjects.SPIKE;
					break;
				case BLOCK:
					bitmap[i][j] = LevelObjects.BLOCK;
					break;
				case EMPTY:
					bitmap[i][j] = LevelObjects.EMPTY;
					break;
				case GRAVITY_PORTAL:
					bitmap[i][j] = LevelObjects.GRAVITY_PORTAL;
					break;
				case PAD_BLUE:
					bitmap[i][j] = LevelObjects.PAD_BLUE;
					break;
				case PAD_PINK:
					bitmap[i][j] = LevelObjects.PAD_PINK;
					break;
				case PAD_YELLOW:
					bitmap[i][j] = LevelObjects.PAD_YELLOW;
					break;
				case RING_BLUE:
					bitmap[i][j] = LevelObjects.RING_BLUE;
					break;
				case RING_PINK:
					bitmap[i][j] = LevelObjects.RING_PINK;
					break;
				case RING_YELLOW:
					bitmap[i][j] = LevelObjects.RING_YELLOW;
					break;
				case SHORT_BLOCK:
					bitmap[i][j] = LevelObjects.SHORT_BLOCK;
					break;
				default:
					bitmap[i][j] = LevelObjects.EMPTY;
					break;
				}
			}
		}
		return bitmap;
	}

	public static void main(String[] args) throws IOException {
		BitmapParser b = new BitmapParser("level");
		LevelObjects[][] bm = b.readBitmap();
		for (LevelObjects[] row : bm) {
			for (LevelObjects obj : row) {
				System.out.print(obj + " ");
			}
			System.out.println();
		}
	}

}
