package com.mfaisalkhatri.speedwell.utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

/**
 * @author Faisal Khatri
 *
 */
public class Utilities implements Utility {

	private WebDriver driver;
	private static final Logger LOGGER = LogManager.getLogger(Utilities.class.getName());

	/**
	 * @param driver
	 */
	public Utilities(WebDriver driver) {
		this.driver = driver;
	}

	/* (non-Javadoc)
	 * @see com.mfaisalkhatri.speedwell.utility.Utility#captureScreenShot()
	 */
	public void captureScreenShot() throws IOException {
		try {
			String filepath = System.getProperty("user.dir");
			String scrPath = filepath + "/src/test/screenshots/";
			String scrPrefix = "SCR";

			SimpleDateFormat date = new SimpleDateFormat("yyyyMMdd-HHmmss");
			String timeStamp = date.format(Calendar.getInstance().getTime());

			File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

			FileUtils.copyFile(src, new File(scrPath + scrPrefix + timeStamp + ".png"));

		} catch (IOException e) {
			LOGGER.error("Error in capturing screenshot.." + e.getMessage());
			LOGGER.catching(e);

		}
	}

	public void checkMessage(By locator, String message) {

		try {
			WebDriverWait wait = new WebDriverWait(driver, 5);
			WebElement notif = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
			String msg = notif.getText();
			Assert.assertEquals(msg, message);
		} catch (TimeoutException e) {
			LOGGER.error("Timeout Exception occured in check message method.." + e.getMessage());
		}
	}

	/**
	 * @param sleepValue
	 * @throws InterruptedException
	 */
	public static void sleep(int sleepValue) throws InterruptedException {
		try {
			Thread.sleep(sleepValue);
		} catch (InterruptedException e) {
			LOGGER.error("Error in sleep method.." + e.getMessage());
			LOGGER.catching(e);
			Thread.currentThread().interrupt();

		}

	}

	public void closePopUpWindows() {
		try {
			String mainWindow = driver.getWindowHandle();
			Set<String> s1 = driver.getWindowHandles();
			Iterator<String> i1 = s1.iterator();

			while (i1.hasNext()) {
				String childWindow = i1.next();

				if (!mainWindow.equalsIgnoreCase(childWindow)) {
					driver.switchTo().window(childWindow);
					driver.close();

				}
				driver.switchTo().window(mainWindow);
			}
		}

		catch (NoSuchWindowException e) {
			LOGGER.error("Error in getting window handles.." + e.getMessage());
			LOGGER.catching(e);
		}

	}

}
