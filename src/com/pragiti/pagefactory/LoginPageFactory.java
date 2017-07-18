package com.pragiti.pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPageFactory extends AbstractPageFactory{

	/**
	 * All WebElements are identified by @FindBy annotation
	 */
	@FindBy(id="j_username")
	WebElement j_username;

	@FindBy(id="j_password")
	WebElement j_password;

	@FindBy(className ="positive")
	WebElement login;

	@FindBy(css ="div.alert.negative")
	WebElement erroMsg;
	
	@FindBy(linkText="My Account")
	WebElement myAccountLink;


	// update password 
		public LoginPageFactory(WebDriver driver){
		this.driver = driver;
		//This initElements method will create  all WebElements
		PageFactory.initElements(driver, this);
	}

	//Set user name in textbox
	public void setUserName(String strUserName){
		j_username.sendKeys(strUserName);

	}
	//Set password in password textbox
	public void setPassword(String strPassword){
		j_password.sendKeys(strPassword);
	}

	//Click on login button
	public void clickLogin(){
		login.click();
	}

	public WebElement getJ_username() {
		return j_username;
	}
	public WebElement getJ_password() {
		return j_password;
	}
	public WebElement getLogin() {
		return login;
	}
	public WebElement getErroMsg() {
		return erroMsg;
	}

	/**
	 * This POM method will be exposed in test case to login in the application
	 * @param strUserName
	 * @param strPasword
	 * @return
	 */
	public void doLogin(String strUserName,String strPasword){
		//Fill user name
		this.setUserName(strUserName);
		//Fill password
		this.setPassword("");
		this.setPassword(strPasword);
		//Click Login button
		this.clickLogin();
	}
	
	public void clickMyAccountLink(){
		myAccountLink.click();
	}

}