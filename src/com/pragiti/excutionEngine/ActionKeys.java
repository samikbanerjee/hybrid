package com.pragiti.excutionEngine;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ActionKeys {
	
	private static final int TIMEOUT_IN_SECONDS = 20;
	private static final int DEFAULT_PAUSE=3000;
	private WebDriver dr;
	
	public ActionKeys(WebDriver driver) {
		dr=driver;
	}
	
	
	public void executeAction(String appUrl, String action,String elementIdentifier, 
			String elementIdentifierValue, String inputVal, String description) throws InterruptedException{
		switch (action) {
	
		case "open": this.openUrl(appUrl, inputVal);
			break;
		case "click": this.click(elementIdentifier, elementIdentifierValue);
			break;
		case "type": this.type(elementIdentifier, elementIdentifierValue, inputVal);
			break;
		case "pause": this.pause(inputVal);
			break;
		case "select": this.select(elementIdentifier, elementIdentifierValue, inputVal);
			break;
		case "selectWindow": this.selectWindow(elementIdentifier, elementIdentifierValue);
			break;
		case "moveToElement": this.moveToElement(elementIdentifier, elementIdentifierValue);
			break;
		case "key": this.key(inputVal);
			break;
		case "assertText": this.assertText(elementIdentifier, elementIdentifierValue, inputVal);
			break;
		case "clickback": this.clickback();
			break;
		case "scrolldown" : this.scrolldown(elementIdentifier, elementIdentifierValue);
			break;
		case "clickAndWait" : this.clickAndWait(elementIdentifier, elementIdentifierValue);
		break;

		default:
			break;
		}
		
	}
	
	
	public void clickAndWait(String elementIdentifier, String elementIdentifierValue) throws InterruptedException {
		click(elementIdentifier, elementIdentifierValue);
		Thread.sleep(DEFAULT_PAUSE);	
	}


	public void assertText(String elementIdentifier, String elementIdentifierValue, String inputVal){
		WebElement el=findElement(elementIdentifier, elementIdentifierValue);
		org.testng.Assert.assertEquals(el.getText(), inputVal);
	}
	
	public void moveToElement(String elementIdentifier, String elementIdentifierValue){
		WebElement el=findElement(elementIdentifier, elementIdentifierValue);
		Actions actions = new Actions(dr);
		actions.moveToElement(el);
		actions.perform();
	}
	
	 public void clickback(){
		  dr.navigate().back();
		  
	  }
	  
	public void scrolldown(String elementIdentifier, String elementIdentifierValue){
		 ((JavascriptExecutor)dr).executeScript("arguments[0].scrollIntoView();",findElement(elementIdentifier, elementIdentifierValue));
	 }
  
	
	public void key(String keySeq){	
		CharSequence keysToSend;
		switch (keySeq) {
		case "TAB": keysToSend=Keys.TAB;
			break;
		case "ENTER": keysToSend=Keys.RETURN;
			break;
		
		default:keysToSend=Keys.RETURN;
			break;
		}
		WebElement el=dr.switchTo().activeElement();
		el.sendKeys(keysToSend);;
	}
	
	public void pause(String inputVal) throws InterruptedException{
		int t=Integer.parseInt(inputVal);
		Thread.sleep(t);
	}
	
	public void openUrl(String appUrl,String inputVal) {
		dr.get(appUrl+ inputVal);
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
	
	public void select(String elementIdentifier, String elementIdentifierValue, String inputVal){
		WebElement el=findElement(elementIdentifier, elementIdentifierValue);
		new Select(el).selectByVisibleText(inputVal);
	}
	
	public void selectWindow(String elementIdentifier, String elementIdentifierValue){
		if(elementIdentifierValue.equalsIgnoreCase("null"))
		{
			dr.switchTo().defaultContent();
		}
		else
		{
			WebElement el=findElement(elementIdentifier, elementIdentifierValue);
			dr.switchTo().frame(el);
		}
	}
	
	
	public WebElement findElement(String elementIdentifier, String elementIdentifierValue){	
		return (new WebDriverWait(dr, TIMEOUT_IN_SECONDS)).until(ExpectedConditions.presenceOfElementLocated(findLocator(elementIdentifier, elementIdentifierValue)));
		//return dr.findElement(findLocator(elementIdentifier, elementIdentifierValue));
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