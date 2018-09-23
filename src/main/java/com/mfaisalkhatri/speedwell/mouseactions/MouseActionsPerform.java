package com.mfaisalkhatri.speedwell.mouseactions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import static com.mfaisalkhatri.speedwell.utility.Utilities.sleep;

public class MouseActionsPerform implements MouseActions {

	private WebElement elementFrom;
	private WebElement elementTo;
	private WebElement element;
	private WebDriver driver;
	private static final Logger LOGGER = LogManager.getLogger(MouseActionsPerform.class.getName());

	public MouseActionsPerform(WebDriver driver) {
		this.driver = driver;
	}

	public void mousehoverAndClick(WebElement parent, By hoverlocator, By moveTo, int wait) {
		try {
			elementFrom = parent.findElement(hoverlocator);
			sleep(wait);
			Actions action = new Actions(driver);
			action.moveToElement(elementFrom).build().perform();
			elementTo = driver.findElement(moveTo);
			action.click(elementTo).build().perform();
		} catch (Exception e) {
			LOGGER.error("Error Occurred in Mousehover Element method " + e.getMessage());
		}
	}

	public void dragAndDrop(WebElement parent, By moveFrom, By moveTo, int wait) {
		try {
		elementFrom = parent.findElement(moveFrom);
		elementTo = parent.findElement(moveTo);
		Actions action = new Actions(driver);
		action.dragAndDrop(elementFrom, elementTo);
		sleep(wait);
		} catch (Exception e) {
			LOGGER.error("Error Occurred in DragAndDrop Method " +e.getMessage());
		}
	}

	public void scrollPageToElememnt(WebElement parent, By locator, int wait) {
		element = parent.findElement(locator);
		sleep(wait);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", element);
	}

}
