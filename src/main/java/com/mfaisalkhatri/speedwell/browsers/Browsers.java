package com.mfaisalkhatri.speedwell.browsers;

import java.io.IOException;

public interface Browsers {

	public void startBrowser(String browserName, String website) throws IOException;

	public void stopBrowser();

	public void loadWebsite(String website);
}
