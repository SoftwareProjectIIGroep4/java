package models;

com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)

public class Employee {
	private int employeeID;
	private String lastName;
	private String firstName;
	private String title;
	private String titleOfCourtesy;
	private String reportsTo;
	private String department;
	private String function;
	
	public Employee() {
		super();
	}
	
	public Employee(int employeeID, String lastName, String firstName, String title, String titleOfCourtesy,
			String reportsTo,String department,String function) {
		super();
		this.employeeID = employeeID;
		this.lastName = lastName;
		this.firstName = firstName;
		this.title = title;
		this.titleOfCourtesy = titleOfCourtesy;
		this.reportsTo = reportsTo;
		this.department = department;
		this.function = function;
	}
	
	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getFunction() {
		return function;
	}

	public void setFunction(String function) {
		this.function = function;
	}

	public int getEmployeeID() {
		return employeeID;
	}
	public String getLastName() {
		return lastName;
	}
	public String getFirstName() {
		return firstName;
	}
	public String getTitle() {
		return title;
	}
	public String getTitleOfCourtesy() {
		return titleOfCourtesy;
	}
	public String getReportsTo() {
		return reportsTo;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Employee ID: " + employeeID + "\n");
		sb.append("Name: " + titleOfCourtesy + " " + firstName + " " + lastName + "\n");		
		sb.append("Title: " + title + "\n");
		sb.append("Reports to: " + reportsTo + "\n");
		return sb.toString();
	}
}