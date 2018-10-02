package com.mfaisalkhatri.speedwell.tests;

import org.testng.annotations.Test;

import com.mfaisalkhatri.speedwell.pages.LoginPage;

public class RightClickTest extends Setup{

	@Test
	public void test1() {
	LoginPage login = new LoginPage(driver);	
		login.rightClickonSearch();
	}
}
