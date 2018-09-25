**speedwell**

**A power-packed keyword driven framework which is integrated with Allure reports and Log4j2.**

**Getting Started**

*This page includes all the information you need to get started including setup, usage, advantages, sample test.*

**What to do when you need help?**
* Discuss your queries by writing to me at: 
* Mail: mohammadfaisalkhatri@gmail.com 
* Twitter: @mfaisal_khatri 
* LinkedIn: Mohammad Faisal Khatri

* If you find any issue which is bottleneck for you, search the issue tracker to see if it is already raised.
* If not raised, then you can create a new issue with required details as mentioned in the issue template.

**What you do if you like the project?**
* Spread the word with your network.
* Star the project to make the project popular.
* Stay updated with the project progress by Watching it.

**How to use this Framework:**
01. "Config.Properties" file is used in the framework for defining the Browser Type, storing the Url of website used for tests, User Id and Password of used for login, etc.

```
This is the config file extract: 
browser=chrome //Here, browser value should be give, like "Chrome" / "Firefox".
website=http://www.google.co.in
username=user001
password=pass01
```

02. PropertiesReader class is available in the Framework which is a helper class to read the config file in simplified way.
03. Getter/Setter is required to be created for the Config file key value pairs to be used in tests.

```
This is how Getter/Setter is created for fetching config file values:
public class ConfigProperties {

	PropertiesReader prop = new PropertiesReader();

	public String getBrowser() throws IOException {
		return prop.getKey("browser");
	}

	public String getWebsite() throws IOException {
		return prop.getKey("website");
	}

	public String getUserName() throws IOException {
		return prop.getKey("username");
	}
	public String getPassword() throws IOException {
		return prop.getKey("password");
	}
```

04. For using this framework, you have to create a Setup class where browser will be set up. Use "testng" annotations "BeforeSuite"/"BeforeClass"/"BeforeMethod", according to your case and condition of automation tests and Extend "BrowserSetup" class in it.
05. Now you can use the "startBrowser" method directly in your tests which requires, "Browser Name" and "Website Url" as parameters.
06. For tearDown method, "stopBrowser" will quit the browsers.

**This is what Setup class looks like :**
```
public class Setup extends BrowserSetup {

	@BeforeMethod
	public void siteup() throws IOException {
		ConfigProperties config = new ConfigProperties();
		startBrowser(config.getBrowser(), config.getWebsite());

	}

	@AfterMethod
	public void tearDown() {
		stopBrowser();
	}
}
```

07. I have created this framework keeping "Page Object Model" in mind, so, the next step would be defining a class with locators of the page which can be used in final tests.
Suppose, for example, Login Page is available and we need to find locators for "Username" and "Password" fields, enter their respective values, find locator of submit button and click on it. 

**This is what the Login Page will look like:**

```
public class LoginPage {

	private WebDriver driver;
	private ElementSelectors selector;
	private Utilities utility;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		this.selector = new ElementSelectors(driver);
		this.utility = new Utilities(driver);
	}

	@Step
	public void loginSite(String usrName, String password) throws IOException {
		int wait = 100;

		WebElement pageHeader = driver.findElement(By.cssSelector(".nav"));
		selector.clickField(pageHeader, By.linkText("Sign in"), wait);

		WebElement signInPage = driver.findElement(By.cssSelector(".columns-container"));
		selector.fillField(signInPage, By.id("email"), usrName, wait);
		selector.fillField(signInPage, By.id("passwd"), password, wait);
		utility.captureScreenShot();

		selector.clickField(signInPage, By.id("SubmitLogin"), wait);

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
}
```
08. Now, comes the Test Class, it will be like this: 
```
public class LoginTest extends Setup {

	@Test
	public void loginWebsite() throws IOException {
		ConfigProperties config = new ConfigProperties();
		LoginPage login = new LoginPage(driver);
		login.loginSite(config.getUserName(), config.getPassword());
		
		
		
	}
```

**Isn't this simple? Let me know your thoughts on this....?**
