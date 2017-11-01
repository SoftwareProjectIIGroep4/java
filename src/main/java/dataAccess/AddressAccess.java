package dataAccess;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.core.type.TypeReference;

import models.Address;

public class AddressAccess extends RestRequest  {	   
	private static String rawSource = "http://localhost:56254/api/addresses/";	
	
	
	
	public static Address getAddress(Integer addressId) {
		try {			
			String JSONAdr = getAllOrOne(new URI(rawSource + addressId));
			Address address = mapper.readValue(JSONAdr, Address.class);
			Cache.addAddress(address);
			return address;		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}	
	
	public static Map<Integer, Address> getAllAddresses() {
		try {
			String JSONAdr = getAllOrOne(new URI(rawSource));
			List<Address> addresses = mapper.readValue(JSONAdr, new TypeReference<List<Address>>(){});
			
			Map<Integer, Address> addressesMap = new HashMap<Integer, Address>();
			
			for (Address address : addresses) {
				addressesMap.put(address.getAddressId(), address);
			}			
			Cache.setAddresses(addressesMap);
			return addressesMap;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	public static Address addAddress(Address address) {
		try {
			String JSONAdr = postObject(address, new URI(rawSource));
			return mapper.readValue(JSONAdr, Address.class);
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}

	public static Address removeAddress(Integer id) {
		String JSONAdr;
		try {
			JSONAdr = deleteObject(id, new URI(rawSource + id));
			Address address = mapper.readValue(JSONAdr, Address.class);
			Cache.removeAddress(id);
			return address;
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;		
	}
}