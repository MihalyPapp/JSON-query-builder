package builders;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

import objects.Bool;

@JsonRootName(value = "query")
public class QueryBuilder {

	@JsonProperty("bool")
	private Bool bool;

	public QueryBuilder() {
		bool = new Bool();
	}
	
	public Bool getBool() {
		return bool;
	}
		
	public Bool bool() {
		return bool;
	}
	
	public enum Objects {
		MUSTMATCH, SHOULDMATCH, BOOL
	}
}
