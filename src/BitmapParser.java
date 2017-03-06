import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;

import javax.imageio.ImageIO;

public class BitmapParser {

	static BufferedImage levelMap;

	private static HashMap<Color, ObjectList> colorCodes = new HashMap<Color, ObjectList>();

	static {
		colorCodes.put(new Color(255, 0, 0), ObjectList.SPIKE);
		colorCodes.put(new Color(0, 0, 0), ObjectList.BLOCK);
		colorCodes.put(new Color(127, 127, 127), ObjectList.SHORT_BLOCK);
		colorCodes.put(new Color(255, 255, 255), ObjectList.EMPTY);
		colorCodes.put(new Color(255, 255, 0), ObjectList.PAD_YELLOW);
		colorCodes.put(new Color(255, 0, 255), ObjectList.PAD_PINK);
		colorCodes.put(new Color(0, 255, 255), ObjectList.PAD_BLUE);
		colorCodes.put(new Color(127, 127, 0), ObjectList.RING_YELLOW);
		colorCodes.put(new Color(127, 0, 127), ObjectList.RING_PINK);
		colorCodes.put(new Color(0, 127, 127), ObjectList.RING_BLUE);
		colorCodes.put(new Color(0, 255, 0), ObjectList.GRAVITY_PORTAL);
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

	public ObjectList[][] readBitmap() throws IOException {
		ObjectList[][] bitmap = new ObjectList[levelMap.getHeight()][levelMap
				.getWidth()];
		for (int i = 0; i < bitmap.length; i++) {
			for (int j = 0; j < bitmap[i].length; j++) {
				Color c = Color.decode(Integer.toString(levelMap.getRGB(j, i)));
				switch (colorCodes.get(c)) {
				case SPIKE:
					bitmap[i][j] = ObjectList.SPIKE;
					break;
				case BLOCK:
					bitmap[i][j] = ObjectList.BLOCK;
					break;
				case EMPTY:
					bitmap[i][j] = ObjectList.EMPTY;
					break;
				case GRAVITY_PORTAL:
					bitmap[i][j] = ObjectList.GRAVITY_PORTAL;
					break;
				case PAD_BLUE:
					bitmap[i][j] = ObjectList.PAD_BLUE;
					break;
				case PAD_PINK:
					bitmap[i][j] = ObjectList.PAD_PINK;
					break;
				case PAD_YELLOW:
					bitmap[i][j] = ObjectList.PAD_YELLOW;
					break;
				case RING_BLUE:
					bitmap[i][j] = ObjectList.RING_BLUE;
					break;
				case RING_PINK:
					bitmap[i][j] = ObjectList.RING_PINK;
					break;
				case RING_YELLOW:
					bitmap[i][j] = ObjectList.RING_YELLOW;
					break;
				case SHORT_BLOCK:
					bitmap[i][j] = ObjectList.SHORT_BLOCK;
					break;
				default:
					bitmap[i][j] = ObjectList.EMPTY;
					break;
				}
			}
		}
		return bitmap;
	}
	
	public static void main(String[] args) throws IOException {
		BitmapParser bmp = new BitmapParser("level");
		ObjectList[][] bitmap = bmp.readBitmap();
		for (ObjectList[] lor : bitmap) {
			for (ObjectList obj : lor) {
				if (obj.equals(ObjectList.EMPTY)) System.out.print("     ");
				else System.out.print(obj);
			}
			System.out.println();
		}
	}

}
