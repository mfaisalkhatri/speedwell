package com.mfaisalkhatri.speedwell.mouseactions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public interface MouseActions {

	
	public void mousehoverAndClick(WebElement parent, By hoverlocator, By moveTo, int wait);
	public void dragAndDrop(WebElement parent, By moveFrom, By moveTo, int wait);
}
