package ElasticSearchUtil;

import org.elasticsearch.action.admin.cluster.health.ClusterHealthResponse;
import org.elasticsearch.client.Client;

public  class GetElasticSearchStatus  {

	public  GetElasticSearchStatus(String hostName, int port, String clusterName) {
		
		try
		{
			Client client = ElasticSearchConnector.connectES(hostName, port, clusterName);
			ClusterHealthResponse response =  client.admin().cluster().prepareHealth().execute().actionGet();
			System.out.println(response.getStatus());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
