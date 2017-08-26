package com.pragiti.core;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

public abstract class BaseSetup  {


	public static final Logger LOG = LogManager.getLogger();
	private static String appUrl;
	private static WebDriver driver;
	public static ExtentReports extent;
	private String testCase;
	private String testData;
	private static String suiteName;
	public String testName;
	
	public abstract void setUp();
	public static String seleniumURI = null;
	
	
	@Parameters({ "browserType", "appURL" })
	@BeforeSuite(alwaysRun = true)
	public void initializeTestBaseSetup(String browserType, String appURL, ITestContext ctx) {
		
		try {
			seleniumURI = SauceHelpers.buildSauceUri();
			suiteName  = ctx.getSuite().getName();
			// extent reports
			extent = new ExtentReports();
			ExtentHtmlReporter reporter = this.genHtmlExtReporter(ctx.getSuite().getName());
			extent.attachReporter(reporter);
			setDriver(browserType, appURL);
			setAppUrl(appURL);
		} catch (Exception e) {
			LOG.error("Error....." + e.getMessage() + e);
		}
	}

	@Parameters({ "testCase", "testData" })
	@BeforeTest(alwaysRun = true)
	public void initiaLizeTest(String testCase, String testData) {
		try {
			setTestCase(testCase);
			setTestData(testData);
		} catch (Exception e) {
			LOG.error("Error....." + e.getMessage() + e);
		}
	}
	
	@BeforeTest
	public void setUpTestName(final ITestContext testContext)
	{
		testName = testContext.getName();
	}

	/**
	 * Method that gets invoked after suite execution. Dumps browser log and
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

	public static WebDriver getDriver() {
		return driver;
	}

	/*
	 * Factory method for initializing browsers driver obj
	 * 
	 */
	private void setDriver(String browserType, String appURL) throws MalformedURLException {
		String[] s;
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
		case "saucelabsMacSafari":
			s=B2CATAConfig.getString("sauce.config.mac.safari").split(",");
			driver = initSaucelabsSetup(appURL, s[0], s[1], s[2], s[3] );
		case "saucelabsWindowsFirefox":
			s=B2CATAConfig.getString("sauce.config.windows.firefox").split(",");
			driver = initSaucelabsSetup(appURL, s[0], s[1], s[2], s[3] );
			break;
		case "saucelabs":
			driver = initSaucelabsJenkinsSetup(appURL);
			break;
		default:
			LOG.info("browser : " + browserType + " is invalid, Launching Firefox as browser of choice..");
			driver = initFirefoxDriver(appURL);
		}
	}

	/**
	 * Constructs a new {@link RemoteWebDriver} instance which is configured to
	 * use the capabilities defined by the browser, version and os parameters,
	 * and which is configured to run against ondemand.saucelabs.com, using the
	 * username and access key populated by the {@link #authentication}
	 * instance.
	 * @param browserName 
	 * @param os 
	 *
	 * @param browser
	 *            Represents the browser to be used as part of the test run.
	 * @param version
	 *            Represents the version of the browser to be used as part of
	 *            the test run.
	 * @param os
	 *            Represents the operating system to be used as part of the test
	 *            run.
	 * @param browserVersion 
	 * @param screenResolution 
	 * @param methodName
	 *            Represents the name of the test case that will be used to
	 *            identify the test on Sauce.
	 * @return
	 * @throws MalformedURLException
	 *             if an error occurs parsing the url
	 */
	private WebDriver initSaucelabsSetup(String appURL, String os, String browserName,  String browserVersion, String screenResolution) throws MalformedURLException {
		// TODO: Parallel
		final DesiredCapabilities caps = new DesiredCapabilities();
		
		
		caps.setCapability(CapabilityType.BROWSER_NAME, browserName );
		caps.setCapability(CapabilityType.PLATFORM, os); 
		caps.setCapability(CapabilityType.VERSION, browserVersion);
		caps.setCapability("screenResolution", screenResolution); 
		caps.setCapability("build", suiteName.replace(" ", "_")+"_"+Timestamp.stamp()); 
		caps.setCapability("acceptSslCerts", true);
		caps.setCapability("tunnel-identifier", "mj63"); 
		seleniumURI = SauceHelpers.buildSauceUri();
		WebDriver driver = new RemoteWebDriver(
				new URL("http://" + B2CATAConfig.getString("authentication.saucelabs.username") + ":"
						+ B2CATAConfig.getString("authentication.saucelabs.password") + seleniumURI + "/wd/hub"),
				caps);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.navigate().to(appURL);

		
		return driver;
	}
	
	private WebDriver initSaucelabsJenkinsSetup(String appURL) throws MalformedURLException
	{
		
		
		final DesiredCapabilities caps = new DesiredCapabilities();
	
		caps.setBrowserName(System.getenv("SELENIUM_BROWSER"));
		caps.setVersion(System.getenv("SELENIUM_VERSION"));
		caps.setCapability(CapabilityType.PLATFORM, System.getenv("SELENIUM_PLATFORM"));
		caps.setCapability("build", suiteName.replace(" ", "_")+"_"+Timestamp.stamp()); 
		caps.setCapability("acceptSslCerts", true);
		caps.setCapability("tunnel-identifier", System.getenv("TUNNEL_IDENTIFIER")); 
		caps.setCapability("name",testName);
		seleniumURI = SauceHelpers.buildSauceUri();
		WebDriver dr = new RemoteWebDriver(
				new URL("http://" + B2CATAConfig.getString("authentication.saucelabs.username") + ":"
						+ B2CATAConfig.getString("authentication.saucelabs.password") + seleniumURI + "/wd/hub"),
				caps);
		
		dr.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		dr.manage().window().maximize();
		dr.navigate().to(appURL);
		
		((JavascriptExecutor)dr).executeScript("sauce:job-name="+testName);
		
		return dr;
	}
	
  


	protected static WebDriver initChromeDriver(String appURL) {
		LOG.info("Launching google chrome with new profile..");

		
		DesiredCapabilities capability = DesiredCapabilities.chrome();
		// To Accept SSL certificate
		capability.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		if(OSValidator.isWindows()){
		
			System.setProperty("webdriver.chrome.driver", CoreConstants.DRIVERPATH + "chromedriver.exe");
		
		}else if(OSValidator.isMac()){
			System.setProperty("webdriver.chrome.driver", CoreConstants.DRIVERPATH + "chromedriverMac");
			
		}else if (OSValidator.isUnix()){
			System.setProperty("webdriver.chrome.driver", CoreConstants.DRIVERPATH + "chromedriverLinux");
		}
		WebDriver driver = new ChromeDriver(capability);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.navigate().to(appURL);
		return driver;
	}


	private static WebDriver initIEDriver(String appURL) {
		LOG.info("Launching IE with new profile..");

		// Create object of DesiredCapabilities class
		DesiredCapabilities cap = DesiredCapabilities.internetExplorer();
		// Set ACCEPT_SSL_CERTS  variable to true
		cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		// Set the driver path
		System.setProperty("webdriver.ie.driver", CoreConstants.DRIVERPATH + "IEDriverServer.exe");
		// Open browser with capability
		WebDriver driver = new InternetExplorerDriver(cap);

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
		
		if(OSValidator.isWindows()){
		
		System.setProperty("webdriver.gecko.driver", CoreConstants.DRIVERPATH + "geckodriver.exe");
		
		}else if (OSValidator.isMac()){

			System.setProperty("webdriver.gecko.driver", CoreConstants.DRIVERPATH + "geckodriverMac");

		}else if (OSValidator.isUnix()){

			System.setProperty("webdriver.gecko.driver", CoreConstants.DRIVERPATH + "geckodriverLinux");
		}
		WebDriver driver = new FirefoxDriver(capabilities);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.navigate().to(appURL);
		return driver;
	}
	

	public String getAppUrl() {
		return appUrl;
	}

	public void setAppUrl(String appUrl) {
		BaseSetup.appUrl = appUrl;
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

	private ExtentHtmlReporter genHtmlExtReporter(String reportName) {
		ExtentHtmlReporter reporter = new ExtentHtmlReporter(CoreConstants.TESTREPORTPATH + reportName
				+ CoreConstants.ExtentReports + "_" + Timestamp.stamp() + ".html");
		reporter.config().setTestViewChartLocation(ChartLocation.BOTTOM);
		reporter.config().setChartVisibilityOnOpen(true);
		reporter.config().setTheme(Theme.STANDARD);
		reporter.config().setDocumentTitle(reportName);
		reporter.config().setEncoding(CoreConstants.REPORTENCODING);
		reporter.config().setReportName(reportName);
		return reporter;
	}
}