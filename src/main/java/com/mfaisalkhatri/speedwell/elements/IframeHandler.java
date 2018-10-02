package com.mfaisalkhatri.speedwell.elements;

import static com.mfaisalkhatri.speedwell.utility.Utilities.sleep;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.mfaisalkhatri.speedwell.utility.ConfigProperties;

public class IframeHandler implements Iframes {

	private WebDriver driver;
	private ConfigProperties configData;
	private static final Logger LOGGER = LogManager.getLogger(IframeHandler.class.getName());

	public IframeHandler(WebDriver driver) {
		this.driver = driver;
		this.configData = new ConfigProperties();
	}

	public void switchToiFrame(By locator) {
		try {
			WebElement element;
			element = driver.findElement(locator);
			LOGGER.info("Switching to iFrame using locator...");
			WebDriverWait webWait = new WebDriverWait(driver, Integer.parseInt(configData.getElementWait()));
			webWait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(element));
		} catch (Exception e) {
			LOGGER.error("Exception in switching iFrame by locator" + e.getMessage());
			LOGGER.catching(e);
		}
	}

	public void switchToiFrame(int index) {
		try {
			LOGGER.info("Switching to iFrame using index...");
			int frameSize = driver.findElements(By.tagName("iframe")).size();
			if (frameSize < 0) {
				LOGGER.error("No iFrames Found");
			} else {
				sleep(Integer.parseInt(configData.getElementWait()));
				driver.switchTo().frame(index);
			}
		} catch (Exception e) {
			LOGGER.error("Exception in switching iFrame by index" + e.getMessage());
			LOGGER.catching(e);
		}

	}

	public void switchToDefaultContent() {
		try {
			driver.switchTo().defaultContent();
		} catch (Exception e) {
			LOGGER.error("Error in switching to default content" + e.getMessage());
			LOGGER.catching(e);
		}
	}

}
