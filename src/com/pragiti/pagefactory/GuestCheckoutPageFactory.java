package com.pragiti.pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GuestCheckoutPageFactory  extends AbstractPageFactory{

	/**
	 * All WebElements are identified by @FindBy annotation
	 */

	@FindBy(id="guest.email")
	WebElement guestEmail;


	public WebElement getGuestEmail() {
		return guestEmail;
	}


	public void setGuestEmail(String strUserName) {
		guestEmail.sendKeys(strUserName);

	}


	@FindBy(xpath="//button[contains(text(),'Checkout as a Guest')]")
	WebElement guestCheckoutButton;


	public WebElement getGuestCheckoutButton() {
		return guestCheckoutButton;
	}

	@FindBy(id="j_username")
	WebElement regUser;

	public WebElement getRegUser() {
		return regUser;
	}

	public void setRegUserEmail(String strUserName) {
		regUser.sendKeys(strUserName);

	}
	@FindBy(id="j_password")
	WebElement password;

	public WebElement getPassword() {
		return password;
	}

	public void setPassword(String strUserName) {
		password.sendKeys(strUserName);

	}



	//Click on guestCheckoutButton
	public void clickGuestCheckout(){
		guestCheckoutButton.click();
	}

	@FindBy(xpath="//button[contains(text(),'Login and Checkout')]")
	WebElement loginCheckoutButton;


	public WebElement getLoginCheckoutButton() {
		return loginCheckoutButton;
	}	

	//Click on guestCheckoutButton
	public void clickloginCheckout(){
		loginCheckoutButton.click();
	}



	public void doGuestCheckout(String strUserName)
	{
		//Fill user name
		this.setGuestEmail(strUserName);

		//Click guestCheckoutButton
		this.clickGuestCheckout();
	}


	public void doLoginCheckout(String strUserName,String password)
	{
		//Fill user name
		this.setRegUserEmail(strUserName);
		this.setPassword(password);
		//Click loginCheckoutButton
		this.clickloginCheckout();
	}

	public GuestCheckoutPageFactory(WebDriver driver){
		this.driver = driver;
		//This initElements method will create  all WebElements
		PageFactory.initElements(driver, this);
	}


}


