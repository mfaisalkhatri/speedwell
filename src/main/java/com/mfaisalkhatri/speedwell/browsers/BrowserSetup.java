package com.mfaisalkhatri.speedwell.browsers;

import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.mfaisalkhatri.speedwell.elements.ElementSelectors;

/**
 * @author Faisal Khatri
 *
 */
public class BrowserSetup implements Browsers {

	protected WebDriver driver;
	private static final Logger LOGGER = LogManager.getLogger(ElementSelectors.class.getName());

	public void startBrowser(String browserName, String website) {

		try {
			if (browserName == null) {
				LOGGER.error("Browser Name can not be null!!");
			} else if (browserName.equalsIgnoreCase("CHROME")) {
				setupChromeDriver(website);

			} else if (browserName.equalsIgnoreCase("FIREFOX")) {
				setupFireFoxDriver(website);

			} else if (browserName.equalsIgnoreCase("IE")) {
				setupIEDriver(website);

			} else {
				LOGGER.error("Please Specify Correct Browser - [FIREFOX] or [CHROME]");
			}

		} catch (Exception e) {
			LOGGER.error("Error in BrowserSetup" + e.getMessage());
			LOGGER.catching(e);
		}
	}

	public void stopBrowser() {
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

	public void loadWebsite(String website) {
		try {
			LOGGER.info("Loading Website...");
			driver.get(website);
		} catch (Exception e) {
			LOGGER.error("Error occurred while loading website." + e.getMessage());
			LOGGER.catching(e);
		}

	}

	private void setupChromeDriver(String website) {
		try {
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
		} catch (Exception e) {
			LOGGER.error("Error in setting up Chrome Driver.." + e.getMessage());
			LOGGER.catching(e);
		}
	}

	private void setupFireFoxDriver(String website) {
		try {
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
		} catch (Exception e) {
			LOGGER.error("Error in Setting up Firefox driver.." + e.getMessage());
			LOGGER.catching(e);
		}
	}

	private void setupIEDriver(String website) {
		try {
			final String exe = "IEDriverServer.exe";
			final String path = BrowserSetup.class.getClassLoader().getResource(exe).getPath();

			System.setProperty("webdriver.ie.driver", path);
			LOGGER.info("Staring Internet Explorer...");
			driver = new InternetExplorerDriver();
			driver.manage().window().maximize();
			loadWebsite(website);
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
			driver.manage().timeouts().setScriptTimeout(20, TimeUnit.SECONDS);
			driver.manage().deleteAllCookies();
			LOGGER.info("Internet Explorer Started...");
		} catch (Exception e) {
			LOGGER.error("Error in Setting up IE driver.." + e.getMessage());
			LOGGER.catching(e);
		}
	}
}
