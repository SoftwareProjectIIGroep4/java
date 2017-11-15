package dataAccess;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.List;
import com.fasterxml.jackson.core.type.TypeReference;

import models.Address;

public class AddressAccess extends RestRequest {
	public static Address getAddress(Integer addressId) throws IOException, URISyntaxException {
		String JSONAdr = getAllOrOne(new URI(Constants.ADDRESS_SOURCE + addressId));
		Address address = mapper.readValue(JSONAdr, Address.class);
		return address;
	}

	public static HashMap<Integer, Address> getAllAddresses() throws IOException, URISyntaxException {
		String JSONAdr = getAllOrOne(new URI(Constants.ADDRESS_SOURCE));
		List<Address> addresses = mapper.readValue(JSONAdr, new TypeReference<List<Address>>() {
		});

		HashMap<Integer, Address> addressesMap = new HashMap<Integer, Address>();

		for (Address address : addresses) {
			addressesMap.put(address.getAddressId(), address);
		}
		return addressesMap;

	}

	public static Address addAddress(Address address) throws IOException, URISyntaxException {
		String JSONAdr;
		JSONAdr = postObject(address, new URI(Constants.ADDRESS_SOURCE));
		Address adr = mapper.readValue(JSONAdr, Address.class);
		Cache.addressCache.put(adr.getAddressId(), adr);
		return adr;
	}

	public static void updateAddress(Address address) throws URISyntaxException, IOException {
		putObject(address, new URI(Constants.ADDRESS_SOURCE + address.getAddressId()));
		Cache.addressCache.invalidate(address.getAddressId());
	}

	public static Address removeAddress(Integer id) throws URISyntaxException, IOException {
		String JSONAdr;
		JSONAdr = deleteObject(id, new URI(Constants.ADDRESS_SOURCE + id));
		Cache.addressCache.invalidate(id);
		return mapper.readValue(JSONAdr, Address.class);
	}
}