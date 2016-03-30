import org.apache.log4j.Logger;
import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.ImmutableSettings;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;

public class ConnectElastic {
	
	
	@SuppressWarnings({ "finally", "resource" })
	
	public Client ConnectElastic(String clusterName, String hostName, int port) {
		Logger logger = Logger.getLogger(ConnectElastic.class);
		Settings settings = ImmutableSettings.settingsBuilder().put("cluster.name", clusterName).build();
		logger.info("Creating a connection with Cluster "+clusterName+ " On host "+hostName+ " And port "+port);
		Client client = null;
		try {
			client = new TransportClient(settings).addTransportAddress(new InetSocketTransportAddress(hostName,9300));	
			logger.info("Connected to the Elastic Cluster "+clusterName);
		}
		catch(Exception e) {
			logger.error("Could not connect to the instance of the Elastic Host", e);
		}
		finally {
			return client;	
		}
		
	}

}
