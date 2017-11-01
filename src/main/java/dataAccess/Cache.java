package dataAccess;

import java.util.HashMap;
import java.util.Map;

import models.Address;

public class Cache {
	
	//Regions
	//private static Map<Integer, Employee> employees;	
	private static Map<Integer, Address> Addresses = new HashMap<Integer, Address>();
	
	//Addresses
	public static Map<Integer, Address> getAddresses() {
		return Addresses;
	}
	public static void setAddresses(Map<Integer, Address> addresses) {
		Addresses = addresses;
	}
	public static void addAddress(Address address) {
		if (address != null) {
			if (address.equals(Addresses.get(address.getAddressId()))) {
				return;
			}
			Addresses.put(address.getAddressId(), address);
		}
	}
	public static void removeAddress(int id) {
		Addresses.remove(id);
	}
	public static Address getAddress(int id) {
		if (Addresses.containsKey(id)) {
			return Addresses.get(id);
		}
		else {
			return AddressAccess.getAddress(id);
		}
	}
}
