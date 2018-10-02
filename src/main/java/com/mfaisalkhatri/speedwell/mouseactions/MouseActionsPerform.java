package com.mfaisalkhatri.speedwell.mouseactions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import com.mfaisalkhatri.speedwell.utility.ConfigProperties;

import static com.mfaisalkhatri.speedwell.utility.Utilities.sleep;

public class MouseActionsPerform implements MouseActions {

	private WebElement elementFrom;
	private WebElement elementTo;
	private WebElement element;
	private WebDriver driver;
	private JavascriptExecutor js;
	private ConfigProperties configData;
	private static final Logger LOGGER = LogManager.getLogger(MouseActionsPerform.class.getName());

	public MouseActionsPerform(WebDriver driver) {
		this.driver = driver;
		this.configData = new ConfigProperties();
		this.js = (JavascriptExecutor) driver;
	}

	public void mousehoverAndClick(WebElement parent, By hoverlocator, By moveTo) {
		try {
			elementFrom = parent.findElement(hoverlocator);
			sleep(Integer.parseInt(configData.getElementWait()));
			Actions action = new Actions(driver);
			action.moveToElement(elementFrom).build().perform();
			elementTo = driver.findElement(moveTo);
			action.click(elementTo).build().perform();
		} catch (Exception e) {
			LOGGER.error("Error Occurred in Mousehover Element method " + e.getMessage());
		}
	}

	public void dragAndDrop(WebElement parent, By moveFrom, By moveTo) {
		try {
			elementFrom = parent.findElement(moveFrom);
			elementTo = parent.findElement(moveTo);
			Actions action = new Actions(driver);
			action.dragAndDrop(elementFrom, elementTo);
			sleep(Integer.parseInt(configData.getElementWait()));
		} catch (Exception e) {
			LOGGER.error("Error Occurred in DragAndDrop Method " + e.getMessage());
		}
	}

	public void scrollPageToElement(WebElement parent, By locator) {
		try {
			element = parent.findElement(locator);
			sleep(Integer.parseInt(configData.getElementWait()));
			js.executeScript("arguments[0].scrollIntoView();", element);
		} catch (Exception e) {
			LOGGER.error("Error occurred in scrollPageToElement..." + e.getMessage());
		}
	}

	public void rightClick(WebElement parent, By locator) {
		try {
			element = parent.findElement(locator);
			highlightField();
			sleep(Integer.parseInt(configData.getElementWait()));
			Actions action = new Actions(driver);
			action.contextClick(element).build().perform();
			unHighlightField();

		} catch (Exception e) {
			LOGGER.error("Exception Occurred in rightClick method " + e.getMessage());
		}
	}

	public void rightClick(By locator) {
		try {
			element = driver.findElement(locator);
			highlightField();
			sleep(Integer.parseInt(configData.getElementWait()));
			Actions action = new Actions(driver);
			action.contextClick(element).build().perform();
			unHighlightField();

		} catch (Exception e) {
			LOGGER.error("Exception Occurred in rightClick method " + e.getMessage());
		}
	}

	public void highlightField() {
		try {
			js.executeScript("arguments[0].setAttribute('style','border: 2px solid red;');", element);
		} catch (Exception e) {
			LOGGER.error("Exception Occurred in highlightField method " + e.getMessage());
		}

	}

	public void unHighlightField() {
		try {
			js.executeScript("arguments[0].setAttribute('style',arguments[1]);", element);

		} catch (Exception e) {
			LOGGER.error("Exception Occurred in unHighlightField method " + e.getMessage());
		}
	}

}
