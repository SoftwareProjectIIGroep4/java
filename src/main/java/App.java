import dataAccess.Employees;
import models.Address;

public class App {
    public static void main(String[] args) {
    	Address address = new Address(Employees.getAddress(7));
    	address.setCountry("France");
    	System.out.println(Employees.getAddress(7));
    	Employees.addAddress(address);
    	System.out.println(Employees.getAddress(7));
    }
}