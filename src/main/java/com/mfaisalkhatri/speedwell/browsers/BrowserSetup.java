package com.mfaisalkhatri.speedwell.browsers;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserSetup implements Browsers {

	public WebDriver driver;

	public void startBrowser(String browserName, String website) throws IOException {

		if (browserName.equals(null)) {
			System.out.println("Browser Name can not be null!!");
		} else if (browserName.equalsIgnoreCase("CHROME")) {
			final String exe = "chromedriver.exe";
			final String path = BrowserSetup.class.getClassLoader().getResource(exe).getPath();

			System.setProperty("webdriver.chrome.driver", path);

			driver = new ChromeDriver();
			driver.manage().window().maximize();
			loadWebsite(website);
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		} else if (browserName.equalsIgnoreCase("FIREFOX")) {
			final String exe = "geckodriver.exe";
			final String path = BrowserSetup.class.getClassLoader().getResource(exe).getPath();

			System.setProperty("webdriver.gecko.driver", path);

			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			loadWebsite(website);
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		} else {
			System.out.println("Please Specify Correct Browser - [FIREFOX] or [CHROME]");
		}

	}

	public void stopBrowser() {
		if (driver != null) {
			driver.quit();
		}
	}

	public void loadWebsite(String website) {
		driver.get(website);

	}
}
