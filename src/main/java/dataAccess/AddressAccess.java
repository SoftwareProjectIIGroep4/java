package dataAccess;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import models.Address;

public class AddressAccess implements GetRequestResponseHandler {
	
    private static ObjectMapper mapper = new ObjectMapper();
	
	private static String rawSource = "http://localhost:56254/api/addresses/";	
	
	public static Address getAddress(Integer addressId) {
		try {			
			String JSONAdr = getAddresses(addressId, new URL(rawSource));
			return mapper.readValue(JSONAdr, Address.class);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}	
	
	public static Map<Integer, Address> getAllAddresses() {
		try {
			String JSONAdr = getAddresses(null, new URL(rawSource));
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
	
	private static String getAddresses(Integer addressId,URL source) throws Exception {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        try {        	
            HttpGet httpget = null;
            if (addressId == null) {
            	httpget = new HttpGet(source.toString());
            }
            else {			
				httpget = new HttpGet(source.toString() + addressId); 
			}
            System.out.println("Executing request " + httpget.getRequestLine());

            
            
            String responseBody = httpclient.execute(httpget, responseHandler);
            System.out.println("----------------------------------------");
            System.out.println(responseBody);                   
            return responseBody;
        } 
        
        catch (IOException e) {
        	System.out.println("Can't connect to the dataservice. It is either offline, or you need to run it locally.");
        	return null;
		}	
        
        finally {
            httpclient.close();
        }
    }
}
