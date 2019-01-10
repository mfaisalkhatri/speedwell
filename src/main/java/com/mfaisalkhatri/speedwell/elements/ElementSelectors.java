package com.mfaisalkhatri.speedwell.elements;

import static com.mfaisalkhatri.speedwell.utility.Utilities.sleep;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.mfaisalkhatri.speedwell.utility.ConfigProperties;

public class ElementSelectors implements Selectors {

	private WebDriver driver;
	private WebElement element;
	private ConfigProperties configData;
	private JavascriptExecutor js;
	private static final Logger LOGGER = LogManager.getLogger(ElementSelectors.class.getName());

	/**
	 * @param driver
	 */
	public ElementSelectors(WebDriver driver) {
		this.driver = driver;
		this.configData = new ConfigProperties();
		this.js = (JavascriptExecutor) driver;
	}

	public void fillField(WebElement parent, By locator, String value) {
		try {
			element = parent.findElement(locator);
			highlightField();
			sleep(Integer.parseInt(configData.getElementWait()));
			sendKeys(value);
			unHighlightField();
		} catch (Exception e) {
			LOGGER.error("Exception Occurred in fillField method " + e.getMessage());
		}
	}

	public void fillField(By locator, String value) {
		try {
			element = driver.findElement(locator);
			highlightField();
			sleep(Integer.parseInt(configData.getElementWait()));
			sendKeys(value);
			unHighlightField();
		} catch (Exception e) {
			LOGGER.error("Exception Occurred in fillField method " + e.getMessage());
		}
	}

	public void getAndCheckFieldValue(WebElement parent, By locator, String expValue) {
		try {
			element = parent.findElement(locator);
			highlightField();
			sleep(Integer.parseInt(configData.getElementWait()));
			String fieldValue = element.getText();
			unHighlightField();
			Assert.assertEquals(fieldValue, expValue);
		} catch (Exception e) {
			LOGGER.error("Exception Occurred in getAndCheckFieldValue method " + e.getMessage());
		}
	}

	public void getAndCheckFieldValue(By locator, String expValue) {
		try {
			element = driver.findElement(locator);
			highlightField();
			sleep(Integer.parseInt(configData.getElementWait()));
			String fieldValue = element.getText();
			unHighlightField();
			Assert.assertEquals(fieldValue, expValue);
		} catch (Exception e) {
			LOGGER.error("Exception Occurred in getAndCheckFieldValue method " + e.getMessage());
		}
	}

	public void clickField(WebElement parent, By locator) {
		try {
			element = parent.findElement(locator);
			highlightField();
			sleep(Integer.parseInt(configData.getElementWait()));
			unHighlightField();
			element.click();
		} catch (Exception e) {
			LOGGER.error("Exception Occurred in clickField method " + e.getMessage());
		}
	}

	public void clickField(By locator) {
		try {
			element = driver.findElement(locator);
			highlightField();
			sleep(Integer.parseInt(configData.getElementWait()));
			unHighlightField();
			element.click();
		} catch (Exception e) {
			LOGGER.error("Exception Occurred in clickField method " + e.getMessage());
		}
	}

	public void selectField(WebElement parent, By locator, String value) {
		try {
			element = parent.findElement(locator);
			highlightField();
			sleep(Integer.parseInt(configData.getElementWait()));
			Select select = new Select(element);
			select.selectByVisibleText(value);
			unHighlightField();
		} catch (Exception e) {
			LOGGER.error("Exception Occurred in selectField1 method " + e.getMessage());
		}

	}

	public void selectField(By locator, String value) {
		try {
			element = driver.findElement(locator);
			highlightField();
			sleep(Integer.parseInt(configData.getElementWait()));
			Select select = new Select(element);
			select.selectByVisibleText(value);
			unHighlightField();
		} catch (Exception e) {
			LOGGER.error("Exception Occurred in selectField1 method " + e.getMessage());
		}

	}

	public void selectField(WebElement parent, By locator, int index) {
		try {
			element = parent.findElement(locator);
			highlightField();
			sleep(Integer.parseInt(configData.getElementWait()));
			Select select = new Select(element);
			select.selectByIndex(index);
			unHighlightField();
		} catch (Exception e) {
			LOGGER.error("Exception Occurred in selectField2 method " + e.getMessage());
		}
	}

	public void selectField(By locator, int index) {
		try {
			element = driver.findElement(locator);
			highlightField();
			sleep(Integer.parseInt(configData.getElementWait()));
			Select select = new Select(element);
			select.selectByIndex(index);
			unHighlightField();
		} catch (Exception e) {
			LOGGER.error("Exception Occurred in selectField2 method " + e.getMessage());
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

	public void sendKeys(String value) {
		try {
			element.click();
			element.clear();

			for (int i = 0; i < value.length(); i++) {
				char c = value.charAt(i);
				String s = new StringBuilder().append(c).toString();
				element.sendKeys(s);
				sleep(Integer.parseInt(configData.getSendKeysWait()));
			}
		} catch (Exception e) {
			LOGGER.error("Exception Occurred in sendKeys method " + e.getMessage());
		}
	}

	public void submitForm() {
		try {
			element.submit();
		} catch (Exception e) {
			LOGGER.error("Exception Occurred in submitForm method " + e.getMessage());
		}
	}

	public void keyPress(Keys key) {
		try {
			element.sendKeys(key);
		} catch (Exception e) {
			LOGGER.error("Exception Occurred in keyPress method " + e.getMessage());
		}
	}

	public void findFieldsAndClick(WebElement parent, By locator, int index) {
		try {
			List<WebElement> elements = parent.findElements(locator);
			element = elements.get(index);
			highlightField();
			sleep(Integer.parseInt(configData.getElementWait()));
			unHighlightField();
			element.click();
		} catch (Exception e) {
			LOGGER.error("Exception Occurred in findFieldsAndClick method " + e.getMessage());
		}
	}

	public void findFieldsAndClick(By locator, int index) {
		try {
			List<WebElement> elements = driver.findElements(locator);
			element = elements.get(index);
			highlightField();
			sleep(Integer.parseInt(configData.getElementWait()));
			unHighlightField();
			element.click();
		} catch (Exception e) {
			LOGGER.error("Exception Occurred in findFieldsAndClick method " + e.getMessage());
		}
	}

	public void uploadFile(WebElement parent, By locator, String filePath) {
		try {
			element = parent.findElement(locator);
			highlightField();
			sleep(Integer.parseInt(configData.getElementWait()));
			element.sendKeys(filePath);
			unHighlightField();
		} catch (Exception e) {
			LOGGER.error("Exception Occurred in uploadFile method " + e.getMessage());
		}
	}

	public void uploadFile(By locator, String filePath) {
		try {
			element = driver.findElement(locator);
			highlightField();
			sleep(Integer.parseInt(configData.getElementWait()));
			element.sendKeys(filePath);
			unHighlightField();
		} catch (Exception e) {
			LOGGER.error("Exception Occurred in uploadFile method " + e.getMessage());
		}
	}

	public void moveSliderFromLeft(WebElement parent, By locator, By leftPointerLocator, int percent) {
		try {
			element = parent.findElement(locator);
			boolean sliderIsDisplayed = element.isDisplayed();
			if (!sliderIsDisplayed) {
				LOGGER.error("Slider is not displayed");
			} else {
				int sliderSize = element.getSize().getWidth();
				LOGGER.info("Width of slider: " + sliderSize);
				int movement = sliderSize * percent / 100;

				WebElement leftPointer = parent.findElement(leftPointerLocator);

				int xCoord = leftPointer.getLocation().getX();
				LOGGER.info(xCoord);

				sleep(Integer.parseInt(configData.getElementWait()));
				Actions builder = new Actions(driver);
				builder.dragAndDropBy(leftPointer, movement, 0).perform();

				int afterXCo = leftPointer.getLocation().getY();
				LOGGER.info(afterXCo);
				String percentmovement = leftPointer.getAttribute("style");
				LOGGER.info("Movement is :" + percentmovement);

			}

		} catch (Exception e) {
			LOGGER.error("Exception Occurred in moveSlider method " + e.getMessage());
		}
	}

}
