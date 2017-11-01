package dataAccess;

import java.util.HashMap;
import models.Address;

public class Employees {
	
	private static HashMap<Integer, Address> Addresses = new HashMap<Integer, Address>();
	
	//Addresses
	public static HashMap<Integer, Address> getAddresses() {		
		return Addresses;
	}
	public static void setAddresses(HashMap<Integer, Address> addresses) {
		Addresses = addresses;
	}
	public static void addAddress(Address address) {
		if (address == null) {
			System.out.println("Address == null");
			return;
		}
		if (Addresses.containsKey(address.getAddressId())) {
			if (address.equals(Addresses.get(address.getAddressId()))) {
				System.out.println("Address == existing");
				return;
			}
			System.out.println("Putting address");
			AddressAccess.updateAddress(address);
		}
		System.out.println("Adding address");
		Addresses.put(address.getAddressId(), address);	
	}
	public static void removeAddress(int id) {
		Addresses.remove(id);
	}
	public static Address getAddress(int id) {
		if (Addresses.containsKey(id)) {
			return new Address(Addresses.get(id));
		}
		else {
			return new Address(AddressAccess.getAddress(id));
		}
	}
}
