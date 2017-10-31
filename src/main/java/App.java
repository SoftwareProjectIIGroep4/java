import com.fasterxml.jackson.databind.ObjectMapper;

import dataAccess.AddressAccess;
import models.Address;

public class App {
    public String getGreeting() {
        return "Hello world.";
    }

    public static void main(String[] args) {
       Address address = new Address("Vlaams-Brabant", "loc", 1234, "strt", null, "cntr");
       try {		
		address = new ObjectMapper().readValue(AddressAccess.addAddress(address), Address.class);
		System.out.println(address);
       } catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
       }
    }
}