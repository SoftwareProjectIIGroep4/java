package dataAccess;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import models.Settings;

public class SettingsAccess extends RestRequest {
	
	public static Settings get() throws IOException, URISyntaxException {
		String JSONAdr = getAllOrOne(new URI(Constants.SETTINGS_SOURCE + 1));
		Settings settings = mapper.readValue(JSONAdr, Settings.class);
		return settings;
	}

	public static void update(Settings settings) throws URISyntaxException, IOException {
		putObject(settings, new URI(Constants.SETTINGS_SOURCE + 1));
	}
}