package com.mfaisalkhatri.speedwell.utility;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesReader {
	private static Properties prop;

	static {
		try (InputStream input = ClassLoader.class.getResourceAsStream("/config.properties")) {
			if (input != null) {
				prop = new Properties();
				prop.load(input);

			} else {
				throw new FileNotFoundException();

			}
		} catch (FileNotFoundException e) {
			System.out.println("Config File not Found!");
			e.printStackTrace();

		} catch (IOException e) {
			System.out.println("Error Occurred while reading file");
			e.printStackTrace();

		}
	}

	public String getKey(String key) throws IOException {

		String val = prop.getProperty(key);
		if (val == null) {
			throw new IOException("Error while reading file..");

		}
		return prop.getProperty(key);
	}

}
