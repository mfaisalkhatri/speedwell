package com.mfaisalkhatri.speedwell.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public interface Selectors {
	public void fillField(WebElement parent, By locator, String value);

	public void fillField(By locator, String value);

	public void getAndCheckFieldValue(WebElement parent, By locator, String expValue);

	public void getAndCheckFieldValue(By locator, String expValue);

	public void selectField(WebElement parent, By locator, String value);

	public void selectField(By locator, String value);

	public void selectField(WebElement parent, By locator, int index);

	public void selectField(By locator, int index);

	public void clickField(WebElement parent, By locator);

	public void clickField(By locator);

	public void findFieldsAndClick(WebElement parent, By locator, int index);

	public void findFieldsAndClick(By locator, int index);

	public void submitForm();

	public void keyPress(Keys key);

	public void sendKeys(String value);

	public void highlightField();

	public void unHighlightField();

	public void uploadFile(WebElement parent, By locator, String filePath);

	public void uploadFile(By locator, String filePath);

	public void moveSliderFromLeft(WebElement parent, By locator, By leftPointerLocator,int percent); 

}
