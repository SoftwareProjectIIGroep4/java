package dataAccess;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import models.Employee;

//SOURCES: https://hc.apache.org/httpcomponents-client-4.5.x/httpclient/examples/org/apache/http/examples/client/ClientWithResponseHandler.java
//https://www.mkyong.com/java/jackson-2-convert-java-object-to-from-json/

public class EmployeeAccess extends RestRequest {
	
    private static ObjectMapper mapper = new ObjectMapper();
	
	
	// Get an employee by ID
	public static Employee getEmployee(Integer employeeID) {
		try {			
			String JSONEmp = getEmployees(employeeID, null, new URL(Constants.EMPLOYEE_SOURCE));
			return mapper.readValue(JSONEmp, Employee.class);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}	
	
	// Get all employees working for specified manager
	public static List<Employee> getEmployeesByManager(Integer managerID) {
		try {
			String JSONEmps = getEmployees(null, managerID, new URL(Constants.EMPLOYEE_SOURCE));
			return mapper.readValue(JSONEmps, new TypeReference<List<Employee>>(){});
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}		
	}	
	
	// Get all employees
	public static HashMap<Integer, Employee> getAllEmployees() {
		try {
			String JSONEmps = getEmployees(null, null, new URL(Constants.EMPLOYEE_SOURCE));
			return mapper.readValue(JSONEmps, new TypeReference<HashMap<Integer, Employee>>(){});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
    private static String getEmployees(Integer employeeID, Integer managerID, URL source) throws Exception {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        try {        	
            HttpGet httpget = null;
            if (employeeID == null && managerID == null) {
            	httpget = new HttpGet(source.toString());
            }
            else if (employeeID != null) {			
				httpget = new HttpGet(source.toString() + employeeID); 
			}
            else {
            	httpget = new HttpGet(source.toString() + managerID + "/manages"); 
            }
            System.out.println("Executing request " + httpget.getRequestLine());

            
            
            String responseBody = httpclient.execute(httpget, responseHandler);
            //System.out.println("----------------------------------------");
            //System.out.println(responseBody);                   
            return responseBody;
        } 
        
        catch (IOException e) {
        	System.out.println("Can't connect to the dataservice.");
        	return null;
		}	
        
        finally {
            httpclient.close();
        }
    }

}