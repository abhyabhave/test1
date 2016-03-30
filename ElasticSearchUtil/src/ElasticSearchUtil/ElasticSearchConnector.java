package ElasticSearchUtil;

import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.ImmutableSettings;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;


public class ElasticSearchConnector implements AutoCloseable {

	static Client client;
	public static Client connectES(String hostName, int port, String clusterName) {

		System.out.println("Trying to establish Conenction......");
		try {
			
			Settings settings = ImmutableSettings.settingsBuilder().put("Cluster,name", "abbhave").build();
			client = new TransportClient(settings).addTransportAddress(new InetSocketTransportAddress("localhsot", 9300));
			System.out.println(hostName + " Connection " + port );
			System.out.println("Conncetion established!!");
			System.out.println(client.admin().cluster().prepareClusterStats().get().toString());
		} catch (Exception e) {
			System.out.println("Exception");
			e.printStackTrace();
		}
		return client;
	}

	@Override
	public void close() throws Exception {
		client.close();

	}

}
