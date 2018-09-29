package com.mfaisalkhatri.speedwell.elements;

import org.openqa.selenium.By;

public interface iFrames {

	public void switchToiFrame(By locator) throws Exception;

	public void switchToiFrame(int index) throws Exception;

	public void switchToDefaultContent();

}
