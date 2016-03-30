import java.io.FileNotFoundException;
import java.util.Map;

import org.apache.log4j.Logger;
import org.elasticsearch.client.Client;

public class Main {

	public static void main(String[] args) {

		String clusterName = "abbhave", hostName = "localhost";
		int port = 9300;
		
		final Logger logger = Logger.getLogger(Main.class);
		/*ConnectElastic ce = new ConnectElastic();
		Client client = ce.ConnectElastic(clusterName, hostName, port);
		logger.info(client.admin().cluster().prepareHealth().get());*/		
		String fileName = "//Users//abbhave//Office//Workspace//Eclipse_Workspace//Java//Elastic17//src//configuration.yaml";
		FileHelper helper = new FileHelper();
		//helper.csvToMapConverter(fileName);
		ElasticConfiguration configuration;
		try {
			configuration = ElasticConfigurationManager.getConfiguration(fileName);
			String http = configuration.getInternalConfig().getHttp();
			System.out.println(http);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//helper.readYamlConfig(fileName);
	}

}
