package dataAccess;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;

import models.Certificate;

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

	public static Certificate add(Certificate certificate) throws IOException {
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

	public static void update(Certificate certificate) throws URISyntaxException, IOException {
		putObject(certificate, new URI(Constants.CERTIFICATE_SOURCE + certificate.getCertificateID()));
	}

	public static Certificate remove(Integer ID) throws URISyntaxException, IOException {
		String JSONcert = deleteObject(ID, new URI(Constants.CERTIFICATE_SOURCE + ID));
		return mapper.readValue(JSONcert, Certificate.class);
	}
}
