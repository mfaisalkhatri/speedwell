package com.mfaisalkhatri.speedwell.browsers;

import java.io.IOException;
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

	public void startBrowser(String browserName, String website) throws IOException {

		if (browserName.equals(null)) {
			System.out.println("Browser Name can not be null!!");
		} else if (browserName.equalsIgnoreCase("CHROME")) {
			setupChromeDriver(website);

		} else if (browserName.equalsIgnoreCase("FIREFOX")) {
			setupFireFoxDriver(website);

		} else {
			System.out.println("Please Specify Correct Browser - [FIREFOX] or [CHROME]");
		}

	}

	public void stopBrowser() {
		if (driver != null) {
			LOGGER.info("Stopping Driver...");
			driver.quit();
		}
	}

	public void loadWebsite(String website) {
		LOGGER.info("Loading Website...");
		driver.get(website);

	}

	private void setupChromeDriver(String website) {
		final String exe = "chromedriver.exe";
		final String path = BrowserSetup.class.getClassLoader().getResource(exe).getPath();

		System.setProperty("webdriver.chrome.driver", path);

		LOGGER.info("Starting Chrome Driver...");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		loadWebsite(website);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().setScriptTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
	}

	private void setupFireFoxDriver(String website) {
		final String exe = "geckodriver.exe";
		final String path = BrowserSetup.class.getClassLoader().getResource(exe).getPath();

		System.setProperty("webdriver.gecko.driver", path);
		LOGGER.info("Staring Firefox Driver...");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		loadWebsite(website);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().setScriptTimeout(20, TimeUnit.SECONDS);

	}
}
