package com.mfaisalkhatri.speedwell.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.mfaisalkhatri.speedwell.elements.ElementSelectors;
import com.mfaisalkhatri.speedwell.mouseactions.MouseActionsPerform;
import com.mfaisalkhatri.speedwell.utility.Utilities;

import io.qameta.allure.Step;

public class LoginPage {

	private WebDriver driver;
	private ElementSelectors selector;
	private Utilities utility;
	private MouseActionsPerform mouseact;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		this.selector = new ElementSelectors(driver);
		this.utility = new Utilities(driver);
		this.mouseact = new MouseActionsPerform(driver);
	}

	@Step
	public void loginSite(String usrName, String password) throws IOException {

		WebElement pageHeader = driver.findElement(By.cssSelector(".nav"));
		selector.clickField(pageHeader, By.linkText("Sign in"));
		WebElement signInPage = driver.findElement(By.cssSelector(".columns-container"));
		selector.fillField(signInPage, By.id("email"), usrName);
		selector.fillField(signInPage, By.id("passwd"), password);
		utility.captureScreenShot();

		selector.clickField(signInPage, By.id("SubmitLogin"));

		checkPageHeader();
	}

	@Step
	public void checkPageHeader() throws IOException {
		WebElement pageTitle = driver.findElement(By.cssSelector("div#center_column.center_column > h1.page-heading"));
		String actTitle = pageTitle.getText();
		String expTitle = "MY ACCOUNT";
		utility.captureScreenShot();

		Assert.assertEquals(actTitle, expTitle);

	}

	@Step
	public void rightClickonSearch() {
		mouseact.rightClick(By.id("search_query_top"));

	}

}
