import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class FileHelper {

	Logger logger = Logger.getLogger(FileHelper.class);

	public FileHelper() {
		// TODO Auto-generated constructor stub
	}

	public boolean checkFileExists(String fileName) {

		File file = new File(fileName);
		if (!file.exists()) {
			logger.error("The specified file does not exist " + fileName);
			logger.error("Please ensure you are providing the fully qualified path for the file");
			return false;
		} else
			return true;
	}

	

	public void readYamlConfig(String fileName) {
		String hostName, clusterName, indexName, operation;
		int port;
		if(!checkFileExists(fileName)) {
			logger.info("Did not find configuration.yaml file. Will prompt for configuraitons");
			Scanner scanner = new Scanner(System.in);
			System.out.println("Please enter the hostname for the elastic engine: ");
			hostName = scanner.next();
			System.out.println("Please provide the port for the elastic engine [Default 9300] ");
			port = scanner.nextInt();
			System.out.println("Please provide the clusterName to conenct to ");
			clusterName = scanner.next();
			System.out.println("Please provide the indexName to operate on ");
			indexName = scanner.next();
			System.out.println("Please provide the operation to run on the index [Rebuild, Append, Delete, Create]");
		}
		else{
			
			
		}	
	}

	public void csvToMapConverter(String fileName) {
		boolean fileExists = checkFileExists(fileName);
		Map<String, String> jsonMap = new HashMap<String, String>();
		FileReader reader = null;
		BufferedReader buffer = null;
		if (fileExists) {
			logger.info("Found the file. Now parsing the file");
			try {
				reader = new FileReader(fileName);
				buffer = new BufferedReader(reader);
				String line = buffer.readLine();
				List<String> headers = Arrays.asList(line.split(","));
				List<String> data = null;
				logger.info("The scanned file has " + headers.size() + " columns");
				while ((line = buffer.readLine()) != null) {
					data = Arrays.asList(line.split(","));
					for (int i = 0; i < headers.size(); i++) {
						jsonMap.put(headers.get(i), data.get(i));

					}
					MapToJsonConverter(jsonMap);
				}
			} catch (FileNotFoundException e) {
				logger.error("The specified file does not exist " + fileName);
				logger.error("Please ensure you are providing the fully qualified path for the file", e);
			} catch (IOException e) {
				logger.error("Failed reading the file", e);
			}

		}

	}

	public void MapToJsonConverter(Map<String, String> jsonMap) throws JsonProcessingException {
		try {
			String mapAsJson = new ObjectMapper().writeValueAsString(jsonMap);
			System.out.println(mapAsJson);
		} catch (JsonProcessingException e) {
			logger.error("Failed to create JSON", e);
		}
	}
}
