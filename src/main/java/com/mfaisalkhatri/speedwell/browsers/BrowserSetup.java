package com.mfaisalkhatri.speedwell.browsers;

import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.mfaisalkhatri.speedwell.elements.ElementSelectors;

public class BrowserSetup implements Browsers {

	public WebDriver driver;
	private static final Logger LOGGER = LogManager.getLogger(ElementSelectors.class.getName());

	public void startBrowser(String browserName, String website) throws Exception {

		try {
			if (browserName == null) {
				LOGGER.error("Browser Name can not be null!!");
			} else if (browserName.equalsIgnoreCase("CHROME")) {
				setupChromeDriver(website);

			} else if (browserName.equalsIgnoreCase("FIREFOX")) {
				setupFireFoxDriver(website);

			} else {
				LOGGER.error("Please Specify Correct Browser - [FIREFOX] or [CHROME]");
			}

		} catch (Exception e) {
			LOGGER.error("Error in BrowserSetup" + e.getMessage());
			LOGGER.catching(e);
		}
	}

	public void stopBrowser() throws Exception {
		try {
			if (driver != null) {
				LOGGER.info("Stopping Driver...");
				driver.quit();
			}
		} catch (Exception e) {
			LOGGER.error("Error occurred while stopping browser" + e.getMessage());
			LOGGER.catching(e);
		}
	}

	public void loadWebsite(String website) throws Exception {
		try {
			LOGGER.info("Loading Website...");
			driver.get(website);
		} catch (Exception e) {
			LOGGER.error("Error occurred while loading website." + e.getMessage());
			LOGGER.catching(e);
		}

	}

	private void setupChromeDriver(String website) throws Exception {
		final String exe = "chromedriver.exe";
		final String path = BrowserSetup.class.getClassLoader().getResource(exe).getPath();

		System.setProperty("webdriver.chrome.driver", path);

		LOGGER.info("Starting Chrome...");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		loadWebsite(website);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().setScriptTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		LOGGER.info("Chrome Started...");
	}

	private void setupFireFoxDriver(String website) throws Exception {
		final String exe = "geckodriver.exe";
		final String path = BrowserSetup.class.getClassLoader().getResource(exe).getPath();

		System.setProperty("webdriver.gecko.driver", path);
		LOGGER.info("Staring Firefox...");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		loadWebsite(website);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().setScriptTimeout(20, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		LOGGER.info("Firefox Started...");

	}
}
