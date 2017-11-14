package dataAccess;


import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;

import models.Certificate;

public class CertificateAccess extends RestRequest{
	
	public static Certificate getCertificate (Integer certificateID) {
		try {
			String JSONCert = getAllOrOne(new URI(Constants.CERTIFICATE_SOURCE + certificateID));
			Certificate certificate = mapper.readValue(JSONCert, Certificate.class);
			return certificate;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} 	
	}
	

	
	public static HashMap<Integer, Certificate> getAllCertificates(){
		try {
			String JSONcert = getAllOrOne(new URI(Constants.CERTIFICATE_SOURCE));
			List<Certificate> certificates = mapper.readValue(JSONcert, new TypeReference<List<Certificate>>(){});
			
			HashMap<Integer, Certificate> certificateMap = new HashMap<Integer, Certificate>();
			
			for (Certificate certificate : certificates) {
				certificateMap.put(certificate.getCertificateID(), certificate);
			}
			return certificateMap;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	

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
	}
	
	
	public static Certificate updateCertificate(Certificate certificate) {
		try {
			String JSONcert = putObject(certificate, new URI(Constants.CERTIFICATE_SOURCE + certificate.getCertificateID()));
			Cache.certificateCache.invalidate(certificate.getCertificateID());
			return mapper.readValue(JSONcert,  Certificate.class);
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}

	
	public static Certificate removeCertificate(Integer ID) {
		try {
			String JSONcert = deleteObject(ID, new URI(Constants.CERTIFICATE_SOURCE + ID));
			Cache.certificateCache.invalidate(ID);
			return mapper.readValue(JSONcert, Certificate.class);
		} catch (URISyntaxException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
		return null;
	}
	
}
