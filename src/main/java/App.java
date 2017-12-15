import java.io.IOException;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;
import dataAccess.TrainingInfoAccess;
import models.TrainingInfo;;

public class App {
	public static void main(String[] args) throws IOException, URISyntaxException {
		TrainingInfoByUserTest(5);
	};

	// TEST get traininginfos per user
	public static void TrainingInfoByUserTest(int i) throws IOException, URISyntaxException {
		HashMap<Integer,TrainingInfo> tr = TrainingInfoAccess.getUserTrainingInfos(i);
		for (Map.Entry<Integer, TrainingInfo> trinfo : tr.entrySet()) {
			System.out.println(trinfo.toString());
		}
	}
}
