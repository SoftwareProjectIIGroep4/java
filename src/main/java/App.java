import java.io.IOException;
import java.net.URISyntaxException;
import java.util.concurrent.ExecutionException;
import dataAccess.AddressAccess;
import dataAccess.Cache;
import dataAccess.CertificateAccess;
import dataAccess.EmployeeAccess;
import models.Address;
import models.Certificate;

public class App {
	public static void main(String[] args) {
		// try {
		// Address address = Cache.addressCache.get(5);
		// address.setPostalCode(2000);
		// System.out.println(Cache.addressCache.get(5));
		// } catch (Exception e) {
		// e.printStackTrace();
		// }
		try {
			certTest();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void empTest() throws ExecutionException {
		System.out.println("Run 1");
		System.out.println(Cache.employeeCache.get(1));
		System.out.println("Run 2");
		System.out.println(Cache.employeeCache.get(1));
	}
	
	public static void certTest() throws IOException {
		byte[] bytes = {3,10,8,25};
		Certificate certificate = new Certificate(4, "a cert", bytes);
		System.out.println(certificate);
		CertificateAccess.addCertificate(certificate);
	}
	
	public static void demo() {
		// Nieuw address aanmaken - ZONDER ID, het veld "premise" mag null zijn.
		Address address = new Address("Vlaams-Brabant", "Brussel", 1000, "Rue de la Montagne 17", null, "Belgie");
		System.out.println("1: nieuw address");
		System.out.println(address);
		System.out.println("-------------");

		// Het gemaakte address toevoegen in de database
		// De methode addAddres() returnt een address MET een ID, van de DB gekregen.
		System.out.println("2: Address toevoegen aan de database");
		try {
			Address a = AddressAccess.addAddress(address);
			if (a != null) {
				address = a;				
			}
		} catch (IOException | URISyntaxException e) {
			e.printStackTrace();
		}
		System.out.println(address);
		System.out.println("-------------");

		// De cache is een lokale Map van de items, zoals addressen
		// Op volgende manier kan je de cache aanspreken. Als je een item opvraagt dat nog niet in de cache zit, wordt die daar in gezet.
		System.out.println("3: Address uit cache ophalen");
		try {
			System.out.println(Cache.addressCache.get(6));
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
		System.out.println("-------------");
		
		// Address updaten
		System.out.println("4: Address updaten");
		address.setCountry("France");
		try {
			AddressAccess.updateAddress(address);
		} catch (URISyntaxException | IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}		
		System.out.println("-------------");

		// Address verwijderen
		// Het address wordt ook automatisch uit de cache verwijderd.
		System.out.println("5: Address verwijderen");
		try {
			System.out.println(AddressAccess.removeAddress(address.getAddressId()));
		} catch (URISyntaxException | IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		// Geeft error; je probeert een item op te halen dat niet meer bestaat
		try {
			System.out.println(Cache.addressCache.get(address.getAddressId()));
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("-------------");
	}
}