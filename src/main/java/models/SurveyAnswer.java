package models;
public class SurveyAnswer {
//DATAMEMBRS
	private int AnswerID;
	private String answer=null;
	private int answerScore,maxScore,minScore;
	
//METHODS
	public SurveyAnswer(int answerID, String answer) {
		super();
		AnswerID = answerID;
		this.answer = answer;
	}
	public SurveyAnswer( String answer) {
		//gebruiken voor antwoorden met textuele value
		super();
		this.answer = answer;
	}
	public SurveyAnswer( int answerScore, int maxScore, int minScore) {
		// gebruiken voor antwoorden met numerieke value
		super();
		this.answerScore = answerScore;
		this.maxScore=maxScore;
		this.minScore=minScore;
	}
	public int getAnswerID() {
		return AnswerID;
	}
	public void setAnswerID(int answerID) {
		AnswerID = answerID;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public int getAnswerScore() {
		return answerScore;
	}
	public void setAnswerScore(int answerScore) {
		this.answerScore = answerScore;
	}
	public int getMaxScore() {
		return maxScore;
	}
	public void setMaxScore(int maxScore) {
		this.maxScore = maxScore;
	}
	public int getMinScore() {
		return minScore;
	}
	public void setMinScore(int minScore) {
		this.minScore = minScore;
	}
	@Override
	public String toString() {
		StringBuilder sb=new StringBuilder();
		if (answer==null) {
			//dit wil zeggen dat het antwoord in numerieke vorm is
			sb.append("max: "+maxScore+"min: "+minScore+"antwoord: "+answer+"\n");
		}
		else {
			sb.append("antwoord: "+answer+"/n");
		}
		
		return sb.toString();
	}
	
	
	
}
