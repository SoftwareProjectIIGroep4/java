package dataAccess;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import com.fasterxml.jackson.databind.ObjectMapper;

public abstract class RestRequest {	
	static ObjectMapper mapper = new ObjectMapper();
	
	static ResponseHandler<String> responseHandler = new ResponseHandler<String>() {

        @Override
        public String handleResponse(
                final HttpResponse response) throws ClientProtocolException, IOException {
            int status = response.getStatusLine().getStatusCode();
            if (status >= 200 && status < 300) {
                HttpEntity entity = response.getEntity();
                return entity != null ? EntityUtils.toString(entity) : null;
            } else {
                throw new ClientProtocolException("Unexpected response status: " + status);
            }
        }

    };
    
    static String getAllOrOne(URI source) throws IOException {
    	try (CloseableHttpClient httpClient = HttpClients.createDefault()) {        	
            HttpGet httpGet = new HttpGet(source);
            System.out.println("Executing request " + httpGet.getRequestLine());         
            
            String responseBody = httpClient.execute(httpGet, responseHandler);
            System.out.println("----------------------------------------");
            System.out.println(responseBody);                   
            return responseBody;
        }
    }
    
    static String postObject(Object object, URI source) throws URISyntaxException, IOException {		
		try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
			//Convert obj to JSON
			String objString = mapper.writeValueAsString(object);
			StringEntity requestEntity = new StringEntity(
				    objString,
				    ContentType.APPLICATION_JSON);
			
			HttpPost httpPost = new HttpPost(source) ;
			httpPost.setEntity(requestEntity);
			System.out.println("Executing request " + httpPost.getRequestLine());    
			
			String responseBody = httpClient.execute(httpPost, responseHandler);
			System.out.println("----------------------------------------");
            System.out.println(responseBody);                   
            return responseBody;
		}
	}
    
    static String putObject(Object object, URI source) throws URISyntaxException, IOException {		
		try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
			//Convert obj to JSON
			String objString = mapper.writeValueAsString(object);
			StringEntity requestEntity = new StringEntity(
				    objString,
				    ContentType.APPLICATION_JSON);
			
			HttpPut httpPut = new HttpPut(source) ;
			httpPut.setEntity(requestEntity);
			System.out.println("Executing request " + httpPut.getRequestLine());    
			
			String responseBody = httpClient.execute(httpPut, responseHandler);
			System.out.println("----------------------------------------");
            System.out.println(responseBody);                   
            return responseBody;
		}
	}

    static String deleteObject(Integer id, URI source) throws URISyntaxException, IOException {
    	try (CloseableHttpClient httpclient = HttpClients.createDefault()) {    		
            HttpDelete httpDelete = new HttpDelete(source);
            System.out.println(httpDelete.getURI());

            System.out.println("Executing request " + httpDelete.getRequestLine());

            // Create a custom response handler
            ResponseHandler<String> responseHandler = response -> {
                int status = response.getStatusLine().getStatusCode();
                if (status >= 200 && status < 300) {
                    HttpEntity entity = response.getEntity();
                    return entity != null ? EntityUtils.toString(entity) : null;
                } else {
                    throw new ClientProtocolException("Unexpected response status: " + status);
                }
            };
            String responseBody = httpclient.execute(httpDelete, responseHandler);
            System.out.println("----------------------------------------");
            System.out.println(responseBody);
            return responseBody;
        }
    }
    
    static String deleteObject(Long id, URI source) throws URISyntaxException, IOException {
    	try (CloseableHttpClient httpclient = HttpClients.createDefault()) {    		
            HttpDelete httpDelete = new HttpDelete(source);
            System.out.println(httpDelete.getURI());

            System.out.println("Executing request " + httpDelete.getRequestLine());

            // Create a custom response handler
            ResponseHandler<String> responseHandler = response -> {
                int status = response.getStatusLine().getStatusCode();
                if (status >= 200 && status < 300) {
                    HttpEntity entity = response.getEntity();
                    return entity != null ? EntityUtils.toString(entity) : null;
                } else {
                    throw new ClientProtocolException("Unexpected response status: " + status);
                }
            };
            String responseBody = httpclient.execute(httpDelete, responseHandler);
            System.out.println("----------------------------------------");
            System.out.println(responseBody);
            return responseBody;
        }
    }
}
