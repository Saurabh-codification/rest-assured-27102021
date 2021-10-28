package utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyUtils {

    public static Properties propertyLoader(String filename) {

        Properties properties = new Properties();

        BufferedReader reader;
		
		try {
			reader = new BufferedReader(new java.io.FileReader(filename));
			try {
				properties.load(reader);
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
				throw new RuntimeException("failed to load properties file " + filename);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("properties file not found at " + filename);
		}
		return properties;
        
    }
    
}
