package test;


import static org.junit.Assert.*;

import java.util.Objects;

import org.junit.Assert;
import org.junit.Test;

import models.Address;
import models.Book;
import models.Certificate;
import models.Faq;
import models.Survey;
import models.SurveyAnswer;
import models.SurveyQuestion;
import models.Teacher;
import models.TrainingInfo;
import models.TrainingSession;


public class AppTest {

	int addressId=6;
	String administrativeArea = "area51";
	String locality = "Lennik";
	int postalCode = 1750;
	String streetAddress = "Assessteenweg 161";
	String premise = "Bus A";
	String country = "België";
	
	Address adres = new Address(addressId,administrativeArea,locality,postalCode,streetAddress,premise,country);
	
	//test of getStreetAddress hier identiek is aan de streetAddress
	@Test
	public void AssertTrueTest() {
		
		Assert.assertTrue(adres.getStreetAddress().equals(streetAddress));
		
	}
	
	//stuurt true terug als de getCountry gelijk is aan de ingegeven waarde
	@Test
	public void AssertEqualsTest() {
		
		assertEquals("België",adres.getCountry());
		
	}
	
	//controle op null
	@Test
	public void AssertNullTest() {
		
		
		assertNull(adres);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}
