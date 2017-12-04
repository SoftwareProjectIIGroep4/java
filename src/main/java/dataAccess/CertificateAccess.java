package dataAccess;



import java.awt.image.ImageFilter;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;


import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ExecutionException;

import javax.swing.JFileChooser;

import com.fasterxml.jackson.core.type.TypeReference;

import models.Certificate;
import models.FileTypeFilter;

public class CertificateAccess extends RestRequest {
	public static Certificate get(Integer certificateID) throws IOException, URISyntaxException {
		String JSONCert = getAllOrOne(new URI(Constants.CERTIFICATE_SOURCE + certificateID));
		Certificate certificate = mapper.readValue(JSONCert, Certificate.class);
		return certificate;
	}

	public static HashMap<Integer, Certificate> getAll() throws IOException, URISyntaxException {
		String JSONcert = getAllOrOne(new URI(Constants.CERTIFICATE_SOURCE));
		List<Certificate> certificates = mapper.readValue(JSONcert, new TypeReference<List<Certificate>>() {
		});

		HashMap<Integer, Certificate> certificateMap = new HashMap<Integer, Certificate>();

		for (Certificate certificate : certificates) {
			certificateMap.put(certificate.getCertificateID(), certificate);
		}
		return certificateMap;
	}

	public static Certificate add(Certificate certificate) throws IOException, URISyntaxException {
		String JSONcert = postObject(certificate, new URI(Constants.CERTIFICATE_SOURCE));
		return mapper.readValue(JSONcert, Certificate.class);
	}
	

	public static void update(Certificate certificate) throws URISyntaxException, IOException {
		putObject(certificate, new URI(Constants.CERTIFICATE_SOURCE + certificate.getCertificateID()));
	}

	public static Certificate remove(Integer ID) throws URISyntaxException, IOException {
		String JSONcert = deleteObject(ID, new URI(Constants.CERTIFICATE_SOURCE + ID));
		return mapper.readValue(JSONcert, Certificate.class);
	}
	
	private File file;
	
	public File chooseFile() {
		JFileChooser jFileChooser = new JFileChooser();
		jFileChooser.setDialogTitle("Select your Certificate");
		jFileChooser.setMultiSelectionEnabled(false);
		
		//chooser.setAcceptAllFileFilterUsed(false); als je geen all files wilt kiezen!
		// met meerdere files doet hij het niet, nog nakijken
		jFileChooser.setFileFilter(new FileTypeFilter(".png", "PNG"));
		jFileChooser.setFileFilter(new FileTypeFilter(".pdf", "PDF"));
		jFileChooser.setFileFilter(new FileTypeFilter(".jpg", "JPG"));

		int result = jFileChooser.showOpenDialog(null);
		if (result == JFileChooser.APPROVE_OPTION) {
			file = jFileChooser.getSelectedFile();
			// return file wegdoen en onderaan ook want void functie van maken
			System.out.println("file gekozen gelukt");
			System.out.println(file);
			return file;
			// private JLabel lblLabelPhoto; buiten de functie te declareren in je JFrameMain.java!
			//lblLabelPhoto.setIcon(new ImageIcon(file.getAbsolutePath()));
		}
		return null;
	}
	
	public static byte[] ConvertFile(String fileName) {
		FileInputStream fileInputStream = null;
		File file = new File(fileName);
		byte[] bFile = new byte[(int) file.length()];
		try {
			fileInputStream = new FileInputStream(file);
			fileInputStream.read(bFile);
			fileInputStream.close();
		} catch (Exception e) {
			bFile = null;
		}
		return bFile;
	}
	
	/**public class ContentToByteArrayExample
	{
	   public static void main(String[] args)
	   {
	      Path path = Paths.get("C:/temp/test.txt");
	      byte[] data = Files.readAllBytes(path);
	   }
	} 
	 * @throws IOException */
	
	//for testing
	public void saveFile(File f) throws URISyntaxException, IOException {
		Certificate certificate = new Certificate();
		certificate.setTrainingID(4);
		certificate.setTitel("eerste certificaat");
		certificate.setPicture(ConvertFile(f.getAbsolutePath()));		
		//byte[] bytes = { 3, 10, 8, 25 };
		//certificate.setPicture(bytes);
		System.out.println("for testing: 3 lines");
		System.out.println(f.getAbsolutePath());
		System.out.println(ConvertFile(f.getAbsolutePath()));
		System.out.println(certificate);
		//System.out.println(bytes);
		try {
			certificate.save();
			//Certificate cert = CertificateAccess.add(certificate);
			//if (cert != null) {
			//	certificate = cert;
				System.out.println("succes!");
			//}
			//else
			//	System.out.println("niet gelukt");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) throws URISyntaxException, IOException {
		CertificateAccess cA = new CertificateAccess();
		File bestand = null;
		Certificate certificate = new Certificate();
		certificate.setTrainingID(4);
		certificate.setTitel("eerste certificaat");
		bestand = cA.chooseFile();
		certificate.setPicture(ConvertFile(bestand.getAbsolutePath()));
		 
		//cA.saveFile(bestand); 
		
		try {
			certificate.save();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Certificate certZoek = new Certificate();
		try {
			certZoek = Cache.certificateCache.get(1);
			if (certZoek == null) {
				System.out.println("Kan het gevraagde certificaat niet vinden");
			}
			else
				System.out.println(certZoek.getTitel());
			
			// private JLabel lblLabelPhoto; buiten de functie te declareren in je JFrameMain.java!
			// lblLabelPhoto.setIcon(new ImageIcon(certZoek.getPicture()));
				
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	

}












