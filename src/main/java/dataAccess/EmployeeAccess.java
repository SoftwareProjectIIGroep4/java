package dataAccess;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import models.Employee;

//SOURCES: https://hc.apache.org/httpcomponents-client-4.5.x/httpclient/examples/org/apache/http/examples/client/ClientWithResponseHandler.java
//https://www.mkyong.com/java/jackson-2-convert-java-object-to-from-json/

public class EmployeeAccess {
	
	//Handles the REST request response
	private static ResponseHandler<String> responseHandler = new ResponseHandler<String>() {

        @Override
        public String handleResponse(
                final HttpResponse response) throws ClientProtocolException, IOException {
            int status = response.getStatusLine().getStatusCode();
            if (status >= 200 && status < 300) {
                HttpEntity entity = response.getEntity();
                return entity != null ? EntityUtils.toString(entity) : null;
            } else {
                throw new ClientProtocolException("Unexpected response status: " + status);
            }
        }

    };
	
    // API endpoint -- CHANGE the port if needed when running the dataservice locally
	private static String rawSource = "http://localhost:56254/api/employees/";
	
	private static ObjectMapper mapper = new ObjectMapper();
	
	// Get an employee by ID
	public static Employee getEmployee(Integer employeeID) {
		try {			
			String JSONEmp = getEmployees(employeeID, null, new URL(rawSource));
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
			String JSONEmps = getEmployees(null, managerID, new URL(rawSource + "m"));
			return mapper.readValue(JSONEmps, new TypeReference<List<Employee>>(){});
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}		
	}	
	
	// Get all employees
	public static Map<Integer, Employee> getEmployees() {
		try {
			String JSONEmps = getEmployees(null, null, new URL(rawSource));
			return mapper.readValue(JSONEmps, new TypeReference<Map<Integer, Employee>>(){});
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
            	httpget = new HttpGet(source.toString() + managerID); 
            }
            System.out.println("Executing request " + httpget.getRequestLine());

            
            
            String responseBody = httpclient.execute(httpget, responseHandler);
            System.out.println("----------------------------------------");
            System.out.println(responseBody);                   
            return responseBody;
        } 
        
        catch (IOException e) {
        	System.out.println("Can't connect to the dataservice. It is either offline, or you need to run it locally.");
        	return null;
		}	
        
        finally {
            httpclient.close();
        }
    }

}