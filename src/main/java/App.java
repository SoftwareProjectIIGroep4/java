import java.io.IOException;
import java.net.URISyntaxException;
import java.util.concurrent.ExecutionException;
import dataAccess.Cache;
import dataAccess.CertificateAccess;
import dataAccess.TrainingSessionAccess;
import demos.Demo1;
import models.Certificate;
import models.TrainingInfo;

public class App {
	public static void main(String[] args) {
		// Demo1.start();
		try {
			trainingInfoTest();
		} catch (URISyntaxException | IOException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void trainingInfoTest() throws URISyntaxException, IOException, ExecutionException {
		TrainingInfo trainingInfo = Cache.trainingInfoCache.get(4);
		trainingInfo.loadSessions();
		System.out.println(trainingInfo.getSessions().values().iterator().next());
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

	public static void certTest() throws IOException, URISyntaxException {
		byte[] bytes = { 3, 10, 8, 25 };
		Certificate certificate = new Certificate(4, "a cert", bytes);
		System.out.println(certificate);

		CertificateAccess.addCertificate(certificate);

	}

}