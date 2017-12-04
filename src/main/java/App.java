import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.Date;
import java.sql.Time;
import java.util.concurrent.ExecutionException;
import dataAccess.Cache;
import dataAccess.CertificateAccess;
import dataAccess.TrainingSessionAccess;
import demos.Demo1;
import models.Address;
import models.Certificate;
import models.TrainingInfo;
import models.TrainingSession;

public class App {
	public static void main(String[] args) {
		Demo1.start();		
	}

	public static void trainingInfoTest() throws URISyntaxException, IOException, ExecutionException {
		TrainingSession session = new TrainingSession(33, 1, 6, new Date(System.currentTimeMillis()) , new Time(1510833600000L) , new Time(1510840800000L) , false);
		session.save();
		
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
		try {
			certificate.save();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}