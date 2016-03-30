package json;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.JsonToken;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.node.ArrayNode;

public class json {

	public static void main(String[] args) throws JsonProcessingException, FileNotFoundException, IOException {
		// TODO Auto-generated method stub

		
		FileInputStream fis = new FileInputStream("serveroutput.json");
		JsonParser jp = new JsonFactory().createJsonParser(fis);
		jp.enableFeature(JsonParser.Feature.ALLOW_COMMENTS);
		while(!jp.isClosed()){
			JsonToken token = jp.nextToken();
			System.out.println(token.getClass());
			//System.out.println(token);
			//System.out.println(token.asByteArray());
		}
		
		
	}
}
