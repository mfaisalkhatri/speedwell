package com.mfaisalkhatri.speedwell.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.mfaisalkhatri.speedwell.mouseactions.MouseActionsPerform;
import com.mfaisalkhatri.speedwell.utility.Utilities;

public class MainPageAfterLogin {

	private WebDriver driver;
	private MouseActionsPerform mouseact;
	private static final Logger LOGGER = LogManager.getLogger(MainPageAfterLogin.class.getName());

	public MainPageAfterLogin(WebDriver driver) {
		this.driver = driver;
		this.mouseact = new MouseActionsPerform(driver);
	}

	public void hoverOnMenu() {
		int wait = 200;
		WebElement parent = driver.findElement(By.cssSelector("#block_top_menu"));
		mouseact.mousehoverAndClick(parent, By.linkText("WOMEN1"), By.linkText("Casual Dresses"), wait);
		LOGGER.info("Mouse Hover Done");

	}

}
