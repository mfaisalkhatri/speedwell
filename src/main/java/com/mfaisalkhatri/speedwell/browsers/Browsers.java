package com.mfaisalkhatri.speedwell.browsers;

public interface Browsers {

	public void startBrowser(String browserName, String website);

	public void stopBrowser();

	public void loadWebsite(String website);
}
