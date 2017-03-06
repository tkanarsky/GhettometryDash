import java.util.HashMap;
import java.util.Map;

public class InputManager {

	private Map<String, Boolean> actions = new HashMap<>();

	public void addInput(String name) {
		actions.put(name, false);
	}

	public boolean getInput(String name) {
		return actions.get(name).booleanValue();
	}

	public void setInput(String name, boolean pressed) {
		if (pressed != actions.get(name).booleanValue())
			actions.put(name, pressed);
	}

}
