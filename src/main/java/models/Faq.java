package models;

import java.io.IOException;
import java.net.URISyntaxException;

import dataAccess.Cache;
import dataAccess.FaqAccess;

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
	
}
