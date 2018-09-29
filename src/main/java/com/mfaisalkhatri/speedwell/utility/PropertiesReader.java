package com.mfaisalkhatri.speedwell.utility;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PropertiesReader {
	private static Properties prop;
	private static final Logger LOGGER = LogManager.getLogger(Utilities.class.getName());
	
	static {
		try (InputStream input = ClassLoader.class.getResourceAsStream("/config.properties")) {
			if (input != null) {
				prop = new Properties();
				prop.load(input);

			} else {
				throw new FileNotFoundException();

			}
		} catch (FileNotFoundException e) {
			LOGGER.error("Condif file not found" + e.getMessage());
			LOGGER.catching(e);
			

		} catch (IOException e) {
			LOGGER.error("Error occurred while reading file" +e.getMessage());
			LOGGER.catching(e);

		}
	}

	public String getKey(String key) throws IOException {

		String val = prop.getProperty(key);
		if (val == null) {
			throw new IOException("Error occurred while reading file..");

		}
		return prop.getProperty(key);
	}

}
