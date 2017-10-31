package dataAccess;

import java.util.Map;

import models.Address;
import models.Employee;

public class Cache {
	
	private static Map<Integer, Employee> employees;
	
	public static Map<Integer, Employee> getEmployees() {
		if (employees == null) {			
			employees = EmployeeAccess.getAllEmployees();
		}
		return employees;
	}
	
	private static Map<Integer, Address> Addresses;
	
	public static Map<Integer, Address> getAddresses() {
		if (Addresses == null) {			
			Addresses = AddressAccess.getAllAddresses();
		}
		return Addresses;
	}	
	
}
