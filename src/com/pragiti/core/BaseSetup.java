package com.pragiti.core;


import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;

import com.pragiti.report.B2CATAEmailableReport;

@Listeners(B2CATAEmailableReport.class)
public abstract class BaseSetup 
{
	protected static final Logger LOG = Logger.getLogger(BaseSetup.class);
	private String appUrl;
	private static WebDriver driver;
	private String testCase;
	private String testData;
	
	 // Selenium URI -- static same for everyone.
	public static String seleniumURI = null;

	public abstract void setUp();

	@BeforeSuite
    public void setupSuite(){
        //get the uri to send the commands to.
        seleniumURI = SauceHelpers.buildSauceUri();
	}
	public static WebDriver getDriver() {
		return driver;
	}
	/*
	 * Factory method for initializing browsers driver obj
	 * 
	 */
	private void setDriver(String browserType, String appURL) throws MalformedURLException {

		switch (browserType) {
		case "chrome":
			driver = initChromeDriver(appURL);
			break;
		case "firefox":
			driver = initFirefoxDriver(appURL);
			break;
		case "IE":
			driver = initIEDriver(appURL);
			break;
		case "saucelabs":
			driver = initSaucelabsSetup(appURL);
			break;
		default:
			LOG.info("browser : " + browserType
					+ " is invalid, Launching Firefox as browser of choice..");
			driver = initFirefoxDriver(appURL);
		}
	}

	 /**
     * Constructs a new {@link RemoteWebDriver} instance which is configured to use the capabilities defined by the browser,
     * version and os parameters, and which is configured to run against ondemand.saucelabs.com, using
     * the username and access key populated by the {@link #authentication} instance.
     *
     * @param browser Represents the browser to be used as part of the test run.
     * @param version Represents the version of the browser to be used as part of the test run.
     * @param os Represents the operating system to be used as part of the test run.
     * @param methodName Represents the name of the test case that will be used to identify the test on Sauce.
     * @return
     * @throws MalformedURLException if an error occurs parsing the url
     */
	private WebDriver initSaucelabsSetup(String appURL) throws MalformedURLException {
		//TODO: use data provide excel
		final DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability(CapabilityType.BROWSER_NAME, "firefox");
		caps.setCapability(CapabilityType.PLATFORM, "Windows 10");
		caps.setCapability(CapabilityType.VERSION, "44.0");
		caps.setCapability("screenResolution", "1280x1024");
		caps.setCapability("build", "MJB2CUSSmokeTestCases 04-13-2016 Samik Test"); // Give a 'build' name to identify your Job on the sauce dashboard
		caps.setCapability("acceptSslCerts", true);
		
		 SauceHelpers.addSauceConnectTunnelId(caps);

		//caps.setCapability("tunnel-identifier", "MJConnection"); //not required for  publicly accessible URL i.e. for our OOB acc.
		//URL= ondemand.saucelabs.com:80
	//	return new RemoteWebDriver(new java.net.URL("http://" + B2CATAConfig.getString("authentication.saucelabs.username") + ":"+ B2CATAConfig.getString("authentication.saucelabs.password") + appURL), caps);
		 seleniumURI = SauceHelpers.buildSauceUri();
		 WebDriver driver = new RemoteWebDriver(
	                new URL("http://" + B2CATAConfig.getString("authentication.saucelabs.username") + ":" + B2CATAConfig.getString("authentication.saucelabs.password") + seleniumURI +"/wd/hub"),caps);		 
			driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			driver.navigate().to(appURL);
			return driver;
	}

	protected static WebDriver initChromeDriver(String appURL) {
		LOG.info("Launching google chrome with new profile..");
		DesiredCapabilities capability = DesiredCapabilities.chrome();
		// To Accept SSL certificate
		capability.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		System.setProperty("webdriver.chrome.driver", CoreConstants.DRIVERPATH
				+ "chromedriver.exe");
		WebDriver driver = new ChromeDriver(capability);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.navigate().to(appURL);
		return driver;
	}
	private static WebDriver initIEDriver(String appURL) {
		LOG.info("Launching IE with new profile..");
		
		// Create object of DesiredCapabilities class
		DesiredCapabilities cap=DesiredCapabilities.internetExplorer();
		// Set ACCEPT_SSL_CERTS  variable to true
		cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		// Set the driver path
		System.setProperty("webdriver.ie.driver", CoreConstants.DRIVERPATH
				+ "IEDriverServer.exe");
		// Open browser with capability
		WebDriver driver=new InternetExplorerDriver(cap);

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.navigate().to(appURL);
		return driver;
	}

	private static WebDriver initFirefoxDriver(String appURL) {
		LOG.info("Launching Firefox browser..");
		
		FirefoxProfile profile = new FirefoxProfile();
		profile.setAcceptUntrustedCertificates(true); 
		profile.setAssumeUntrustedCertificateIssuer(true);
		
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		capabilities.setAcceptInsecureCerts(true);
		capabilities.setCapability(FirefoxDriver.PROFILE, profile);
		
		System.setProperty("webdriver.gecko.driver", CoreConstants.DRIVERPATH
				+ "geckodriver.exe");
		driver = new FirefoxDriver(capabilities); 

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.navigate().to(appURL);
		return driver;
	}

	@Parameters({ "browserType", "appURL" })
	@BeforeSuite (alwaysRun=true)
	public void initializeTestBaseSetup(String browserType, String appURL) {
		try {
			setDriver(browserType, appURL);
			setAppUrl(appURL);

		} catch (Exception e) {
			LOG.error("Error....." + e.getMessage() + e);
		}
	}

	 /**
     * Method that gets invoked after suite execution.
     * Dumps browser log and
     * Closes the browser
     */
	@AfterSuite
	public void tearDown() {
		if (LOG.isDebugEnabled()) {
			LOG.debug("executing tear down ");
		}
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.quit();
	}

	public String getAppUrl() {
		return appUrl;
	}

	public void setAppUrl(String appUrl) {
		this.appUrl = appUrl;
	}

	public String getTestCase() {
		return testCase;
	}

	public void setTestCase(String testCase) {
		this.testCase = testCase;
	}

	public String getTestData() {
		return testData;
	}

	public void setTestData(String testData) {
		this.testData = testData;
	}
	
	@Parameters({ "testCase", "testData" })
	@BeforeTest(alwaysRun=true)
	public void initiaLizeTest(String testCase, String testData){
		try {
			setTestCase(testCase);
			setTestData(testData);
		} catch (Exception e) {
			LOG.error("Error....." + e.getMessage() + e);
		}
	}

}