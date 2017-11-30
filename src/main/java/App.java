import static org.junit.Assert.assertFalse;

import java.beans.IntrospectionException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.Date;
import java.sql.Time;
import java.util.concurrent.ExecutionException;
import dataAccess.Cache;
import dataAccess.CertificateAccess;
import dataAccess.TrainingSessionAccess;
import demos.Demo1;
import models.Certificate;
import models.LogFileHelper;
import models.TrainingInfo;
import models.TrainingSession;

public class App {
	public static void main(String[] args) throws IOException {
		// Demo1.start();
		LogFileHelper l = new LogFileHelper ( "c:/users/public/test.txt");
		LogFileHelper.log("testuser", "testactie");
		
	}

	public static void trainingInfoTest() throws URISyntaxException, IOException, ExecutionException {
		LogFileHelper.log("testuser", "testactie2");
		TrainingSession session = new TrainingSession(33, 1, 6, new Date(System.currentTimeMillis()) , new Time(1510833600000L) , new Time(1510840800000L) , false);
		session.save();
		
	}

	public static void trainingSessionTest() throws ExecutionException {
		LogFileHelper.log("testuser", "testactie3");
		System.out.println(Cache.trainingSessionCache.get(1));
	}
	public static void SurveyQTtest() throws ExecutionException {
		LogFileHelper.log("testuser", "testactie4");
		System.out.println("Run 1");
		System.out.println(Cache.surveyQuestionCache.get(1));
		System.out.println("Run 2");
		System.out.println(Cache.surveyQuestionCache.get(1));
	}
	public static void makeNewSurveyTest() throws ExecutionException {
		LogFileHelper.log("testuser", "testactie5");
		System.out.println("Make a new Survey");
		System.out.println("");
		
	}
	

	public static void empTest() throws ExecutionException {
		LogFileHelper.log("testuser", "testactie6");
		System.out.println("Run 1");
		System.out.println(Cache.employeeCache.get(1));
		System.out.println("Run 2");
		System.out.println(Cache.employeeCache.get(1));
	}

	public static void certTest() throws IOException {
		LogFileHelper.log("testuser", "testactie7");
		byte[] bytes = { 3, 10, 8, 25 };
		Certificate certificate = new Certificate(4, "a cert", bytes);
		System.out.println(certificate);
		
	}
}
