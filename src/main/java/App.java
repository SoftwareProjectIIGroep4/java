import static org.junit.Assert.assertFalse;

import java.awt.List;
import java.beans.IntrospectionException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Date;
import java.util.Map;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutionException;

import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.books.Books;

import dataAccess.Cache;
import dataAccess.CertificateAccess;
import dataAccess.ClientCredentials;
import dataAccess.GoogleBooksAPI;
import dataAccess.TrainingSessionAccess;
import demos.Demo1;
import models.Address;
import models.Book;
import models.Certificate;
import models.LogFileHelper;
import models.Token;
import models.TrainingInfo;
import models.TrainingSession;
import models.Login;
import models.Survey;
import models.SurveyQuestion;;

public class App {
	 public static void main(String[] args) throws IOException, URISyntaxException {
	
			 Cache.loadAllTrainingSessions();
			ConcurrentMap<Integer, TrainingSession> listTrainingssessions=dataAccess.Cache.trainingSessionCache.asMap();
			for (Map.Entry<Integer, TrainingSession>  entry : listTrainingssessions.entrySet()) {
				
				
				System.out.println(entry.getValue().getDate());

	}
		 
	 }


	public static void trainingInfoTest() throws URISyntaxException, IOException, ExecutionException {

		TrainingSession session = new TrainingSession(33, 1, 6, new Date(System.currentTimeMillis()) , new Time(1510833600000L) , new Time(1510840800000L) , false, 342);
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

	public static void certTestRuben() throws IOException {
		LogFileHelper.log("testuser", "testactie7");
		byte[] bytes = { 3, 10, 8, 25 };
		Certificate certificate = new Certificate(4, "a cert", bytes);
		System.out.println(certificate);
		
	}
}

