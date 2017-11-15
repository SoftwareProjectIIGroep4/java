package models;
/** out of comments plaatsen bij gebruik PDF
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;


import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.List;
import com.itextpdf.layout.element.Paragraph;

/**
 * 
 * @author jan
 * Class for Certificate with an ID, name and image (object)
 *
 */
//test test
public class Certificate {
	
	private int certificateID;
	private int trainingID;
	private String titel;
	private byte[] picture;
	
	public Certificate() {
		super();
	}
	 
	public Certificate(int certificateID, int trainingID, String titel, byte[] picture) {
		super();
		this.certificateID = certificateID;
		this.trainingID = trainingID;
		this.titel = titel;
		this.picture = picture;
	}
	
	public Certificate(int trainingID, String titel, byte[] picture) {
		super();
		this.trainingID = trainingID;
		this.titel = titel;
		this.picture = picture;
	}
	
/**
// nodig om pdf te maken
	public Certificate() {
		// TODO Auto-generated constructor stub
	}
*/
	public int getTrainingID() {
		return trainingID;
	}


	public void setTrainingID(int trainingID) {
		this.trainingID = trainingID;
	}


	public String getTitel() {
		return titel;
	}


	public void setTitel(String titel) {
		this.titel = titel;
	}


	public byte[] getPicture() {
		return picture;
	}


	public void setPicture(byte[] picture) {
		this.picture = picture;
	}


	public int getCertificateID() {
		return certificateID;
	}


	public void setCertificateID(int certificateID) {
		this.certificateID = certificateID;
	}


	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Certifacte: " + certificateID + "\n");
		sb.append("TrainingID: " + trainingID + "\n");
		sb.append("Titel: " + titel + "\n");
		return sb.toString();
	}

	/**
	// uitwerking pdf (er moet hierboven public Certificate() zijn om te laten werken!
	// sources: https://www.tutorialspoint.com/itext/index.htm
	
	/**
	 * DESTPDF is string met path+naam waar we aangemaakt PDF-bestand bewaren
	 
	public static final String DESTPDF ="results/helloworld.pdf";
	
	//to make PDF-file
	public static void main(String[] args) throws IOException{
	
	File file = new File(DESTPDF);
	file.getParentFile().mkdirs();
	new Certificate().createPDF(DESTPDF);  
		
	
} 
/**
 * 
 * @param destination + name of created PDF
 * @throws IOException
 
	
public void createPDF(String dest) throws IOException {
	//initialize PDF Writer
	FileOutputStream fos = new FileOutputStream(dest);
	PdfWriter writer = new PdfWriter(fos);
	//initialize PDFDocument
	PdfDocument pdf = new PdfDocument(writer);
	//initialize document
	Document doc = new Document(pdf);
	// add paragraph to document
	doc.add(new Paragraph ("Hello World!"));
	
	String string1 = "Lorem ipsum dolor sit amet, consectetur adipisicing elit. Eligendi non quis exercitationem culpa nesciunt nihil aut nostrum explicabo reprehenderit optio amet ab temporibus asperiores quasi cupiditate. Voluptatum ducimus voluptates voluptas?";
	String string2 = "Lorem ipsum dolor sit amet, consectetur adipisicing elit. Eligendi non quis exercitationem culpa nesciunt nihil aut nostrum explicabo reprehenderit optio amet ab temporibus asperiores quasi cupiditate. Voluptatum ducimus voluptates voluptas?";
	Paragraph par1 = new Paragraph(string1);
	Paragraph par2 = new Paragraph(string2);
	
	doc.add(par1);
	doc.add(par2);
	// initialize list
	List lijst = new List();
	// add listItem to List
	lijst.add("1e lijstitem");
	lijst.add("2e lijstitem");
	lijst.add("3e lijstitem");
	lijst.add("5e lijstitem");
	//add List to Document
	doc.add(lijst);
	
	//creating imageDataObject
	String imagefile = "results/lama.jpg";
	ImageData fotodata = ImageDataFactory.create(imagefile);
	//creating imageObject
	Image foto = new Image(fotodata);
	// add image to document, AutoScale false
	doc.add(foto.setAutoScale(false));
	
	//close document
	doc.close();
	// print action executed
	System.out.println("PDF-document " + DESTPDF + " created");
}
	*/
	
	

}
