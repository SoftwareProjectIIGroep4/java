package dataAccess;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;

import models.Faq;

public class FaqAccess extends RestRequest {
	public static Faq get(Integer faqID) throws IOException, URISyntaxException {
		String JSONFaq = getAllOrOne(new URI(Constants.FAQ_SOURCE + faqID));
		Faq faq = mapper.readValue(JSONFaq, Faq.class);
		return faq;
	}

	public static HashMap<Integer, Faq> getAll() throws IOException, URISyntaxException {
		String JSONFaq = getAllOrOne(new URI(Constants.FAQ_SOURCE));
		List<Faq> faqs = mapper.readValue(JSONFaq, new TypeReference<List<Faq>>() {
		});

		HashMap<Integer, Faq> faqMap = new HashMap<Integer, Faq>();

		for (Faq f : faqs) {
			faqMap.put(f.getFaqID(), f);
		}
		return faqMap;
	}

	public static Faq add(Faq faq) throws IOException, URISyntaxException {
		String JSONFaq = postObject(faq, new URI(Constants.FAQ_SOURCE));
		return mapper.readValue(JSONFaq, Faq.class);
	}

	public static void update(Faq faq) throws URISyntaxException, IOException {
		putObject(faq, new URI(Constants.FAQ_SOURCE + faq.getFaqID()));
	}

	public static Faq remove(Integer ID) throws URISyntaxException, IOException {
		String JSONfaq = deleteObject(ID, new URI(Constants.FAQ_SOURCE + ID));
		return mapper.readValue(JSONfaq, Faq.class);
	}

}
