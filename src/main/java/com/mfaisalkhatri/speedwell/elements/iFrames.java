package com.mfaisalkhatri.speedwell.elements;

import java.io.IOException;

import org.openqa.selenium.By;

public interface iFrames {

	public void switchToiFrame(By locator) throws Exception, IOException;

	public void switchToiFrame(int index) throws NumberFormatException, IOException;

	public void switchToDefaultContent();

}
