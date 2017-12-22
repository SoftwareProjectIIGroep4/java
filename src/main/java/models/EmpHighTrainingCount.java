package models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class EmpHighTrainingCount {
	private Employee employee;
	private int count;		
		
	public EmpHighTrainingCount(Employee employee, int count) {
		super();
		this.employee = employee;
		this.count = count;
	}
	
	public EmpHighTrainingCount() {
		
	}
	
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
}
