import dataAccess.AddressAccess;
import dataAccess.Cache;

public class App {
    public String getGreeting() {
        return "Hello world.";
    }

    public static void main(String[] args) {      
       System.out.println(AddressAccess.removeAddress(9));
       System.out.println("---------------------------");
       Cache.getAddress(9);
       System.out.println("hey");
//       try {		
//    	 address.saveAddress();
//		//address = new ObjectMapper().readValue(AddressAccess.postAddress(address), Address.class);
//		System.out.println(address);
//       } catch (Exception e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//       }
    }
}