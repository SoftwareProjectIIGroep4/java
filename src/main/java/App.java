import java.io.IOException;
import java.util.concurrent.ExecutionException;

import dataAccess.AddressAccess;
import dataAccess.Cache;
import models.Address;

public class App {
	public static void main(String[] args) {
		// try {
		// Address address = Cache.addressCache.get(5);
		// address.setPostalCode(2000);
		// System.out.println(Cache.addressCache.get(5));
		// } catch (Exception e) {
		// e.printStackTrace();
		// }
		demo();
	}

	public static void demo() {
		// Nieuw address aanmaken - ZONDER ID, het veld "premise" mag null zijn.
		Address address = new Address("Vlaams-Brabant", "Brussel", 1000, "Rue de la Montagne 17", null, "Belgie");
		System.out.println(address);

		// Het gemaakte address toevoegen in de database
		// De methode addAddres() returnt een address MET een ID, van de DB gekregen.
		try {
			Address a = AddressAccess.addAddress(address);
			if (a != null) {
				address = a;				
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(address);

		// De cache is een lokale Map van de items, zoals addressen
		// Op volgende manier kan je de cache aanspreken. Als je een item opvraagt dat nog niet in de cache zit, wordt die daar in gezet.
		try {
			System.out.println(Cache.addressCache.get(6));
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
		
		//
		address.setCountry("France");
		AddressAccess.updateAddress(address);
		try {
			System.out.println(Cache.addressCache.get(address.getAddressId()));
		} catch (ExecutionException e) {
			e.printStackTrace();
		}

		// Address verwijderen
		// Het address wordt ook automatisch uit de cache verwijderd.
		System.out.println(AddressAccess.removeAddress(address.getAddressId()));
		// Geeft error; je probeert een item op te halen dat niet meer bestaat
		try {
			System.out.println(Cache.addressCache.get(address.getAddressId()));
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}