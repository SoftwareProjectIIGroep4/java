package models;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.concurrent.ExecutionException;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import dataAccess.Cache;
import dataAccess.FaqAccess;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Faq {
	
	private int faqID;
	private String questionFaq;
	private String answerFaq;
		
	
	public Faq() {
		super();
	}

	public Faq(String questionFaq, String answerFaq) {
		this.questionFaq = questionFaq;
		this.answerFaq = answerFaq;
	}
	
	public Faq(int faqID, String questionFaq, String answerFaq) {
		this.faqID = faqID;
		this.questionFaq = questionFaq;
		this.answerFaq = answerFaq;
	}
	
	public void save() throws URISyntaxException, IOException {		
		if (faqID != 0) {
			FaqAccess.update(this);
			Cache.faqCache.put(faqID, this);
		}
		else {
			faqID = (FaqAccess.add(this).getFaqID());
			Cache.faqCache.put(faqID, this);
		}
	}

	public void delete() throws URISyntaxException, IOException {
		if (faqID != 0) {
			FaqAccess.remove(faqID);
			Cache.faqCache.invalidate(faqID);
		}
	}
	
	public static void delete(int id) throws URISyntaxException, IOException {
		if (id != 0) {
			FaqAccess.remove(id);
			Cache.faqCache.invalidate(id);
		}
	}
	
	public int getFaqID() {
		return faqID;
	}

	public void setFaqID(int faqID) {
		this.faqID = faqID;
	}

	public String getQuestionFaq() {
		return questionFaq;
	}

	public void setQuestionFaq(String questionFaq) {
		this.questionFaq = questionFaq;
	}

	public String getAnswerFaq() {
		return answerFaq;
	}

	public void setAnswerFaq(String answerFaq) {
		this.answerFaq = answerFaq;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("FaqID: " + faqID + "\n");
		sb.append("Vraag: " + questionFaq + "\n");
		sb.append("Antwoord: " + answerFaq + "\n");
		return sb.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((answerFaq == null) ? 0 : answerFaq.hashCode());
		result = prime * result + faqID;
		result = prime * result + ((questionFaq == null) ? 0 : questionFaq.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Faq other = (Faq) obj;
		if (answerFaq == null) {
			if (other.answerFaq != null)
				return false;
		} else if (!answerFaq.equals(other.answerFaq))
			return false;
		if (faqID != other.faqID)
			return false;
		if (questionFaq == null) {
			if (other.questionFaq != null)
				return false;
		} else if (!questionFaq.equals(other.questionFaq))
			return false;
		return true;
	}
	
	public static void main(String[] args) throws URISyntaxException, IOException, ExecutionException {
	/**	Faq faqTest = new Faq("Hoe geef ik feedback?", 
				"Je kan met al je vragen, opmerkingen en problemen terecht op het algemene infonummer \n"
				+ "Je kan ook op je opmerkingen of suggesties formuleren op het evaluatieformulier \n"
				+ "dat wij op het einde van de lessen bezorgen.");
		faqTest.save();
		System.out.println(faqTest);
System.out.println("hieronder faq2");
		Faq faq2 = FaqAccess.get(faqTest.getFaqID());
		System.out.println(faq2);
		
		System.out.println(faq2.getFaqID());*/
		
		Faq faq1 = Cache.faqCache.get(2);
		System.out.println(faq1);
		faq1.setAnswerFaq("Tijdens de lessen heb je een eigen laptop met een adapter nodig. \n "
				+ "Je dient ook over een Microsoft Office-pakket beschikken op je laptop.\n "
				+ "Het cursusmateriaal krijg je tijdens de eerste les.");
		System.out.println(faq1);
		faq1.save();
		
		
		
	}
}
