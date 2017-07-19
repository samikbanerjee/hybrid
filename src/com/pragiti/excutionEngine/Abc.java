package com.pragiti.excutionEngine;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Abc {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "https://usmauijim.stg/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testAbc() throws Exception {
    driver.get(baseUrl + "/");
    driver.findElement(By.xpath("//a[contains(@href, 'javascript://')]")).click();
    driver.findElement(By.xpath("//div[@id='slidemenu']/div/ul[2]/li/ul/li/div/div/a/span/img")).click();
    driver.findElement(By.id("responsiveImage")).click();
    driver.findElement(By.xpath("(//img[@id='responsiveImage'])[2]")).click();
    driver.findElement(By.id("addToCartButton")).click();
    driver.findElement(By.xpath("//li[@id='holderMiniCart']/a/span[2]")).click();
    driver.findElement(By.xpath("(//a[contains(@href, '/en/checkout')])[2]")).click();
    driver.findElement(By.id("registerInterceptSubmitButton")).click();
    driver.findElement(By.id("contactEmail")).clear();
    driver.findElement(By.id("contactEmail")).sendKeys("abc@test.com");
    driver.findElement(By.id("contactPhone")).clear();
    driver.findElement(By.id("contactPhone")).sendKeys("6514685841");
    driver.findElement(By.id("submit")).click();
    driver.findElement(By.id("address-firstName")).clear();
    driver.findElement(By.id("address-firstName")).sendKeys("Samik");
    driver.findElement(By.id("address-lastName")).clear();
    driver.findElement(By.id("address-lastName")).sendKeys("Banerjee");
    driver.findElement(By.id("compayName")).clear();
    driver.findElement(By.id("compayName")).sendKeys("1920");
    driver.findElement(By.id("address-line1")).clear();
    driver.findElement(By.id("address-line1")).sendKeys("4280 Albany Drive");
    driver.findElement(By.id("address-line2")).clear();
    driver.findElement(By.id("address-line2")).sendKeys("J223");
    driver.findElement(By.id("address-town")).clear();
    driver.findElement(By.id("address-town")).sendKeys("San Jose");
    new Select(driver.findElement(By.id("regionIso"))).selectByVisibleText("CALIFORNIA");
    driver.findElement(By.id("address-zip")).clear();
    driver.findElement(By.id("address-zip")).sendKeys("9529");
    driver.findElement(By.id("continue-address-btn")).click();
    driver.findElement(By.id("suggest-address-btn")).click();
    new Select(driver.findElement(By.id("selectMethod"))).selectByVisibleText("Standard ($0.00)");
    driver.findElement(By.id("shipping-methods-continue")).click();
    driver.findElement(By.id("billShippingAddress")).click();
    // ERROR: Caught exception [ERROR: Unsupported command [selectWindow | name=partner-frame | ]]
    new Select(driver.findElement(By.id("ccins"))).selectByVisibleText("VISA");
    driver.findElement(By.id("ccname")).clear();
    driver.findElement(By.id("ccname")).sendKeys("samik");
    driver.findElement(By.id("ccnum_display")).clear();
    driver.findElement(By.id("ccnum_display")).sendKeys("4111111111111111");
    driver.findElement(By.id("expDateMonth")).clear();
    driver.findElement(By.id("expDateMonth")).sendKeys("9");
    driver.findElement(By.id("expDateYear")).clear();
    driver.findElement(By.id("expDateYear")).sendKeys("2022");
    driver.findElement(By.id("cvval_display")).clear();
    driver.findElement(By.id("cvval_display")).sendKeys("234");
    driver.findElement(By.id("submitButton")).click();
    driver.findElement(By.id("expDateMonth")).clear();
    driver.findElement(By.id("expDateMonth")).sendKeys("09");
    driver.findElement(By.id("submitButton")).click();
    // ERROR: Caught exception [ERROR: Unsupported command [selectWindow | null | ]]
    driver.findElement(By.id("billing-button")).click();
    driver.findElement(By.id("termChkBoxLarge")).click();
    driver.findElement(By.id("submitRepairButton")).click();
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
