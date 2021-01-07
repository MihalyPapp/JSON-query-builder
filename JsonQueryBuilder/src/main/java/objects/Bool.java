package objects;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import builders.QueryBuilder.Objects;

public class Bool {

	@JsonProperty("must")
	private List<Object> musts;

	@JsonProperty("should")
	private List<Object> shoulds;

	@JsonIgnore
	private Objects lastCalled = Objects.BOOL;

	
	public Bool() {
		musts = new ArrayList<Object>();
		shoulds = new ArrayList<Object>();
	}


	public List<Object> getMusts() {
		return musts;
	}

	public List<Object> getShoulds() {
		return shoulds;
	}

	public Bool shouldMatch(String key, Object value) {
		shoulds.add(new Match(key, value));
		lastCalled = Objects.SHOULDMATCH;
		return this;
	}

	public Bool mustMatch(String key, Object value) {
		musts.add(new Match(key, value));
		lastCalled = Objects.MUSTMATCH;
		return this;
	}

	public Bool bool() {
		Bool bool = new Bool();
		switch (lastCalled) {
		case MUSTMATCH:
			musts.add(new BoolHolder(bool));
			break;
		case SHOULDMATCH:
			shoulds.add(new BoolHolder(bool));
			break;
		default:
			bool = this;
			break;
		}
		return bool;
	}

}
