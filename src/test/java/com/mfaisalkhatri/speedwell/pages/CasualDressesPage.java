package com.mfaisalkhatri.speedwell.pages;

import static com.mfaisalkhatri.speedwell.utility.Utilities.sleep;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.mfaisalkhatri.speedwell.elements.ElementSelectors;
import com.mfaisalkhatri.speedwell.elements.IframeHandler;
import com.mfaisalkhatri.speedwell.mouseactions.MouseActionsPerform;
import com.mfaisalkhatri.speedwell.utility.Utilities;

import io.qameta.allure.Step;

public class CasualDressesPage {

	private WebDriver driver;
	private ElementSelectors selector;
	private MouseActionsPerform mouseact;
	private IframeHandler iframe;
	private Utilities utility;

	public CasualDressesPage(WebDriver driver) {
		this.driver = driver;
		this.selector = new ElementSelectors(driver);
		this.mouseact = new MouseActionsPerform(driver);
		this.iframe = new IframeHandler(driver);
		this.utility = new Utilities(driver);
	}

	@Step
	public void catalogSection() throws IOException {
		String expHeader = "CASUAL DRESSES ";
		WebElement parentPage = driver.findElement(By.cssSelector(".columns-container"));
		selector.clickField(parentPage, By.id("layered_id_attribute_group_2"));
		selector.getAndCheckFieldValue(parentPage, By.cssSelector("#center_column >h1.page-heading > span.cat-name"),
				expHeader);
		moveSlider();
		utility.captureScreenShot();
	}

	@Step
	public void addProductToCart() throws InterruptedException {
		WebElement hoverOnDress = driver.findElement(By.cssSelector("#center_column > ul > li"));
		mouseact.mousehoverAndClick(hoverOnDress, By.linkText("Printed Dress"), By.linkText("Add to cart"));

		sleep(500);
		WebElement addToCartWindowLeftSide = driver.findElement(By.id("layer_cart"));
		String expMessage = "Product successfully added to your shopping cart";
		selector.getAndCheckFieldValue(addToCartWindowLeftSide, By.cssSelector(".layer_cart_product > h2"), expMessage);

		WebElement addToCartWindowRightSide = driver.findElement(By.cssSelector(".layer_cart_cart"));
		String totPrdct = "$26.00";
		selector.getAndCheckFieldValue(addToCartWindowRightSide, By.cssSelector(".layer_cart_row > span"), totPrdct);

	}

	@Step
	public void quickViewAndToCart() throws IOException, Exception {
		WebElement hoverOnDress = driver.findElement(By.cssSelector("#center_column > ul > li"));
		mouseact.mousehoverAndClick(hoverOnDress, By.linkText("Printed Dress"), By.linkText("Quick view"));

		sleep(200);
		switchToiFrame();
		checkLeftHandOfAddToCartWindow();
		checkRightHandOfAddToCartWindow();

	}

	@Step
	public void switchToiFrame() throws IOException, Exception {
		iframe.switchToiFrame(By.cssSelector("iframe[id^= 'fancybox-frame']"));

		WebElement productDetailsSection = driver.findElement(By.cssSelector(".box-info-product"));
		String qty = "2";
		selector.fillField(productDetailsSection, By.id("quantity_wanted"), qty);
		String size = "M";
		selector.selectField(productDetailsSection, By.id("group_1"), size);
		selector.clickField(productDetailsSection, By.name("Submit"));

		sleep(500);
	}

	@Step
	public void checkLeftHandOfAddToCartWindow() {
		WebElement addToCartWindowLeftSide = driver.findElement(By.id("layer_cart"));
		String expMessage = "Product successfully added to your shopping cart";
		selector.getAndCheckFieldValue(addToCartWindowLeftSide, By.cssSelector(".layer_cart_product > h2"), expMessage);

		WebElement productInfo = driver.findElement(By.cssSelector(".layer_cart_product_info"));
		String prdctTitle = "Printed Dress";
		selector.getAndCheckFieldValue(productInfo, By.cssSelector("span#layer_cart_product_title"), prdctTitle);
		String prdctAttrbts = "Orange, M";
		selector.getAndCheckFieldValue(productInfo, By.cssSelector("span#layer_cart_product_attributes"), prdctAttrbts);
		String prdctQty = "2";
		selector.getAndCheckFieldValue(productInfo, By.cssSelector("div > span#layer_cart_product_quantity"), prdctQty);

		String prdctPrice = "$52.00";
		selector.getAndCheckFieldValue(productInfo, By.cssSelector("div > span#layer_cart_product_price"), prdctPrice);

	}

	@Step
	public void checkRightHandOfAddToCartWindow() {
		WebElement addToCartWindowRightSide = driver.findElement(By.cssSelector(".layer_cart_cart"));
		String totPrdct = "$52.00";
		selector.getAndCheckFieldValue(addToCartWindowRightSide,
				By.cssSelector(".layer_cart_row > span.ajax_block_products_total"), totPrdct);
		String totShipping = "$2.00";
		selector.getAndCheckFieldValue(addToCartWindowRightSide,
				By.cssSelector(".layer_cart_row > span.ajax_cart_shipping_cost"), totShipping);

		String totCost = "$54.00";
		selector.getAndCheckFieldValue(addToCartWindowRightSide,
				By.cssSelector(".layer_cart_row > span.ajax_block_cart_total"), totCost);

		selector.clickField(addToCartWindowRightSide, By.linkText("Proceed to checkout"));

		System.out.println("quick view test complete");

	}

	public void moveSlider() {

		WebElement slider = driver.findElement(By.cssSelector("#left_column"));
		mouseact.scrollPageToElement(slider, By.linkText("Delivery"));
		selector.moveSliderFromLeft(slider, By.cssSelector(".layered_slider_container"),
				By.cssSelector(".ui-slider-handle"), 30);

	}
}
