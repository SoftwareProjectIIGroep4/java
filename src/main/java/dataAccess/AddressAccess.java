package dataAccess;

import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import models.Address;

public class AddressAccess implements GetRequestResponseHandler  {
	
    private static ObjectMapper mapper = new ObjectMapper();
	
	private static String rawSource = "http://localhost:56254/api/addresses/";	
	
	public static Address getAddress(Integer addressId) {
		try {			
			String JSONAdr = getAddresses(new URI(rawSource + addressId));
			return mapper.readValue(JSONAdr, Address.class);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}	
	
	public static Map<Integer, Address> getAllAddresses() {
		try {
			String JSONAdr = getAddresses(new URI(rawSource));
			List<Address> addresses = mapper.readValue(JSONAdr, new TypeReference<List<Address>>(){});
			
			Map<Integer, Address> addressesMap = new HashMap<Integer, Address>();
			
			for (Address address : addresses) {
				addressesMap.put(address.getAddressId(), address);
			}
			return addressesMap;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	private static String getAddresses(URI source) throws Exception {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        try {        	
            HttpGet httpGet = new HttpGet(source);
            System.out.println("Executing request " + httpGet.getRequestLine());         
            
            String responseBody = httpClient.execute(httpGet, responseHandler);
            System.out.println("----------------------------------------");
            System.out.println(responseBody);                   
            return responseBody;
        } 
        
        catch (IOException e) {
        	System.out.println("Can't connect to the dataservice. It is either offline, or you need to run it locally.");
        }	
        
        finally {
            httpClient.close();
        }
        return null;
    }

	public static String addAddress(Address address) throws Exception{
		CloseableHttpClient httpClient = HttpClients.createDefault();
		try {
			//Convert address obj to JSON
			String objString = mapper.writeValueAsString(address);
			StringEntity requestEntity = new StringEntity(
				    objString,
				    ContentType.APPLICATION_JSON);
			
			HttpPost httpPost = new HttpPost(new URI(rawSource)) ;
			httpPost.setEntity(requestEntity);
			System.out.println("Executing request " + httpPost.getRequestLine());    
			
			String responseBody = httpClient.execute(httpPost, responseHandler);
			System.out.println("----------------------------------------");
            System.out.println(responseBody);                   
            return responseBody;
		}
		
		catch (JsonProcessingException e) {
			System.out.println(e.getMessage());
		} 
		catch (Exception e) {
			System.out.println(e.getMessage());
		}		
		finally {
			httpClient.close();
		}
		return null;
	}
}