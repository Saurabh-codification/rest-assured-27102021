package utils;

import java.util.Properties;

public class ConfigLoader {

    private final Properties properties;

    private static ConfigLoader configLoader;

	private ConfigLoader() {
		properties = PropertyUtils.propertyLoader("config/config.properties");
	}

	public static ConfigLoader getInstance() {
		if (configLoader == null) {
			configLoader = new ConfigLoader();
		}
		return configLoader;
	}

	public String baseUrl(){

		String prop = properties.getProperty("baseUrl");

		if(prop != null) return prop;

		else throw new RuntimeException("property not defined");

	}

	public String token(){

		String prop = properties.getProperty("token");

		if(prop != null) return prop;

		else throw new RuntimeException("property not defined");

	}

	public String reportName(){

		String prop = properties.getProperty("reportName");

		if(prop != null) return prop;

		else throw new RuntimeException("property not defined");

	}

	public Integer portNumber(){

		Integer prop = Integer.parseInt(properties.getProperty("port"));

		if(prop != null) return prop;

		else throw new RuntimeException("property not defined");

	}
    
}
