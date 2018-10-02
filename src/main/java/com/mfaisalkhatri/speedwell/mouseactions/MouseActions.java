package com.mfaisalkhatri.speedwell.mouseactions;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public interface MouseActions {

	
	public void mousehoverAndClick(WebElement parent, By hoverlocator, By moveTo);
	public void dragAndDrop(WebElement parent, By moveFrom, By moveTo);
	public void scrollPageToElement(WebElement parent, By locator);
	public void rightClick(WebElement parent, By locator);
	public void rightClick(By locator);
	
	
}
