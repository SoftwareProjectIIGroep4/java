import static org.junit.Assert.assertFalse;

import java.beans.IntrospectionException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.Date;
import java.sql.Time;
import java.util.concurrent.ExecutionException;

import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.books.Books;

import dataAccess.Cache;
import dataAccess.CertificateAccess;
import dataAccess.TrainingSessionAccess;
import demos.Demo1;
import models.Book;
import models.Certificate;
import models.LogFileHelper;
import models.TrainingInfo;
import models.TrainingSession;
import models.ClientCredentials;

public class App {
	  public static void main(String[] args) {
		    JsonFactory jsonFactory = JacksonFactory.getDefaultInstance();
		    try {
		      // Verify command line parameters.
		    /* if (args.length == 0) {
		        System.err.println("Usage: BooksSample [--author|--isbn|--title] \"<query>\"");
		        System.exit(1);
		      }*/
		      // Parse command line parameters into a query.
		      // Query format: "[<author|isbn|intitle>:]<query>"
		      String prefix = null;
		      String query = "Potter";
		      for (String arg : args) {
		        if ("--author".equals(arg)) {
		          prefix = "inauthor:";
		        } else if ("--isbn".equals(arg)) {
		          prefix = "isbn:";
		        } else if ("--title".equals(arg)) {
		          prefix = "intitle:";
		        } else if (arg.startsWith("--")) {
		          System.err.println("Unknown argument: " + arg);
		          System.exit(1);
		        } else {
		          query = arg;
		        }
		      }
		      if (prefix != null) {
		        query = prefix + query;
		      }
		      try {
		       Book.queryGoogleBooks(jsonFactory, query);
		        // Success!
		        return;
		      } catch (IOException e) {
		        System.err.println(e.getMessage());
		      }
		    } catch (Throwable t) {
		      t.printStackTrace();
		    }
		    System.exit(0);
		  };
	

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
