package com.mfaisalkhatri.speedwell.elements;

import org.openqa.selenium.By;

public interface Iframes {

	public void switchToiFrame(By locator);

	public void switchToiFrame(int index);

	public void switchToDefaultContent();

}
