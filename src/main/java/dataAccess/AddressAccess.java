package dataAccess;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.List;
import com.fasterxml.jackson.core.type.TypeReference;

import models.Address;

public class AddressAccess extends RestRequest  {	   
	private static String rawSource = "http://localhost:56254/api/addresses/";	
	
	
	
	public static Address getAddress(Integer addressId) {
		try {			
			String JSONAdr = getAllOrOne(new URI(rawSource + addressId));
			Address address = mapper.readValue(JSONAdr, Address.class);
			return address;		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}	
	
	public static HashMap<Integer, Address> getAllAddresses() {
		try {
			String JSONAdr = getAllOrOne(new URI(rawSource));
			List<Address> addresses = mapper.readValue(JSONAdr, new TypeReference<List<Address>>(){});
			
			HashMap<Integer, Address> addressesMap = new HashMap<Integer, Address>();
			
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
	
	public static Address addAddress(Address address) {
		try {
			String JSONAdr = postObject(address, new URI(rawSource));			
			return mapper.readValue(JSONAdr, Address.class);
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}

	public static Address updateAddress(Address address) {
		try {
			String JSONAdr = putObject(address, new URI(rawSource + address.getAddressId()));
			Cache.addressCache.invalidate(address.getAddressId());
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
			Cache.addressCache.invalidate(id);
			return mapper.readValue(JSONAdr, Address.class);
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