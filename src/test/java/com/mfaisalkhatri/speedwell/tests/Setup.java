package com.mfaisalkhatri.speedwell.tests;

import java.io.IOException;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.mfaisalkhatri.speedwell.browsers.BrowserSetup;
import com.mfaisalkhatri.speedwell.utility.ConfigProperties;
import com.mfaisalkhatri.speedwell.utility.Utilities;

public class Setup extends BrowserSetup {
	
	

	@BeforeMethod
	public void siteup() throws IOException {
		ConfigProperties config = new ConfigProperties();
		startBrowser(config.getBrowser(), config.getWebsite());

	}

	@AfterMethod
	public void tearDown(ITestResult result) {
		if (ITestResult.FAILURE == result.getStatus())
			try {
				Utilities utility = new Utilities(driver);
				utility.captureScreenShot();
			} catch (Exception e) {

				System.out.println("Exception while taking screenshot " + e.getMessage());
			}

		stopBrowser();
	}
}
