import dataAccess.Cache;
import models.Address;

public class App {
	public static void main(String[] args) {
		try {		
			Address address = Cache.addressCache.get(5);
			address.setPostalCode(2000);
			System.out.println(Cache.addressCache.get(5));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}