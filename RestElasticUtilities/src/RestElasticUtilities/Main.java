package RestElasticUtilities;

import java.io.IOException;
import java.util.Iterator;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import RestElasticUtilities.runRest;



public class Main {
	
	public static void main(String[] args) throws IOException {
		

//http://fasterxml.github.io/jackson-databind/javadoc/2.7/
				
		
		ObjectMapper om = new ObjectMapper();
		String url = "http://localhost:9200/_cat/indices";
		String requestMethod = "GET";
		String requestPropertyKey = "Content-Type";
		String requestPropertyValue = "application/json";
		JsonNode restResponse = null;
		String json = null;
		runRest.runRestCall(url, requestMethod, requestPropertyKey, requestPropertyValue);
		json = runRest.runRestCall(url, requestMethod, requestPropertyKey, requestPropertyValue);
		if(!json.equalsIgnoreCase("false")) 
			restResponse = om.readTree(json);
		if(restResponse instanceof ArrayNode) {
			ArrayNode rootRestResponse = (ArrayNode) restResponse;
			Iterator<JsonNode> iter = rootRestResponse.elements();
			while(iter.hasNext()) {
				JsonNode indexNode = iter.next();
				for(JsonNode node:indexNode) {
					System.out.println(node.fieldNames());
					System.out.println(node.textValue());
				}
			}
		}
		

	}

}
