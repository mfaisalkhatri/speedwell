package com.mfaisalkhatri.speedwell.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.mfaisalkhatri.speedwell.elements.ElementSelectors;
import com.mfaisalkhatri.speedwell.mouseactions.MouseActionsPerform;
import com.mfaisalkhatri.speedwell.utility.Utilities;

import io.qameta.allure.Step;

public class CasualDressesPage {
	
	
	private WebDriver driver;
	private ElementSelectors selector;
	private MouseActionsPerform mouseact;
	private Utilities utility;

	public CasualDressesPage(WebDriver driver) {
		this.driver = driver;
		this.selector = new ElementSelectors(driver);
		this.utility = new Utilities(driver);
		this.mouseact = new MouseActionsPerform(driver);
	}


	@Step
	public void catalogSection () {
		int wait = 500;
		String expHeader = "CASUAL DRESSES ";
		WebElement parentPage = driver.findElement(By.cssSelector(".columns-container"));
		selector.clickField(parentPage, By.id("layered_id_attribute_group_2"), wait);
		selector.getAndCheckFieldValue(parentPage, By.cssSelector("#center_column >h1.page-heading > span.cat-name"),expHeader, wait);
		
		WebElement slider = driver.findElement(By.cssSelector("#left_column"));
		mouseact.scrollPageToElememnt(slider, By.linkText("Delivery"), wait);
		selector.moveSlider(slider,By.cssSelector(".layered_slider_container"), "Right", 10, wait);
		
	}
	
}
