import java.io.IOException;
import java.net.URISyntaxException;
import java.util.concurrent.ExecutionException;
import dataAccess.Cache;
import dataAccess.CertificateAccess;
import demos.Demo1;
import models.Certificate;
import models.TrainingInfo;

public class App {
	public static void main(String[] args) {
		// Demo1.start();

		try {
			trainingInfoTest();
		} catch (URISyntaxException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void trainingInfoTest() throws URISyntaxException, IOException {
		TrainingInfo tr = new TrainingInfo("testing", "test", 1, "test", "test", 100);
		System.out.println(tr);
	}

	public static void trainingSessionTest() throws ExecutionException {
		System.out.println(Cache.trainingSessionCache.get(1));
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
