package models;
import models.Employee;
public class Training {

	// DATAMEMBERS
	private Survey survey;
	private String name;
	private int amountDays;
	private int price;
	private String paymentInfo;
	private String examInfo;
	private Employee employee;
	private String trainingInfo;
	private int maxParticipants;
	//private Book book;
		// wait class Book
	//private FAQ FAQ
		//wait class FAQ
	// private Certificate certificate;
	//private ArrayList<TrainingSession>
// METHODS
	public Survey getSurvey() {
		return survey;
	}
	public void setSurvey(Survey survey) {
		this.survey = survey;
	}
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	public String getName() {
		return name;
	}
	public int getAmountDays() {
		return amountDays;
	}
	public int getPrice() {
		return price;
	}
	public String getPaymentInfo() {
		return paymentInfo;
	}
	public String getExamInfo() {
		return examInfo;
	}
	public String getTrainingInfo() {
		return trainingInfo;
	}
	public int getMaxParticipants() {
		return maxParticipants;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setAmountDays(int amountDays) {
		this.amountDays = amountDays;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public void setPaymentInfo(String paymentInfo) {
		this.paymentInfo = paymentInfo;
	}
	public void setExamInfo(String examInfo) {
		this.examInfo = examInfo;
	}
	public void setTrainingInfo(String trainingInfo) {
		this.trainingInfo = trainingInfo;
	}
	public void setMaxParticipants(int maxParticipants) {
		this.maxParticipants = maxParticipants;
	}
	
}

