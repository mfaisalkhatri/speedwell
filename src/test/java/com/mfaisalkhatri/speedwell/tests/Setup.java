package com.mfaisalkhatri.speedwell.tests;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.mfaisalkhatri.speedwell.browsers.BrowserSetup;
import com.mfaisalkhatri.speedwell.main.ConfigProperties;

public class Setup extends BrowserSetup {

	@BeforeMethod
	public void siteup() throws IOException {
		ConfigProperties config = new ConfigProperties();
		startBrowser(config.getBrowser(), config.getWebsite());

	}

	@AfterMethod
	public void tearDown() {
		stopBrowser();
	}
}
