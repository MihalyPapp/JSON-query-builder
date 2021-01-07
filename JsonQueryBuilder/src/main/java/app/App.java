package app;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import builders.QueryBuilder;

public class App {

	public static void main(String[] args) {
		ObjectMapper mapper = new ObjectMapper();

		QueryBuilder queryBuilder1 = new QueryBuilder();
		QueryBuilder queryBuilder2 = new QueryBuilder();
		
		queryBuilder1.bool().mustMatch("item", "Milk").mustMatch("item_type", "Dairy");
		queryBuilder1.bool().shouldMatch("product_location", "New Mexico").shouldMatch("warehouse_number", 37);
		
		queryBuilder2.bool().shouldMatch("lot_number", 307).bool().mustMatch("expiry_date", "Jan 2020");
		
				
		try {
			String jsonInString1 = mapper.enable(SerializationFeature.WRAP_ROOT_VALUE)
					.setSerializationInclusion(Include.NON_NULL)
					.setSerializationInclusion(Include.NON_EMPTY)
					.writerWithDefaultPrettyPrinter().writeValueAsString(queryBuilder1);
			
			String jsonInString2 = mapper.enable(SerializationFeature.WRAP_ROOT_VALUE)
					.setSerializationInclusion(Include.NON_NULL)
					.setSerializationInclusion(Include.NON_EMPTY)
					.writerWithDefaultPrettyPrinter().writeValueAsString(queryBuilder2);
			
			System.out.println(jsonInString1);
			System.out.println(jsonInString2);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
	}

}
