/**
 * 
 * @author Abhijit Bhave
 * @since 0.001
 */
public class ElasticConfiguration {
	
	InternalConfiguration internalConfig;
			
	String hostName;
    int port;
    String clusterName; 
    String indexName;
    String operation;
    
    public InternalConfiguration getInternalConfig() {
		return internalConfig;
	}
	public void setInternalConfig(InternalConfiguration internalConfig) {
		this.internalConfig = internalConfig;
	}
	public String getHostName() {
		return hostName;
	}
	public void setHostName(String hostName) {
		this.hostName = hostName;
	}
	public int getPort() {
		return port;
	}
	public void setPort(int port) {
		this.port = port;
	}
	public String getClusterName() {
		return clusterName;
	}
	public void setClusterName(String clusterName) {
		this.clusterName = clusterName;
	}
	public String getIndexName() {
		return indexName;
	}
	public void setIndexName(String indexName) {
		this.indexName = indexName;
	}
	public String getOperation() {
		return operation;
	}
	public void setOperation(String operation) {
		this.operation = operation;
	}
    
    

}
