package ElasticSearchUtil;

import org.elasticsearch.action.admin.cluster.health.ClusterHealthResponse;
import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;

public class Main {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		//GetElasticSearchStatus status = new GetElasticSearchStatus("localhost",9300,"abbhave");
		//ESIndexUtilities ESIU = new ESIndexUtilities("localhost",9300,"abbhave");
		//ESIU.getIndex();
		GetElasticSearchStatus ess = new GetElasticSearchStatus("localhost", 9300, "abbhave");
		
	}

}
