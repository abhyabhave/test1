import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.yaml.snakeyaml.Yaml;

public class ElasticConfigurationManager {
	
	
	// read the yaml
	// create the object of ElasticConfiguration
	// return
	
	public static ElasticConfiguration getConfiguration(String file) throws FileNotFoundException {
		Yaml yaml = new Yaml();
		ElasticConfiguration configuration = yaml.loadAs(new FileInputStream(new File(file)), ElasticConfiguration.class);
		return configuration;
	}
}
