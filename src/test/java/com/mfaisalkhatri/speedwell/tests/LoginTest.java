package com.mfaisalkhatri.speedwell.tests;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import com.mfaisalkhatri.speedwell.main.ConfigProperties;
import com.mfaisalkhatri.speedwell.pages.CasualDressesPage;
import com.mfaisalkhatri.speedwell.pages.LoginPage;
import com.mfaisalkhatri.speedwell.pages.MainPageAfterLogin;

public class LoginTest extends Setup {

	
	private static final Logger LOGGER = LogManager.getLogger(MainPageAfterLogin.class.getName ());
	@Test
	public void loginWebsite() throws IOException {
		ConfigProperties config = new ConfigProperties();
		LoginPage login = new LoginPage(driver);
		login.loginSite(config.getUserName(), config.getPassword());
		MainPageAfterLogin mainPage = new MainPageAfterLogin(driver);
		mainPage.hoverOnMenu();
		
		CasualDressesPage casual = new CasualDressesPage(driver);
		casual.catalogSection();
		
		LOGGER.info("Login Test Complete");
		
	}

}
