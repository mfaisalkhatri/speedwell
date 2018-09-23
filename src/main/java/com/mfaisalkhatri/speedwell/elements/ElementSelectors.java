package com.mfaisalkhatri.speedwell.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import static com.mfaisalkhatri.speedwell.utility.Utilities.sleep;

import java.util.List;

public class ElementSelectors implements Selectors {

	private WebDriver driver;
	private WebElement element;

	public ElementSelectors(WebDriver driver) {
		this.driver = driver;
	}

	public void fillField(WebElement parent, By locator, String value, int wait) {
		element = parent.findElement(locator);
		highlightField();
		sleep(wait);
		sendKeys(value);
		unHighlightField();
	}
	
	public void getFieldValue(WebElement parent, By locator, int wait) {
		element = parent.findElement(locator);
		highlightField();
		sleep(wait);
		String fieldValue = element.getText();
		unHighlightField();
		System.out.println("Value in the field is " +fieldValue);
	}
	

	public void clickField(WebElement parent, By locator, int wait) {
		element = parent.findElement(locator);
		highlightField();
		sleep(wait);
		unHighlightField();
		element.click();

	}

	public void selectField(WebElement parent, By locator, String value, int wait) {
		element = parent.findElement(locator);
		highlightField();
		sleep(wait);
		Select select = new Select(element);
		select.selectByVisibleText(value);
		unHighlightField();
	}

	public void selectField(WebElement parent, By locator, int index, int wait) {
		element = parent.findElement(locator);
		highlightField();
		sleep(wait);
		Select select = new Select(element);
		select.selectByIndex(index);
		unHighlightField();
	}

	public void highlightField() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('style','border: 2px solid red;');", element);

	}

	public void unHighlightField() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('style',arguments[1]);", element);

	}

	public void sendKeys(String value) {
		element.click();
		element.clear();

		for (int i = 0; i < value.length(); i++) {
			char c = value.charAt(i);
			String s = new StringBuilder().append(c).toString();
			element.sendKeys(s);
			sleep(50);
		}
	}

	public void submitForm() {
		element.submit();
	}

	public void keyPress(Keys key) {
		element.sendKeys(key);

	}

	public void rightClick(WebElement parent, By locator, int wait) {
		element = parent.findElement(locator);
		highlightField();
		sleep(wait);
		Actions action = new Actions(driver);
		action.contextClick(element).build().perform();
		unHighlightField();

	}

	public void findFieldsAndClick(WebElement parent, By locator, int index, int wait) {
		List<WebElement> elements = parent.findElements(locator);
		element = elements.get(index);
		highlightField();
		sleep(wait);
		unHighlightField();
		element.click();

	}

	public void uploadFile(WebElement parent, By locator, String filePath, int wait) {
	element = parent.findElement(locator);
	highlightField();
	sleep(wait);
	element.sendKeys(filePath);
	unHighlightField();

	}

}
