package WebseiteConfig;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;

import httpServerConfig.Configuration;
import httpServerConfig.ConfigurationManager;
import httpServerConfig.HttpConfigurationException;
import util.Json;

public class WebsiteConfigManager {
	private static WebsiteConfigManager myConfigurationManager;
	private static Configuration myCurrentConfiguration;
	
	private WebsiteConfigManager() {
		// TODO Auto-generated constructor stub
	}
	
	public static WebsiteConfigManager getInstance() {
		if(myConfigurationManager == null) 
			myConfigurationManager = new WebsiteConfigManager();
			return myConfigurationManager;
		
	}
	public void loadConfigurationFile (String filePath) {
		FileReader fileReader = null;
		try {
			fileReader = new FileReader(filePath);
			
		} catch (FileNotFoundException e) {
			throw new HttpConfigurationException(e);
		}
		StringBuffer sb = new StringBuffer();
		int i;
		try {
			while( ( i = fileReader.read()) != -1) {
				sb.append((char)i);
			}
		} catch (IOException e) {
			throw new HttpConfigurationException(e);
		}
		JsonNode conf;
		try {
			conf = Json.parse(sb.toString());
		} catch (IOException e) {
			throw new HttpConfigurationException("Error parsing the Configuration File", e);
		}
		try {
			myCurrentConfiguration = Json.fromJson(conf, Configuration.class);
		} catch (JsonProcessingException e) {
			throw new HttpConfigurationException("Error parsing the Configuration file, internal", e);
		}
		
		try {
			fileReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
}
