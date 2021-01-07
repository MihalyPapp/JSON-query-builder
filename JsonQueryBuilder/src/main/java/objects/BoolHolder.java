package objects;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BoolHolder {

	@JsonProperty("bool")
	private Bool bool;

	public BoolHolder(Bool bool) {
		this.bool = bool;
	}

	public Bool getBool() {
		return bool;
	}

}
