package RestElasticUtilities;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class runRest {
	
	public static String runRestCall(String url, String requestMethod, String requestPropertyKey, String requestPropertyValue) {
		try {
			URL link = new URL(url);
			HttpURLConnection connect = (HttpURLConnection) link.openConnection();
			connect.setRequestMethod(requestMethod);
			connect.setRequestProperty(requestPropertyKey, requestPropertyValue);
			if(connect.getResponseCode()!=200)
				throw new RuntimeException("Failed to connect. HTTP ErrorCode "+connect.getResponseCode());
			
			
			BufferedReader br = new BufferedReader(new InputStreamReader(connect.getInputStream()));
			StringBuilder sb = new StringBuilder();
			String output;
			while((output=br.readLine())!=null) {
				sb.append(output);
			}
			output = sb.toString();
			System.out.println(output);
			return output;
			 
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			return "False";
		} catch (IOException e) {
			// TODO Auto-generated catch block
			return "False";
		}
		
	}

	
}
