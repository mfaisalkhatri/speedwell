package com.mfaisalkhatri.speedwell.tests;

import static com.mfaisalkhatri.speedwell.utility.Utilities.sleep;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.mfaisalkhatri.speedwell.browsers.BrowserSetup;
import com.mfaisalkhatri.speedwell.elements.ElementSelectors;
import com.mfaisalkhatri.speedwell.utility.ConfigProperties;

/**
 * @author Faisal Khatri
 *
 */
public class UnitTests extends BrowserSetup {

	/**
	 * @throws IOException
	 * @throws InterruptedException
	 * 
	 */
	@Test
	public void startBrowserTest() throws IOException, InterruptedException {

		ConfigProperties config = new ConfigProperties();
		startBrowser(config.getBrowser(), config.getWebsite());
		sleep(1000);
		stopBrowser();
	}

	/**
	 * @throws IOException
	 * @throws InterruptedException
	 */
	@Test(enabled=false)
	public void testFillFieldWithParent() throws IOException, InterruptedException {

		ConfigProperties config = new ConfigProperties();
		startBrowser(config.getBrowser(), config.getWebsite());
		ElementSelectors selector = new ElementSelectors(driver);
		WebElement pageHeader = driver.findElement(By.cssSelector(".nav"));
		selector.clickField(pageHeader, By.linkText("Sign in"));
		WebElement signInPage = driver.findElement(By.cssSelector(".columns-container"));
		selector.fillField(signInPage, By.id("email"), "testerbuds@gmail.com");
		selector.fillField(signInPage, By.id("passwd"), "123456");
		selector.clickField(signInPage, By.id("SubmitLogin"));
		stopBrowser();

	}

	/**
	 * @throws IOException
	 * @throws InterruptedException
	 */
	@Test(enabled=false)
	public void testFillFieldWOParent() throws IOException, InterruptedException {
		ConfigProperties config = new ConfigProperties();
		startBrowser(config.getBrowser(), config.getWebsite());
		ElementSelectors selector = new ElementSelectors(driver);
		selector.clickField(By.linkText("Sign in"));
		selector.fillField(By.id("email"), "testerbuds@gmail.com");
		selector.fillField(By.id("passwd"), "123456");
		selector.clickField(By.id("SubmitLogin"));
		stopBrowser();

	}

	/**
	 * @throws IOException
	 * 
	 */
	@Test(enabled=false)
	public void getAndCheckFieldValueParent() throws IOException {

		ConfigProperties config = new ConfigProperties();
		startBrowser(config.getBrowser(), config.getWebsite());
		ElementSelectors selector = new ElementSelectors(driver);
		WebElement pageHeader = driver.findElement(By.cssSelector(".nav"));
		selector.clickField(pageHeader, By.linkText("Sign in"));
		selector.getAndCheckFieldValue(pageHeader, By.linkText("Sign in"), "Sign in");
		stopBrowser();
	}
	
	/**
	 * @throws IOException
	 */
	@Test(enabled=false)
	public void getAndCheckFieldValueWOParent() throws IOException {

		ConfigProperties config = new ConfigProperties();
		startBrowser(config.getBrowser(), config.getWebsite());
		ElementSelectors selector = new ElementSelectors(driver);
		selector.clickField(By.linkText("Sign in"));
		selector.getAndCheckFieldValue(By.linkText("Sign in"), "Sign in");
		stopBrowser();
	}
	

}
