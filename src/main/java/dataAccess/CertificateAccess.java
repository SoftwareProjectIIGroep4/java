package dataAccess;



import java.io.File;
import java.io.FileInputStream;


import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.List;

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

<<<<<<< HEAD
	public static Certificate addCertificate(Certificate certificate) throws IOException {
		try {
			String JSONcert = postObject(certificate, new URI(Constants.CERTIFICATE_SOURCE));
			Certificate cert = mapper.readValue(JSONcert, Certificate.class);
			Cache.certificateCache.put(certificate.getCertificateID(), cert);
			return cert;
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
=======
	public static Certificate add(Certificate certificate) throws IOException, URISyntaxException {
		String JSONcert = postObject(certificate, new URI(Constants.CERTIFICATE_SOURCE));
		return mapper.readValue(JSONcert, Certificate.class);
>>>>>>> branch 'jan' of https://github.com/SoftwareProjectII/java.git
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
		jFileChooser.setFileFilter(new FileTypeFilter(".jpg", "JPG"));
		// met meerdere files doet hij het niet, nog nakijken
		//jFileChooser.setFileFilter(new FileTypeFilter(".png", "PNG"));
		//jFileChooser.setFileFilter(new FileTypeFilter(".pdf", "PDF"));
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
	
	public byte[] ConvertFile(String fileName) {
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
	
	public void saveFile() {
		Certificate certificate = new Certificate();
		certificate.setTrainingID(1);
		certificate.setTitel("eerste certificaat");
		certificate.setPicture(ConvertFile(file.getAbsolutePath()));
		System.out.println("for testing: 2 lines");
		System.out.println(file.getAbsolutePath());
		System.out.println(ConvertFile(file.getAbsolutePath()));
		try {
			Certificate cert = CertificateAccess.addCertificate(certificate);
			if (cert != null) {
				certificate = cert;
				System.out.println("succes!");
			}
			else
				System.out.println("niet gelukt");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public static void main(String[] args) {
		CertificateAccess c = new CertificateAccess();
		File bestand = new File("testbestand");
		bestand = c.chooseFile();
		c.saveFile();
	}
	

}












