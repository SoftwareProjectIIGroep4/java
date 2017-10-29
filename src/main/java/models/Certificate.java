package models;

import java.util.ArrayList;

//uitwerking PDF op scherm
//import com.itextpdf.text.Document;
/**
 * 
 * @author jan
 * Class for Certificate with an ID, name and image (object)
 *
 */

public class Certificate {
	
	private int certificateID;
	private String name;
	//nog uitzoeken hoe image bij te houden
	//private Image image;

	// nog Image object toevoegen
	public Certificate(int certificateID, String name) {
		this.certificateID = certificateID;
		this.name = name;
	}
	
	
	public int getCertificateID() {
		return certificateID;
	}


	public void setCertificateID(int certificateID) {
		this.certificateID = certificateID;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Certifacte: " + certificateID + "\n");
		sb.append("Name: " + name + "\n");
		return sb.toString();
	}
	/*
	//geef alle behaalde certificaten op basis van een employeeID
	public ArrayList<Certificate> getCertificateByEmployeeID (int employeeID){
		
		ArrayList<Certificate> certificates = new ArrayList<Certificate>();
		certificates = getCertificates
		return certificates;
	}
	*/
/*
	// uitwerking pdf
public static void main(String[] args) {
	
	//Document doc = new Document();
	
} */
	
	
	

}
