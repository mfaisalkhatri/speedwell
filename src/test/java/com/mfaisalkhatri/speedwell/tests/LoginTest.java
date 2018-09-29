package com.mfaisalkhatri.speedwell.tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import com.mfaisalkhatri.speedwell.pages.CasualDressesPage;
import com.mfaisalkhatri.speedwell.pages.LoginPage;
import com.mfaisalkhatri.speedwell.pages.MainPageAfterLogin;
import com.mfaisalkhatri.speedwell.utility.ConfigProperties;

public class LoginTest extends Setup {

	
	private static final Logger LOGGER = LogManager.getLogger(MainPageAfterLogin.class.getName ());
	@Test
	public void loginWebsite() throws Exception {
		ConfigProperties config = new ConfigProperties();
		LoginPage login = new LoginPage(driver);
		login.loginSite(config.getUserName(), config.getPassword());
		MainPageAfterLogin mainPage = new MainPageAfterLogin(driver);
		mainPage.hoverOnMenu();
		
		CasualDressesPage casual = new CasualDressesPage(driver);
		//casual.addProductToCart();
		casual.quickViewAndToCart();
		
		
	}

}
