import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;

import javax.imageio.ImageIO;

public class BitmapParser {

	static BufferedImage levelMap;

	private static HashMap<Color, ObjectType> colorCodes = new HashMap<Color, ObjectType>();

	static {
		colorCodes.put(new Color(255, 0, 0), ObjectType.SPIKE);
		colorCodes.put(new Color(0, 0, 0), ObjectType.BLOCK);
		colorCodes.put(new Color(127, 127, 127), ObjectType.SHORT_BLOCK);
		colorCodes.put(new Color(255, 255, 255), ObjectType.EMPTY);
		colorCodes.put(new Color(255, 255, 0), ObjectType.PAD_YELLOW);
		colorCodes.put(new Color(255, 0, 255), ObjectType.PAD_PINK);
		colorCodes.put(new Color(0, 255, 255), ObjectType.PAD_BLUE);
		colorCodes.put(new Color(127, 127, 0), ObjectType.RING_YELLOW);
		colorCodes.put(new Color(127, 0, 127), ObjectType.RING_PINK);
		colorCodes.put(new Color(0, 127, 127), ObjectType.RING_BLUE);
		colorCodes.put(new Color(0, 255, 0), ObjectType.GRAVITY_PORTAL);
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

	public ObjectType[][] readBitmap() throws IOException {
		ObjectType[][] bitmap = new ObjectType[levelMap.getHeight()][levelMap
				.getWidth()];
		for (int i = 0; i < bitmap.length; i++) {
			for (int j = 0; j < bitmap[i].length; j++) {
				Color c = Color.decode(Integer.toString(levelMap.getRGB(j, i)));
				switch (colorCodes.get(c)) {
				case SPIKE:
					bitmap[i][j] = ObjectType.SPIKE;
					break;
				case BLOCK:
					bitmap[i][j] = ObjectType.BLOCK;
					break;
				case EMPTY:
					bitmap[i][j] = ObjectType.EMPTY;
					break;
				case GRAVITY_PORTAL:
					bitmap[i][j] = ObjectType.GRAVITY_PORTAL;
					break;
				case PAD_BLUE:
					bitmap[i][j] = ObjectType.PAD_BLUE;
					break;
				case PAD_PINK:
					bitmap[i][j] = ObjectType.PAD_PINK;
					break;
				case PAD_YELLOW:
					bitmap[i][j] = ObjectType.PAD_YELLOW;
					break;
				case RING_BLUE:
					bitmap[i][j] = ObjectType.RING_BLUE;
					break;
				case RING_PINK:
					bitmap[i][j] = ObjectType.RING_PINK;
					break;
				case RING_YELLOW:
					bitmap[i][j] = ObjectType.RING_YELLOW;
					break;
				case SHORT_BLOCK:
					bitmap[i][j] = ObjectType.SHORT_BLOCK;
					break;
				default:
					bitmap[i][j] = ObjectType.EMPTY;
					break;
				}
			}
		}
		return bitmap;
	}

}
