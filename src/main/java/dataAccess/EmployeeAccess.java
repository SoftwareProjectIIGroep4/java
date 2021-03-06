package dataAccess;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;

import models.Address;
import models.Employee;

//SOURCES: https://hc.apache.org/httpcomponents-client-4.5.x/httpclient/examples/org/apache/http/examples/client/ClientWithResponseHandler.java
//https://www.mkyong.com/java/jackson-2-convert-java-object-to-from-json/

public class EmployeeAccess extends RestRequest {
	// Get an employee by ID
	public static Employee get(Integer employeeID) throws IOException, URISyntaxException {
		String JSONEmp = getAllOrOne(new URI(Constants.EMPLOYEE_SOURCE + employeeID));
		return mapper.readValue(JSONEmp, Employee.class);
	}
	

	public static HashMap<Integer, Employee> getBySession(Integer sessionID) throws IOException, URISyntaxException {
		String JSONEmp = getAllOrOne(new URI(Constants.TRAINING_SESSION_SOURCE + sessionID + "/employees"));
		List<Employee> employees = mapper.readValue(JSONEmp, new TypeReference<List<Employee>>() {
	});

	HashMap<Integer, Employee> employeesMap = new HashMap<Integer, Employee>();

	for (Employee employee : employees) {
		employeesMap.put(employee.getEmployeeID(), employee);
	}
	return employeesMap;
}
	
	public static Integer getUserID(Integer employeeID) throws IOException, URISyntaxException {
		String JSONUsr = getAllOrOne(new URI(Constants.EMPLOYEE_SOURCE + employeeID + "/user"));
		return mapper.readValue(JSONUsr, Integer.class);

	}

	// Get all employees working for specified manager
	public static HashMap<Integer, Employee> getByManager(Integer managerID) throws IOException, URISyntaxException {		
			String JSONEmps = getAllOrOne(new URI(Constants.EMPLOYEE_SOURCE + managerID + "/manages"));
			HashMap<Integer, Employee> employees =  mapper.readValue(JSONEmps, new TypeReference<HashMap<Integer, Employee>>() {
			});			
			return employees;
	}

	// Get all employees
	public static HashMap<Integer, Employee> getAllEmployees() throws IOException, URISyntaxException {
		String JSONEmps = getAllOrOne(new URI(Constants.EMPLOYEE_SOURCE));
		HashMap<Integer,Employee> employees =  mapper.readValue(JSONEmps, new TypeReference<HashMap<Integer, Employee>>() {
		});		
		return employees;	
	}
}