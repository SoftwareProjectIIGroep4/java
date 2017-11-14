package dataAccess;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;

import models.Faq;

public class FaqAccess  extends RestRequest {
	
	public static Faq getFaq(Integer faqID) {
		try {
		String JSONFaq = getAllOrOne(new URI(Constants.FAQ_SOURCE + faqID));
		Faq faq = mapper.readValue(JSONFaq, Faq.class);
		return faq;
	} catch (Exception e) {
		e.printStackTrace();
		return null;
	}

}

public static HashMap<Integer, Faq> getAllFaqs(){
	try {
		String JSONFaq = getAllOrOne (new URI(Constants.FAQ_SOURCE));
		List<Faq> faqs = mapper.readValue(JSONFaq, new TypeReference<List<Faq>>() {
		});
		
		HashMap <Integer, Faq> faqMap = new HashMap<Integer, Faq>();
		
		for (Faq f: faqs) {
			faqMap.put(f.getFaqID(), f);
		}
		return faqMap;
	} catch (Exception e) {
		e.printStackTrace();
		return null;
	}
	
}

public static Faq addFaq(Faq faq) throws IOException{
	try {
		String JSONFaq = postObject(faq, new URI(Constants.FAQ_SOURCE));
		Faq faq2 = mapper.readValue(JSONFaq, Faq.class);
		Cache.faqCache.put(faq.getFaqID(), faq2);
		return faq2;
	}catch (URISyntaxException e) {
		e.printStackTrace();
	}
	return null;
}

public static Faq updateFaq(Faq faq) {
	try {
		String JSONfaq = putObject(faq, new URI(Constants.FAQ_SOURCE + faq.getFaqID()));
		Cache.faqCache.invalidate(faq.getFaqID());
		return mapper.readValue(JSONfaq, Faq.class);
	}catch (Exception e) {
		e.printStackTrace();
	}
	return null;
}

public static Faq removeFaq(Integer ID) {
	try {
		String JSONfaq = deleteObject(ID, new URI(Constants.FAQ_SOURCE + ID));
		Cache.faqCache.invalidate(ID);
		return mapper.readValue(JSONfaq, Faq.class);
	} catch (URISyntaxException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	}
	return null;
}


}
