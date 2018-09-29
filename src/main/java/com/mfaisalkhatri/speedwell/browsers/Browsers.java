package com.mfaisalkhatri.speedwell.browsers;

public interface Browsers {

	public void startBrowser(String browserName, String website) throws Exception;

	public void stopBrowser() throws Exception;

	public void loadWebsite(String website) throws Exception;
}
