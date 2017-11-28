package demos;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;

import dataAccess.Cache;
import models.Address;
import models.Employee;

public class Demo1 {
	static Scanner scanner = new Scanner(System.in);

	public static void empDemo() {
		Employee emp;

		System.out.println("Employees ophalen: run 1");
		scanner.nextLine();

		try {
			emp = Cache.employeeCache.get(1);
			System.out.println("----------------");
			System.out.println(emp);
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		scanner.nextLine();
		System.out.println("Run 2: de employee is gecached (geen get request)");
		try {
			emp = Cache.employeeCache.get(1);
			System.out.println("----------------");
			System.out.println(emp);
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		scanner.nextLine();
		System.out.println("Alle employees in de cache laden...");
		try {
			Cache.loadAllEmployees();
		} catch (IOException | URISyntaxException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		scanner.nextLine();
		System.out.println("Geen get requests meer, alles direct van de cache");
		System.out.println("----------------");
		try {
			emp = Cache.employeeCache.get(2);
			System.out.println(emp);
			scanner.nextLine();
			emp = Cache.employeeCache.get(4);
			System.out.println(emp);
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		scanner.nextLine();
	}

	public static void adrDemo() {
		Address adr;
		System.out.println("Idem voor adressen (en alle andere entiteiten)");
		System.out.println("----------------");
		System.out.println("Run 1:");

		try {
			adr = Cache.addressCache.get(5);
			System.out.println("----------------");
			System.out.println(adr);
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		scanner.nextLine();
		System.out.println("Run 2:");
		try {
			adr = Cache.addressCache.get(5);
			System.out.println("----------------");
			System.out.println(adr);
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		scanner.nextLine();
		System.out.println("Een adres toevoegen:");
		adr = new Address("Vlaams-Brabant", "Zaventem", 1930, "Stationstraat 70", "Bus A", "Belgie");
		System.out.println(adr);
		System.out.println("----------------");
		scanner.nextLine();
		try {
			adr.save();
			System.out.println("----------------");
			System.out.println("Het adres krijgt een ID");
			System.out.println(adr);
		} catch (IOException | URISyntaxException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		scanner.nextLine();
		System.out.println("Het adres zit automatisch in de cache");		
		System.out.println("----------------");
		try {
			System.out.println("Ophalen van de cache...");
			adr = Cache.addressCache.get(adr.getAddressId());
			System.out.println(adr);
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		scanner.nextLine();
		System.out.println("Een adres updaten:");
		adr.setLocality("Brussel - UPDATED");
		adr.setPostalCode(1000);
		try {
			adr.save();
			System.out.println("----------------");
			System.out.println(adr);
		} catch (URISyntaxException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		scanner.nextLine();
		System.out.println("Een adres deleten");
		try {
			adr.delete();
			System.out.println("----------------");
			System.out.println("Dit address proberen ophalen van de cache geeft een error");
			scanner.nextLine();
			adr = Cache.addressCache.get(adr.getAddressId());
		} catch (URISyntaxException | IOException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		scanner.nextLine();
	}

	public static void start() {
		System.out.println("Data access demo");
		System.out.println("----------------");

		empDemo();
		adrDemo();
	}

}
