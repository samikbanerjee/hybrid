package com.pragiti.pagefactory;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;

public class AbstractPageFactory 
{

	  WebDriver  driver;

	  // Gets the page title of the current page.
	public String getPageTitle(WebDriver driver) {
		return driver.getTitle();
	}

	// Here the expected page title and the current page title are compared.
	public boolean verifyBasePageTitle(String expectedPageTitle, WebDriver driver) {
		assertEquals(driver.getTitle(), expectedPageTitle);
		return getPageTitle(driver).contains(expectedPageTitle);
		
	}
}
