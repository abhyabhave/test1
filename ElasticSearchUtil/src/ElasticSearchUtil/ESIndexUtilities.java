package ElasticSearchUtil;

import org.elasticsearch.action.admin.cluster.health.ClusterHealthResponse;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.client.Client;
import org.elasticsearch.cluster.metadata.IndexMetaData;
import org.elasticsearch.common.collect.ImmutableOpenMap;

public class ESIndexUtilities {

	String hostName, clusterName;
	int port;

	public ESIndexUtilities(String hostName, int port, String clusterName) {
		this.hostName = hostName;
		this.port = port;
		this.clusterName = clusterName;
	}

	public void getIndex() throws Exception {
		System.out.println(hostName);
		try (ElasticSearchConnector esc = new ElasticSearchConnector()) {
			Client client = esc.connectES(clusterName, port, clusterName);
			ClusterHealthResponse health = client.admin().cluster().prepareHealth().get();
			System.out.println(health.getClusterName());
			/*
			 * //GetResponse response = client.prepareGet("addressbook", "",
			 * "1").get(); //System.out.println(response.getIndex().toString());
			 * System.out.println("creating map now"); ImmutableOpenMap<String,
			 * IndexMetaData> indexToAliasesMap =
			 * client.admin().cluster().prepareState().execute()
			 * .actionGet().getState().getMetaData().getIndices();
			 * System.out.println("before loop"); if(indexToAliasesMap != null
			 * && !indexToAliasesMap.isEmpty()) { System.out.println(
			 * "Into the loop");
			 * System.out.println(indexToAliasesMap.keys().iterator().next().
			 * value); } } catch (Exception e) { // TODO Auto-generated catch
			 * block e.printStackTrace(); }
			 */
		}
	}
}
