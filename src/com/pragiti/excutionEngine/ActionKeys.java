package com.pragiti.excutionEngine;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ActionKeys {
	
	private static final int TIMEOUT_IN_SECONDS = 20;
	private WebDriver dr;
	
	public ActionKeys(WebDriver driver) {
		dr=driver;
	}
	
	
	public void executeAction(String action,String elementIdentifier, 
			String elementIdentifierValue, String inputVal, String assertVal) throws InterruptedException{
		switch (action) {
		case "openUrl": this.openUrl(inputVal);
			break;
		case "click": this.click(elementIdentifier, elementIdentifierValue);
			break;
		case "type": this.type(elementIdentifier, elementIdentifierValue, inputVal);
			break;
		case "pause": this.pause(inputVal);
			break;
		default:
			break;
		}
	}
	
	
	
	public void pause(String inputVal) throws InterruptedException{
		int t=Integer.parseInt(inputVal);
		Thread.sleep(t);
	}
	
	public void openUrl(String inputVal) {
		dr.get(inputVal);
	}
	
	public void click(String elementIdentifier, String elementIdentifierValue){
		WebElement el=findElement(elementIdentifier, elementIdentifierValue);
		el.click();
	}
	
	public void type(String elementIdentifier, String elementIdentifierValue, String inputVal){
		WebElement el=findElement(elementIdentifier, elementIdentifierValue);
		el.clear();
		el.sendKeys(inputVal);
	}
	
	
	public WebElement findElement(String elementIdentifier, String elementIdentifierValue){	
		return (new WebDriverWait(dr, TIMEOUT_IN_SECONDS))
				.until(ExpectedConditions.presenceOfElementLocated(findLocator(elementIdentifier, elementIdentifierValue)));
	}
	
	public By findLocator(String elementIdentifier, String elementIdentifierValue){
		By locator;
		
		switch (elementIdentifier) 
		{
			case "className":  locator=By.className(elementIdentifierValue);	
				break;
			case "cssSelector":  locator=By.cssSelector(elementIdentifierValue);	
				break;
			case "id":  locator=By.id(elementIdentifierValue);	
				break;
			case "linkText":  locator=By.linkText(elementIdentifierValue);	
				break;
			case "name":  locator=By.name(elementIdentifierValue);	
				break;
			case "partialLinkText":  locator=By.partialLinkText(elementIdentifierValue);	
				break;
			case "tagName":  locator=By.tagName(elementIdentifierValue);	
				break;
			case "xpath":  locator=By.xpath(elementIdentifierValue);	
				break;
			default: locator=By.xpath(elementIdentifierValue);	
				break;
		}		
		return locator;

	}
	
}