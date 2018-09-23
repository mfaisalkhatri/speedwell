package com.mfaisalkhatri.speedwell.main;

import java.io.IOException;

import com.mfaisalkhatri.speedwell.utility.PropertiesReader;


public class ConfigProperties {

	PropertiesReader prop = new PropertiesReader();

	public String getBrowser() throws IOException {
		return prop.getKey("browser");
	}

	public String getWebsite() throws IOException {
		return prop.getKey("website");
	}

	public String getUserName() throws IOException {
		return prop.getKey("username");
	}
	public String getPassword() throws IOException {
		return prop.getKey("password");
	}

	
	
}
