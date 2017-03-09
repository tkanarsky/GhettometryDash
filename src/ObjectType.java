import java.awt.Color;

public enum ObjectType {

	PLAYER("basicSquare"),
	SPIKE("spike"), 
	BLOCK("block"), 
	SHORT_BLOCK("shortblock"), 
	PAD_BLUE("bluepad"), 
	PAD_PINK("pinkpad"), 
	PAD_YELLOW("yellowpad"), 
	RING_PINK("pinkring"),
	RING_BLUE("bluering"), 
	RING_YELLOW("yellowright"), 
	EMPTY(null);

	private String imageName;
	
	ObjectType(String in)
	{
		imageName = in;
	}
	
	public String getImageName()
	{
		return imageName;
	}
	
}
