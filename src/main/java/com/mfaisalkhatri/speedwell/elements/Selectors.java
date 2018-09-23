package com.mfaisalkhatri.speedwell.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public interface Selectors {
	public void fillField(WebElement parent, By locator, String value, int wait);

	public void getFieldValue(WebElement parent, By locator, int wait);

	public void selectField(WebElement parent, By locator, String value, int wait);

	public void selectField(WebElement parent, By locator, int index, int wait);

	public void clickField(WebElement parent, By locator, int wait);

	public void findFieldsAndClick(WebElement parent, By locator, int index, int wait);

	public void submitForm();

	public void keyPress(Keys key);

	public void rightClick(WebElement parent, By locator, int wait);

	public void sendKeys(String value);

	public void highlightField();

	public void unHighlightField();

	public void uploadFile(WebElement parent, By locator, String filePath, int wait);

}
