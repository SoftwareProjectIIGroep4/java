import java.io.IOException;
import java.util.concurrent.ExecutionException;
import dataAccess.Cache;
import dataAccess.CertificateAccess;
import demos.Demo1;
import models.Certificate;

public class App {
	public static void main(String[] args) {		
		Demo1.start();
	}

	public static void empTest() throws ExecutionException {
		System.out.println("Run 1");
		System.out.println(Cache.employeeCache.get(1));
		System.out.println("Run 2");
		System.out.println(Cache.employeeCache.get(1));
	}

	public static void certTest() throws IOException {
		byte[] bytes = { 3, 10, 8, 25 };
		Certificate certificate = new Certificate(4, "a cert", bytes);
		System.out.println(certificate);
		CertificateAccess.add(certificate);
	}
	
	
}
