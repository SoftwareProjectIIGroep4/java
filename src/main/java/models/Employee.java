package models;

import java.util.List;
import java.util.Map;

public class Employee {
	private int employeeID;
	private String lastName;
	private String firstName;
	private String title;
	private String titleOfCourtesy;
	private String reportsTo;
	
	private static Map<Integer, Employee> employees;
	
	public static Map<Integer, Employee> getEmployees() {
		if (employees == null) {			
			employees = ClientWithResponseHandler.getEmployees();
		}
		return employees;
	}

	public Employee() {
		super();
	}
	
	public Employee(int employeeID, String lastName, String firstName, String title, String titleOfCourtesy,
			String reportsTo) {
		super();
		this.employeeID = employeeID;
		this.lastName = lastName;
		this.firstName = firstName;
		this.title = title;
		this.titleOfCourtesy = titleOfCourtesy;
		this.reportsTo = reportsTo;
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
		// TODO Auto-generated method stub
		return sb.toString();
	}
}