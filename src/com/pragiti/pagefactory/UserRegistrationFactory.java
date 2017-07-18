package com.pragiti.pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class UserRegistrationFactory extends AbstractPageFactory {

	/**
	 * All WebElements are identified by @FindBy annotation
	 */

	@FindBy(xpath="//div[contains(@class, 'userRegister')]")
	WebElement registerform;


	@FindBy(id="register.title")
	WebElement title;

	@FindBy(id="register.firstName")
	WebElement firstname;

	@FindBy(id="register.lastName")
	WebElement lastName;

	@FindBy(id="register.email")
	WebElement user_email;

	@FindBy(id="password")
	WebElement password;

	@FindBy(id="register.checkPwd")
	WebElement checkPwd;


	@FindBy(xpath="//form[@id='registerForm']//button")
	WebElement registerbutton;

	@FindBy(xpath="(//div[@class='help-inline']/span[@id='email.errors'])")
	WebElement accountexists;

	@FindBy(linkText="Sign Out")
	WebElement signout;



	public UserRegistrationFactory(WebDriver driver) {
		//This initElements method will create  all WebElements

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public WebElement getRegisterform() {
		return registerform;
	}

	public WebElement getSignout() {
		return signout;
	}

	public WebElement getAccountexists() {
		return accountexists;
	}


	//To test user register using the form
	public void doRegistration(String titleoption,String fname ,String lname , String email , String pwd, String chkpwd)
	{
		Select titleoptions=  new Select(title);
		titleoptions.selectByVisibleText(titleoption);

		firstname.sendKeys(fname);

		lastName.sendKeys(lname);


		user_email.sendKeys(email);

		password.sendKeys(pwd);

		checkPwd.sendKeys(chkpwd);
		registerbutton.click();
	}

}

