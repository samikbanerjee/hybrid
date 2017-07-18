package com.pragiti.pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShippingMethodPageFactory extends AbstractPageFactory {
	
	/**
	 * All WebElements are identified by @FindBy annotation
	 */
	
	@FindBy(xpath="//li[@class='active']/a[contains(text(),'Shipping Method')]")
	WebElement  ShippingMethod;
	
	public WebElement getShippingMethod() {
		return ShippingMethod;
	}
	
	@FindBy(id="chooseDeliveryMethod_continue_button")
	WebElement continueButton;
	
	
	@FindBy(id="standard-gross")
	WebElement standardGross;
	
	public void clickStandardGross(){
		standardGross.click();
	}
	
	
	@FindBy(id="premium-gross")
	WebElement premiumGross;
	
	public void clickPremiumGross(){
		premiumGross.click();
	}
	
	public void clickContinueButton(){
		continueButton.click();
	}
	
	
	public void selectDiliveryMethod()
	{
		this.clickStandardGross();
		this.clickContinueButton();
	}
	
	@FindBy(xpath="//div[@class='form-actions']/a[@class='button']")
	WebElement cancel;

	public void clickCancel(){
		cancel.click();
	}

	public ShippingMethodPageFactory(WebDriver driver){
		this.driver = driver;
		//This initElements method will create  all WebElements
		PageFactory.initElements(driver, this);
	}

}
