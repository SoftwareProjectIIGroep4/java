package dataAccess;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.type.TypeReference;
import models.EmpHighTrainingCount;

public class StatisticsAccess extends RestRequest {
	public static List<EmpHighTrainingCount> getHighestTrainingCount(int year) throws IOException, URISyntaxException {
		String JSONEmp = getAllOrOne(new URI(Constants.STATISTICS_SOURCE + year));
		List<EmpHighTrainingCount> employees = mapper.readValue(JSONEmp, new TypeReference<List<EmpHighTrainingCount>>() {
		});
		return employees;
	}
}