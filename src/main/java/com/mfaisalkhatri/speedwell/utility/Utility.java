package com.mfaisalkhatri.speedwell.utility;

import java.io.IOException;

import org.openqa.selenium.By;

public interface Utility {

	public static void captureScreenShot() throws IOException {
	}

	public static void sleep(int sleepValue) {
	}

	public void checkMessage(By locator, String message);

	public void closePopUpWindows();

}
