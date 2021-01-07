package objects;

import java.util.HashMap;
import java.util.Map;

public class Match {

	
	Map<String, Object> match;

	public Match(String key, Object value) {
		match = new HashMap<String, Object>();
		match.put(key, value);
	}

	public Map<String, Object> getMatch() {
		return match;
	}

}
