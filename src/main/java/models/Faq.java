package models;

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
