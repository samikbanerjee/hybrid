package com.pragiti.pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddressPopUpPageFactory extends AbstractPageFactory {
	/**
	 * All WebElements are identified by @FindBy annotation
	 */

	@FindBy(xpath="//div[@id='savedAddressList']")
	WebElement popUp;


	public WebElement getPopUp() {
		return popUp;
	}

	@FindBy(xpath="//form[@id='command']/button")
	WebElement addressRemove;

	public void clickRemove(){
		addressRemove.click();
	}
	public WebElement getAddressUsed() {
		return addressused;
	}

	@FindBy(xpath=".//*[@id='savedAddressList']/div[2]/div[1]")
	WebElement addressused;

	@FindBy(xpath="//button[@class='positive left']")
	WebElement useThisAddress;



	public void clickUseThisAddress(){
		useThisAddress.click();
	}
	@FindBy(id="viewAddressBook")
	WebElement viewAddressBook;

	public void clickAddressBook(){
		viewAddressBook.click();
	}
	
	public AddressPopUpPageFactory(WebDriver driver){
		this.driver = driver;
		//This initElements method will create  all WebElements
		PageFactory.initElements(driver, this);
	}
	
	

	// To test the visibility of the pop-up in the address book
	public void popup(){

		WebDriverWait wait = new WebDriverWait(driver,5);
		WebElement menu = wait.until(ExpectedConditions.visibilityOf(this.getPopUp()));//Mouse over on pop up
		WebElement menu1= wait.until(ExpectedConditions.visibilityOf(this.getAddressUsed()));
		Actions build = new Actions(driver); // hear you state ActionBuider
		build.moveToElement(menu).moveToElement(menu1).perform(); // Here you perform hover mouse over the needed element to trigger the visibility

	}

	// Use address in the address book
	public void useAddress(){
		this.popup();
		this.clickUseThisAddress();

	}
	
	// Remove address from the address book
	public void removeAddress(){
		this.clickAddressBook();
		this.popup();
		this.clickRemove();

	}
}
