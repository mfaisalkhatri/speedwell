package com.mfaisalkhatri.speedwell.pages;

import static com.mfaisalkhatri.speedwell.utility.Utilities.sleep;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.mfaisalkhatri.speedwell.elements.ElementSelectors;
import com.mfaisalkhatri.speedwell.mouseactions.MouseActionsPerform;

import io.qameta.allure.Step;

public class CasualDressesPage {

	private WebDriver driver;
	private ElementSelectors selector;
	private MouseActionsPerform mouseact;

	public CasualDressesPage(WebDriver driver) {
		this.driver = driver;
		this.selector = new ElementSelectors(driver);
		this.mouseact = new MouseActionsPerform(driver);
	}

	@Step
	public void catalogSection() {
		int wait = 500;
		String expHeader = "CASUAL DRESSES ";
		WebElement parentPage = driver.findElement(By.cssSelector(".columns-container"));
		selector.clickField(parentPage, By.id("layered_id_attribute_group_2"), wait);
		selector.getAndCheckFieldValue(parentPage, By.cssSelector("#center_column >h1.page-heading > span.cat-name"),
				expHeader, wait);

		/*
		 * WebElement slider = driver.findElement(By.cssSelector("#left_column"));
		 * mouseact.scrollPageToElememnt(slider, By.linkText("Delivery"), wait);
		 * selector.moveSlider(slider,By.cssSelector(".layered_slider_container"),
		 * "Right", 10, wait);
		 */

	}

	@Step
	public void addProductToCart() {
		int wait = 200;
		WebElement hoverOnDress = driver.findElement(By.cssSelector("#center_column > ul > li"));
		mouseact.mousehoverAndClick(hoverOnDress, By.linkText("Printed Dress"), By.linkText("Add to cart"), wait);

		sleep(500);
		WebElement addToCartWindowLeftSide = driver.findElement(By.id("layer_cart"));
		String expMessage = "Product successfully added to your shopping cart";
		selector.getAndCheckFieldValue(addToCartWindowLeftSide, By.cssSelector(".layer_cart_product > h2"), expMessage,
				wait);

		WebElement addToCartWindowRightSide = driver.findElement(By.cssSelector(".layer_cart_cart"));
		String totPrdct = "$26.00";
		selector.getAndCheckFieldValue(addToCartWindowRightSide, By.cssSelector(".layer_cart_row > span"), totPrdct,
				wait);

	}

	@Step
	public void quickViewAndToCart() {
		int wait = 200;
		WebElement hoverOnDress = driver.findElement(By.cssSelector("#center_column > ul > li"));
		mouseact.mousehoverAndClick(hoverOnDress, By.linkText("Printed Dress"), By.linkText("Quick view"), wait);

		sleep(wait);
		switchToiFrame();
		checkLeftHandOfAddToCartWindow();
		checkRightHandOfAddToCartWindow();

	}

	@Step
	public void switchToiFrame() {
		int wait = 200;
		selector.switchToiFrame(By.cssSelector("iframe[id^= 'fancybox-frame']"), wait);

		WebElement productDetailsSection = driver.findElement(By.cssSelector(".box-info-product"));
		String qty = "2";
		selector.fillField(productDetailsSection, By.id("quantity_wanted"), qty, wait);
		String size = "M";
		selector.selectField(productDetailsSection, By.id("group_1"), size, wait);
		selector.clickField(productDetailsSection, By.name("Submit"), wait);

		sleep(500);
	}

	@Step
	public void checkLeftHandOfAddToCartWindow() {
		int wait = 200;
		WebElement addToCartWindowLeftSide = driver.findElement(By.id("layer_cart"));
		String expMessage = "Product successfully added to your shopping cart";
		selector.getAndCheckFieldValue(addToCartWindowLeftSide, By.cssSelector(".layer_cart_product > h2"), expMessage,
				wait);

		WebElement productInfo = driver.findElement(By.cssSelector(".layer_cart_product_info"));
		String prdctTitle = "Printed Dress";
		selector.getAndCheckFieldValue(productInfo, By.cssSelector("span#layer_cart_product_title"), prdctTitle, wait);
		String prdctAttrbts = "Orange, M";
		selector.getAndCheckFieldValue(productInfo, By.cssSelector("span#layer_cart_product_attributes"), prdctAttrbts,
				wait);
		String prdctQty = "2";
		selector.getAndCheckFieldValue(productInfo, By.cssSelector("div > span#layer_cart_product_quantity"), prdctQty,
				wait);

		String prdctPrice = "$52.00";
		selector.getAndCheckFieldValue(productInfo, By.cssSelector("div > span#layer_cart_product_price"), prdctPrice,
				wait);

	}

	@Step
	public void checkRightHandOfAddToCartWindow() {
		int wait = 200;
		WebElement addToCartWindowRightSide = driver.findElement(By.cssSelector(".layer_cart_cart"));
		String totPrdct = "$52.00";
		selector.getAndCheckFieldValue(addToCartWindowRightSide,
				By.cssSelector(".layer_cart_row > span.ajax_block_products_total"), totPrdct, wait);
		String totShipping = "$2.00";
		selector.getAndCheckFieldValue(addToCartWindowRightSide,
				By.cssSelector(".layer_cart_row > span.ajax_cart_shipping_cost"), totShipping, wait);

		String totCost = "$54.00";
		selector.getAndCheckFieldValue(addToCartWindowRightSide,
				By.cssSelector(".layer_cart_row > span.ajax_block_cart_total"), totCost, wait);

		selector.clickField(addToCartWindowRightSide, By.linkText("Proceed to checkout"), wait);

		System.out.println("quick view test complete");

	}
}
