package dataAccess;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.List;
import com.fasterxml.jackson.core.type.TypeReference;

import models.Address;

public class AddressAccess extends RestRequest {
	public static Address get(Integer addressId) throws IOException, URISyntaxException {
		String JSONAdr = getAllOrOne(new URI(Constants.ADDRESS_SOURCE + addressId));
		Address address = mapper.readValue(JSONAdr, Address.class);
		return address;
	}

	public static HashMap<Integer, Address> getAll() throws IOException, URISyntaxException {
		String JSONAdr = getAllOrOne(new URI(Constants.ADDRESS_SOURCE));
		List<Address> addresses = mapper.readValue(JSONAdr, new TypeReference<List<Address>>() {
		});

		HashMap<Integer, Address> addressesMap = new HashMap<Integer, Address>();

		for (Address address : addresses) {
			addressesMap.put(address.getAddressId(), address);
		}
		return addressesMap;
	}

	public static Address add(Address address) throws IOException, URISyntaxException {
		String JSONAdr = postObject(address, new URI(Constants.ADDRESS_SOURCE));
		return mapper.readValue(JSONAdr, Address.class);
	}

	public static void update(Address address) throws URISyntaxException, IOException {
		putObject(address, new URI(Constants.ADDRESS_SOURCE + address.getAddressId()));
	}

	public static Address remove(Integer id) throws URISyntaxException, IOException {
		String JSONAdr = deleteObject(id, new URI(Constants.ADDRESS_SOURCE + id));
		return mapper.readValue(JSONAdr, Address.class);
	}
}